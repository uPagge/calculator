package ru.tinkoff.fintech.calc.core.operations;

import ru.tinkoff.fintech.calc.core.operations.Operation;

public class Multiplication implements Operation {

    @Override
    public Integer performingOperation(Integer operand1, Integer operand2) {
        return operand1 * operand2;
    }
}
