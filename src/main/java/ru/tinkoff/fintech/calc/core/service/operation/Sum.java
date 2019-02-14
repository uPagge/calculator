package ru.tinkoff.fintech.calc.core.service.operation;

import ru.tinkoff.fintech.calc.core.service.Operation;

public class Sum implements Operation {

    @Override
    public Integer chooseOperation(Integer oper1, Integer oper2) {
        return oper1+oper2;
    }
}
