package ru.tinkoff.fintech.calc.core.operations.impl;

import ru.tinkoff.fintech.calc.core.operations.Operation;

public class Multiplication implements Operation {

    @Override
    public Integer operation(Integer operand1, Integer operand2) {
        return operand1 * operand2;
    }
}
