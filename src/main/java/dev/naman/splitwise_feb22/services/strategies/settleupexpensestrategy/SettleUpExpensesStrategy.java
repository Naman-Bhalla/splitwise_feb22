package dev.naman.splitwise_feb22.services.strategies.settleupexpensestrategy;

import dev.naman.splitwise_feb22.models.Expense;

import java.util.List;

public interface SettleUpExpensesStrategy {

    List<Transaction> settleUp(List<Expense> expenses);
}
