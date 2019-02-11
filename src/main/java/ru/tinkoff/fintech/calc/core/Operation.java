package ru.tinkoff.fintech.calc.core;

public interface Operation {

    String oper(Integer a, Integer b, char oper);
    String parse(String exam);

}
