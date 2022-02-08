package dev.naman.splitwise_feb22.services.groupservice;

import dev.naman.splitwise_feb22.exceptions.GroupDoesntExistException;
import dev.naman.splitwise_feb22.models.Expense;
import dev.naman.splitwise_feb22.models.Group;
import dev.naman.splitwise_feb22.models.GroupExpense;
import dev.naman.splitwise_feb22.models.User;
import dev.naman.splitwise_feb22.repositories.GroupExpenseRepository;
import dev.naman.splitwise_feb22.repositories.GroupRepository;
import dev.naman.splitwise_feb22.services.strategies.settleupexpensestrategy.SettleUpExpensesStrategy;
import dev.naman.splitwise_feb22.services.strategies.settleupexpensestrategy.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupExpenseRepository groupExpenseRepository;

    @Autowired
    private SettleUpExpensesStrategy settleUpExpensesStrategy;


    private boolean checkIfUserExists(Long userId, List<User> members) {
        for (User user: members) {
            if (user.getId().equals(userId)) {
                return true;
            }
        }

        return false;
    }

    private List<Expense> getExpensesFromGroupExpenses(List<GroupExpense> groupExpenses) {
        List<Expense> expenses = new ArrayList<>();

        for (GroupExpense groupExpense: groupExpenses) {
            expenses.add(groupExpense.getExpense());
        }

        return expenses;
    }

    public List<Transaction> settleUp(Long userId,
                                      Long groupId) throws GroupDoesntExistException {
        Optional<Group> group = groupRepository.findById(groupId);

        if (group.isEmpty()) {
            throw new GroupDoesntExistException(groupId);
        }

        boolean userExists = checkIfUserExists(userId, group.get().getMembers());

        if (!userExists) {
            // throw authorization exception
        }


        List<GroupExpense> groupExpenses = groupExpenseRepository.
                findAllByGroup(group.get());

        List<Expense> expenses = getExpensesFromGroupExpenses(groupExpenses);

        List<Transaction> transactions = settleUpExpensesStrategy
                .settleUp(expenses);

        return transactions;
    }
}

// Option<> {}
// At end of today's class
// project structure
// spring - controllers,. models, services
// code by feature not by use
// user/ -> SRP
//    UserController.java
//    UserService.java
//    UserRepository.java
//    User.java
//    exceptions/
//        UserInvalidException.java
// group/
//    GroupController.java
//    Group.java
//
// Angular
// Flutter
// RoR, Django,. Spring, -> MVC

