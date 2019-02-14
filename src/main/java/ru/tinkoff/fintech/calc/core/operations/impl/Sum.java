package ru.tinkoff.fintech.calc.core.operations.impl;

import ru.tinkoff.fintech.calc.core.operations.Operation;

public class Sum implements Operation {

    @Override
    public Integer chooseOperation(Integer oper1, Integer oper2) {
        return oper1+oper2;
    }
}
