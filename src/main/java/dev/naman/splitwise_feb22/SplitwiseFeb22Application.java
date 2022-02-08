package dev.naman.splitwise_feb22;

import dev.naman.splitwise_feb22.services.command.RegisterUserCommand;
import dev.naman.splitwise_feb22.services.command.SettleUpGroupCommand;
import dev.naman.splitwise_feb22.services.command.UpdateProfileCommand;
import dev.naman.splitwise_feb22.services.command.registry.CommandRegistry;
import dev.naman.splitwise_feb22.services.command.registry.CommandRegistryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseFeb22Application implements CommandLineRunner {

    @Autowired
    private RegisterUserCommand registerUserCommand;

    @Autowired
    private UpdateProfileCommand updateProfileCommand;

    @Autowired
    private SettleUpGroupCommand settleUpGroupCommand;

    @Autowired
    private CommandRegistry commandRegistry;

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseFeb22Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        commandRegistry.registerCommand(registerUserCommand);
        commandRegistry.registerCommand(updateProfileCommand);
        commandRegistry.registerCommand(settleUpGroupCommand);

        String input = "Register vinsmokesanji 003 namisswwaann";// read from command line

        commandRegistry.executeCommand(input);

        input = "2 UpdateProfile robinchwan";

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