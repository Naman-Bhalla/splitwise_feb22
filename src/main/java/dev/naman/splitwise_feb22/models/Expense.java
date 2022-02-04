package dev.naman.splitwise_feb22.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {
    private Currency currency;

    // expense - user
    // 1         1
    // m         1
    // m:1
    @ManyToOne
    private User createdBy;

    private String description;

    private Long amount;

//    // expense - user
//    // 1   m
//    // m    1
//    @ManyToMany
//    private List<User> participatingUsers;

    @ElementCollection // expense_user_paid_by_mapping
    private Map<User, Long> paidBy;

    @ElementCollection // expense_user_owed_by_mapping
    private Map<User, Long> owedBy;
}

// Expense A
// createdBY E
// paid by:
// E 100
// F 20
// G 30
// H 50
// owed by:
// F 100
// G 50
// I 50