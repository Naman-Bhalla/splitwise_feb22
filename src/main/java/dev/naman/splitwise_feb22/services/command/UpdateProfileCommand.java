package dev.naman.splitwise_feb22.services.command;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UpdateProfileCommand implements Command {
    private static final int size = 3;

    @Override
    public void execute(String input) {

    }

    @Override
    public boolean matches(String input) {
        // u1 UpdateProfile robinchwan

        List<String> inputList = Arrays.stream(input.split(" ")).toList();

        if (inputList.size() == size && inputList.get(1).equals(CommandKeywords.UpdateProfileCommand)) {
            return true;
        }

        return false;
    }
}
