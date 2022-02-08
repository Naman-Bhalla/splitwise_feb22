package dev.naman.splitwise_feb22.services.strategies.settleupexpensestrategy;

import dev.naman.splitwise_feb22.models.Expense;
import dev.naman.splitwise_feb22.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LinearGreedySettleUpStrategy implements SettleUpExpensesStrategy {


    // [A, B, C, D]
    // [100, 200, 0, 0]

    private Transaction createTransaction(User from, User to, Long amount) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setFrom(from);
        transaction.setTo(to);

        return transaction;
    }


    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        Map<User, Long> totalExtraPaid = new HashMap<>();

        for (Expense expense: expenses) {

            for (User user: expense.getPaidBy().keySet()) {
                if (!totalExtraPaid.containsKey(user)) {
                    totalExtraPaid.put(user, 0L);
                }
                totalExtraPaid.put(user, totalExtraPaid.get(user) + expense.getPaidBy().get(user));
            }

            for (User user: expense.getOwedBy().keySet()) {
                if (!totalExtraPaid.containsKey(user)) {
                    totalExtraPaid.put(user, 0L);
                }
                totalExtraPaid.put(user, totalExtraPaid.get(user) - expense.getOwedBy().get(user));
            }
        }

        List<User> users = totalExtraPaid.keySet().stream().toList();

        List<Transaction> transactions = new ArrayList<>();

        for (int i = 0; i < users.size() - 1; ++i) {
            User currentUser = users.get(i);
            User nextUser = users.get(i + 1);
            Long extraPaid = totalExtraPaid.get(currentUser);
            if (extraPaid > 0) {
                transactions.add(
                  createTransaction(nextUser, currentUser, extraPaid)
                );

                totalExtraPaid.put(nextUser, totalExtraPaid.get(nextUser) + extraPaid);
                totalExtraPaid.put(currentUser, 0L);
            } else if (extraPaid < 0) {
                transactions.add(
                        createTransaction(currentUser, nextUser, -extraPaid)
                );

                totalExtraPaid.put(nextUser, totalExtraPaid.get(nextUser) - (-extraPaid));
                totalExtraPaid.put(currentUser, 0L);
            }

        }

        return transactions;
    }
}

// np hard
// O( 2 ^ N) N -> Number of transactions
// NP Hard: Problems that don't have a polynomial time solution
// N Queens -> NP hard
// Knapsack
// P = NP
// each NP hard problems can be converged to another NP hard problem
//

