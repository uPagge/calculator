package ru.tinkoff.fintech.calc.core.operations;

public class Factorial implements Operation {

    @Override
    public Integer performingOperation(Integer operand1) {
        int result = 1;
        if (operand1 < 0) {
            for (int i = 1; i <= operand1 * (-1); i++) {
                result *= i;
            }
            result *= (-1);
        } else {
            for (int i = 1; i <= operand1; i++) {
                result *= i;
            }
        }
        return result;
    }

}
