package dev.naman.splitwise_feb22;

import dev.naman.splitwise_feb22.services.command.RegisterUserCommand;
import dev.naman.splitwise_feb22.services.command.UpdateProfileCommand;
import dev.naman.splitwise_feb22.services.command.registry.CommandRegistry;
import dev.naman.splitwise_feb22.services.command.registry.CommandRegistryImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SplitwiseFeb22Application {

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseFeb22Application.class, args);

        RegisterUserCommand registerUserCommand = new RegisterUserCommand();
        UpdateProfileCommand updateProfileCommand = new UpdateProfileCommand();

        CommandRegistry commandRegistry = new CommandRegistryImp();
        commandRegistry.registerCommand(registerUserCommand);
        commandRegistry.registerCommand(updateProfileCommand);

        String input = "u1 123 123";// read from command line

        commandRegistry.executeCommand(input);
        // while (true) {
        //   get input = readigng a  string from comamnd line
        //   parse input
        //   find the correct command (validate params)
        //   execute the command
        // }
        // I need a place where I can register the command
        // and that allows to parse commands to find the correct command out
        // of the ones that are registered
    }

}



// v0 -> {}
// v1 -> {abc}
// v2 -> {abc, def}


// v3

// Server 1 v0

// Server 2 : v2

// Server 3: v1