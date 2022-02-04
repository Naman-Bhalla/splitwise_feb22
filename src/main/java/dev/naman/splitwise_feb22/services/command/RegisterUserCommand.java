package dev.naman.splitwise_feb22.services.command;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RegisterUserCommand implements Command {

    @Override
    public boolean matches(String input) {
        // Register vinsmokesanji 003 namisswwaann

        List<String> inputList = Arrays.stream(input.split(" ")).toList();

        if (inputList.size() == 4 && inputList.get(0).equals(CommandKeywords.RegisterUserCommand)) {
            return true;
        }

        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("Registering User");
    }

}
