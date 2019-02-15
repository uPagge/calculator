package ru.tinkoff.fintech.calc.core.operations;

import ru.tinkoff.fintech.calc.core.exception.WrongNumberOfParameters;

public interface Operation {

    default Integer performingOperation(Integer operand1, Integer operand2) throws WrongNumberOfParameters {
        throw new WrongNumberOfParameters();
    }

    default Integer performingOperation(Integer operand1) throws WrongNumberOfParameters {
        throw new WrongNumberOfParameters();
    }

}
