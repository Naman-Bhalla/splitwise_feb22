package dev.naman.splitwise_feb22.services.command.registry;

import dev.naman.splitwise_feb22.services.command.Command;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandRegistryImp implements CommandRegistry {

    List<Command> registeredCommands = new ArrayList<>();

    @Override
    public void registerCommand(Command command) {
        registeredCommands.add(command);
    }

    @Override
    public void executeCommand(String input) {
        for (Command c: registeredCommands) {
            if (c.matches(input)) {
                c.execute(input);
                return;
            }
        }
    }
}
