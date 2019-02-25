package ru.tinkoff.fintech.calc.core.operations;

public class Division implements Operation {

    @Override
    public Integer performingOperation(Integer operand1, Integer operand2) { return operand1 / operand2; }

}
