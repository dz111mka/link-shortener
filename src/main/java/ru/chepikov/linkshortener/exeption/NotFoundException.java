package ru.chepikov.linkshortener.exeption;


public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
