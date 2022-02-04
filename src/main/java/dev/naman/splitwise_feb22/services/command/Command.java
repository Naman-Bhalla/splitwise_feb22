package dev.naman.splitwise_feb22.services.command;

public interface Command {
    boolean matches(String input);
    void execute(String input);
}
