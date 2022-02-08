package dev.naman.splitwise_feb22.services.strategies.settleupexpensestrategy;

import dev.naman.splitwise_feb22.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User from;
    private User to;
    private Long amount;
}
