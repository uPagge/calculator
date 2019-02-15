package ru.tinkoff.fintech.calc.core.exception;

public class WrongNumberOfParameters extends Exception {

    public WrongNumberOfParameters() {

    }

    public WrongNumberOfParameters(String message) {
        super(message);
    }
}
