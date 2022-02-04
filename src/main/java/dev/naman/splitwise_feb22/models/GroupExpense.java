package dev.naman.splitwise_feb22.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class GroupExpense extends BaseModel {
    // g_e - g
    // 1     1
    // m     1
    @ManyToOne
    private Group group;

    // g_e - e
    // 1     1
    // 1     1
    @OneToOne
    private Expense expense;
} // 1 1
// 1 2
// 1 3

