package ru.tinkoff.fintech.calc.core.operations;

public class Subtraction implements Operation {

    @Override
    public Integer performingOperation(Integer operand1, Integer operand2) {
        return (operand2 < 0) ? operand1 - operand2 * (-1) : operand1 - operand2;
    }
}
