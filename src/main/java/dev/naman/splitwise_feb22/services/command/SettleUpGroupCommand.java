package dev.naman.splitwise_feb22.services.command;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SettleUpGroupCommand implements Command {

    @Override
    public boolean matches(String input) {
        List<String> command = Arrays.stream(input.split(" ")).toList();

        if (command.size() == 3 && command.get(1).equals(CommandKeywords.SettleUpCommand)) {
            return true;
        }

        return false;
    }

    @Override
    public void execute(String input) {

    }
}
