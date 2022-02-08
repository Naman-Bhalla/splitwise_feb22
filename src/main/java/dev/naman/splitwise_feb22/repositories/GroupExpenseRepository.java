package dev.naman.splitwise_feb22.repositories;

import dev.naman.splitwise_feb22.models.Group;
import dev.naman.splitwise_feb22.models.GroupExpense;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Long> {

    List<GroupExpense> findAllByGroup(Group group);
}
