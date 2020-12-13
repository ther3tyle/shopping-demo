package io.dsub.shoppingdemo.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends BaseException {

    @Override
    HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    // todo: take email
    public UserAlreadyExistsException(String message) {
        super("username of " + message + " already exists");
    }
}
