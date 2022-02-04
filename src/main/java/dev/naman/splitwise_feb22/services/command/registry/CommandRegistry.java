package dev.naman.splitwise_feb22.services.command.registry;

import dev.naman.splitwise_feb22.services.command.Command;

public interface CommandRegistry {

    void registerCommand(Command command);

    void executeCommand(String command);
}
