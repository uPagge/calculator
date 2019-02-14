package ru.tinkoff.fintech.calc.core.operations.impl;

import ru.tinkoff.fintech.calc.core.operations.Operation;

public class Power implements Operation {

    @Override
    public Integer chooseOperation(Integer oper1, Integer oper2) {
        return Math.toIntExact(Math.round(Math.pow(oper1, oper2)));
    }
}
