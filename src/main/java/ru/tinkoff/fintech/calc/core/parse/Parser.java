package ru.tinkoff.fintech.calc.core.parse;

import ru.tinkoff.fintech.calc.core.exception.NoValidExample;
import ru.tinkoff.fintech.calc.core.operations.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static String parseInPrackets(String example) {
        Matcher matcher = createMatcher(example, Regular.operationsParentheses);
        return (matcher.find()) ? matcher.group() : null;
    }

    private static Matcher createMatcher(String text, String regExp) {
        return Pattern.compile(regExp).matcher(text);
    }

    public static Integer parseOperand(String exampleTwoOperand, String regExp) {
        Matcher matcher = createMatcher(exampleTwoOperand, regExp);
        if (matcher.find()) {
            String save = matcher.group();
            Integer operand = Integer.valueOf(save.replaceAll(Regular.chooseOperation, ""));
            if (save.matches(Regular.negationOperand)) {
                operand *= (-1);
            }
            return operand;
        }
        return null;
    }

    public static Operation parseOperation(String exampleTwoOperand) {
        Matcher matcher = createMatcher(exampleTwoOperand, Regular.operation);
        if (matcher.find()) {
            Matcher matcher2 = createMatcher(matcher.group(), Regular.chooseOperation);
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
                    case  "^":
                        return new Exponentiation();
                    case  "!":
                        return new Factorial();
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

    public static void valid(String exam) throws NoValidExample {
        Pattern pattern = Pattern.compile(Regular.validSymbols);
        Matcher m = pattern.matcher(exam);
        if (!m.matches()) {
            throw new NoValidExample("Wrong example" + exam);
        }
    }

    public static String findOperand(String example, String regular) {
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(example);
        return (matcher.find()) ? matcher.group() : null;
    }

}
