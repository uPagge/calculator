package ru.tinkoff.fintech.calc.core.operations;

import ru.tinkoff.fintech.calc.core.operations.Operation;

public class Exponentiation implements Operation {

    @Override
    public Integer performingOperation(Integer operand1, Integer operand2) {
        return Math.toIntExact(Math.round(Math.pow(operand1, operand2)));
    }
}
