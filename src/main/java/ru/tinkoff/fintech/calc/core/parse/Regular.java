package ru.tinkoff.fintech.calc.core.parse;

public class Regular {

    public static String factorial = "(-\\d+|[+]\\d+|\\d+)!";

    public static String power = "(-\\d+|[+]\\d+|\\d+)[\\^](-\\d+|[+]\\d+|\\d+)";

    public static String divAndMul = "(-\\d+|[+]\\d+|\\d+)[*|/](-\\d+|[+]\\d+|\\d+)";

    public static String sumAndSub = "(-\\d+|[+]\\d+|\\d+)[+|-](-\\d+|[+]\\d+|\\d+)";

    public static String chooseOperation = "[-*/+\\^!]";

    public static String validSymbols = "[-0-9+/*\\^)(!]+";

    public static String operationsParentheses = "\\([\\d-+/*.,\\^!]+\\)";

    public static String firstOperand = "(^-\\d+|^\\d+|^[+]\\d+)";

    public static String seconOperand = "[-+*/\\^](\\d+)$";

    public static String negationOperand = "^-\\d+";

    public static String operation = "\\d+[-*/+\\^!]";

}
