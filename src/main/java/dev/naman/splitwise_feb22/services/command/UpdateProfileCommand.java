package dev.naman.splitwise_feb22.services.command;

import dev.naman.splitwise_feb22.controllers.UserController;
import dev.naman.splitwise_feb22.dto.UpdateProfileRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Component
public class UpdateProfileCommand implements Command {
    private static final int size = 3;

    @Autowired
    private UserController userController;

    @Override
    public void execute(String input) {
        List<String> inputList = Arrays.stream(input.split(" ")).toList();

        Long userId = Long.parseLong(inputList.get(0));
        String newPassword = inputList.get(2);

        UpdateProfileRequestDto updateProfileRequestDto = new UpdateProfileRequestDto();
        updateProfileRequestDto.setNewPassword(newPassword);
        updateProfileRequestDto.setUserId(userId);

        userController.updateProfile(updateProfileRequestDto);

        System.out.println("Updated User");
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
