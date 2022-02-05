package dev.naman.splitwise_feb22.services.command;

import dev.naman.splitwise_feb22.controllers.UserController;
import dev.naman.splitwise_feb22.dto.RegisterUserRequestDTO;
import dev.naman.splitwise_feb22.dto.RegisterUserResponseDTO;
import dev.naman.splitwise_feb22.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Component
public class RegisterUserCommand implements Command {
    @Autowired
    private UserController userController;

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
        List<String> inputList = Arrays.stream(input.split(" ")).toList();
        String username = inputList.get(1);
        String phoneNumber = inputList.get(2);
        String password = inputList.get(3);

        RegisterUserRequestDTO registerUserRequestDTO = new RegisterUserRequestDTO();
        registerUserRequestDTO.setName(username);
        registerUserRequestDTO.setPassword(password);
        registerUserRequestDTO.setPhoneNumber(phoneNumber);

        ResponseDTO<RegisterUserResponseDTO> response = userController.
                registerUser(registerUserRequestDTO);
        System.out.println("Registering User");
    }

}

// Dependency Inversion= D of SOLID.
// No 2 classes should vbe directly dependent on each other. THey should depend
// on each other via an abstraction layer


// Dependecy Injection
// The dependencies of a class are not created by the class, but passed t the class via constructor
// Inversion of Control
// Framework will create the dependencies and wirew them into the concrete objects;
