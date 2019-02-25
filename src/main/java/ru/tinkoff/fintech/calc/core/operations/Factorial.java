package ru.tinkoff.fintech.calc.core.operations;

public class Factorial implements Operation {

    @Override
    public Integer performingOperation(Integer operand1) {
        if (operand1<0) {
            operand1*=(-1);
        }
        int result = 1;
        for (int i = 1; i <= operand1; i++) {
            result *= i;
        }
        return result;
    }

}
