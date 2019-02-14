package ru.tinkoff.fintech.calc.core.service;

public class Operation {

    public static Integer chooseOperation(Integer operand1, Integer operand2, OperationEnum operation) {
        Integer result = null;
        switch (operation) {
            case SUM:
                result = sum(operand1, operand2);
                break;
            case SUB:
                result = sub(operand1, operand2);
                break;
            case MUL:
                result = mul(operand1, operand2);
                break;
            case DIV:
                result = div(operand1, operand2);
                break;
        }
        return result;
    }

    private static Integer sum(Integer addend1, Integer addend2) {
        return addend1 + addend2;
    }

    private static Integer sub(Integer minuend, Integer subtrahend) {
        return minuend - subtrahend;
    }

    private static Integer div(Integer dividend, Integer divider) {
        return dividend / divider;
    }

    private static Integer mul(Integer multiplicand, Integer multiplier) {
        return multiplicand * multiplier;
    }

}
