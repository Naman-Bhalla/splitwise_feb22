package dev.naman.splitwise_feb22.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends BaseModel{

    private String name;

    // group - user
    // 1        1
    // m        1
    // m:1
    @ManyToOne
    private User admin;

    // group - user
    //  1       m
    //  m        1
    @ManyToMany
    private List<User> members;

//    private List<Expense> expenses;

}


// User {
//   @OneToOne
//   Group adminOf;
// }

// Group {
//   @OneToOne(mappedBy="adminOf")
//   User admin;
// }
// java persistence tutorial