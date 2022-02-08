package dev.naman.splitwise_feb22.exceptions;

public class GroupDoesntExistException extends Exception {
    public GroupDoesntExistException(Long id) {
        super("Group with id: " + id + " doesn't exist");
    }
}
