package ru.tinkoff.fintech.calc.core.parse;

import ru.tinkoff.fintech.calc.core.exception.NoValidExample;
import ru.tinkoff.fintech.calc.core.operations.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private Parser() {
        throw new IllegalStateException();
    }

    public static String parseInPrackets(String example) {
        Matcher matcher = createMatcher(example, Regular.OPERATIONS_PARENTHESES);
        return (matcher.find()) ? matcher.group() : null;
    }

    private static Matcher createMatcher(String text, String regExp) {
        return Pattern.compile(regExp).matcher(text);
    }

    public static Integer parseOperand(String exampleTwoOperand, String regExp) {
        Matcher matcher = createMatcher(exampleTwoOperand, regExp);
        if (matcher.find()) {
            String save = matcher.group();
            Integer operand = Integer.valueOf(save.replaceAll(Regular.CHOOSE_OPERATION, ""));
            if (save.matches(Regular.NEGATION_OPERAND)) {
                operand *= (-1);
            }
            return operand;
        }
        return null;
    }

    public static Operation parseOperation(String exampleTwoOperand) {
        Matcher matcher = createMatcher(exampleTwoOperand, Regular.OPERATION);
        if (matcher.find()) {
            Matcher matcher2 = createMatcher(matcher.group(), Regular.CHOOSE_OPERATION);
            if (matcher2.find()) {
                switch (matcher2.group()) {
                    case "+":
                        return new Sum();
                    case "-":
                        return new Subtraction();
                    case "/":
                        return new Division();
                    case "*":
                        return new Multiplication();
                    case "^":
                        return new Exponentiation();
                    case "!":
                        return new Factorial();
                    default:
                        return null;
                }
            }
        }
        return null;
    }

    public static String preProcessing(String example) {
        return example.replace(" ", "")
                .replace("--", "+")
                .replace("++", "+")
                .replace("-+", "-")
                .replace("+-", "-")
                .replace(":", "/");
    }

    public static void valid(String exam) {
        Matcher matcher = createMatcher(exam, Regular.VALID_SYMBOLS);
        if (!matcher.matches()) {
            throw new NoValidExample("Wrong example" + exam);
        }
    }

    public static String findOperand(String example, String regular) {
        Matcher matcher = createMatcher(example, regular);
        return (matcher.find()) ? matcher.group() : null;
    }

}
