package dev.naman.splitwise_feb22.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseModel {
    private String name;
    private String phoneNumber;
    private String hashedPassword;

//    // user - expense
//    //  1     m
//    //  1      1
//    // 1:m
//    @OneToMany(mappedBy = "createdBy")
//    private List<Expense> createdExpenses;
}

// in 1toX