package ru.tinkoff.fintech.calc.core;

public class Regular {

    public static String divAndMul() {
        return "(^-\\d+|\\d+)[*|/](-\\d+|\\d+)";
    }

    public static String sumAndSub() {
        return "(^-\\d+|\\d+)[-|+](-\\d+|\\d+)";
    }

    public static String chooseOperation() {
        return "[-*/+]";
    }

    public static String validSymbols() {
        return "[-0-9+/*)(]+";
    }

    public static String operationsParentheses() {
        return "\\([\\d-+/*.,]+\\)";
    }

    public static String firstOperand() {
        return "(^-\\d+|\\d+)";
    }

    public static String negationFirstOperand() {
        return "^-\\d+([-*/+]|[-*/+][-*/+])\\d+";
    }

    public static String negationSecondOperand() {
        return "(^-\\d+|\\d+)[-*/+][-*/+]\\d+";
    }

}
