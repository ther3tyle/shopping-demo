package io.dsub.shoppingdemo.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String message) {
        super("username " + message + " not found");
    }

    @Override
    HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
