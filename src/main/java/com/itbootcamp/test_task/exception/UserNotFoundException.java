package com.itbootcamp.test_task.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Integer id) {
        super("User with id=" + id + " was not found.");
    }

}
