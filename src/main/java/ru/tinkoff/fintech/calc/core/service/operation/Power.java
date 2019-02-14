package ru.tinkoff.fintech.calc.core.service.operation;

import ru.tinkoff.fintech.calc.core.service.Operation;

public class Power implements Operation {

    @Override
    public Integer chooseOperation(Integer oper1, Integer oper2) {
        return Math.toIntExact(Math.round(Math.pow(oper1, oper2)));
    }
}
