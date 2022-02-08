package dev.naman.splitwise_feb22.controllers;

import dev.naman.splitwise_feb22.dto.ResponseDTO;
import dev.naman.splitwise_feb22.dto.SettleUpGroupRequestDTO;
import dev.naman.splitwise_feb22.dto.SettleUpResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class GroupController {

    public ResponseDTO<SettleUpResponseDTO> settleUpExpenses(
            SettleUpGroupRequestDTO request
    ) {
        // 1. Check if u1 belongs to the group
        // 2.Fetch all expenses in the group
        // 3. Use an algorith to find the list of transacvtion
        // that will settle up everyone
        // 4. Return the list
        return null;
    }
}

// settleUpExpense
// List<Transaction>
// from -> to -> amount
// [
//    {
//      from: Naman,
//      to: Sachin,
//       amount: 20,
//    },
//    {
//       from: Vikram,
//        to: Naman,
//        amount: 40
//    }
//
// ]