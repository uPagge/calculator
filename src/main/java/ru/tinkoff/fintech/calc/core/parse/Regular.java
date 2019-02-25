package ru.tinkoff.fintech.calc.core.parse;

public class Regular {

    private Regular() {
        throw new IllegalStateException();
    }

    public static final String FACTORIAL = "(-\\d+|[+]\\d+|\\d+)!";

    public static final String POWER = "(-\\d+|[+]\\d+|\\d+)[\\^](-\\d+|[+]\\d+|\\d+)";

    public static final String DIV_AND_MUL = "(-\\d+|[+]\\d+|\\d+)[*|/](-\\d+|[+]\\d+|\\d+)";

    public static final String SUM_AND_SUB = "(-\\d+|[+]\\d+|\\d+)[+|-](-\\d+|[+]\\d+|\\d+)";

    public static final String CHOOSE_OPERATION = "[-*/+\\^!]";

    public static final String VALID_SYMBOLS = "[-0-9+/*\\^)(!]+";

    public static final String OPERATIONS_PARENTHESES = "\\([\\d-+/*.,\\^!]+\\)";

    public static final String FIRST_OPERAND = "(^-\\d+|^\\d+|^[+]\\d+)";

    public static final String SECON_OPERAND = "[-+*/\\^](\\d+)$";

    public static final String NEGATION_OPERAND = "^-\\d+";

    public static final String OPERATION = "\\d+[-*/+\\^!]";

}
