package ru.tinkoff.fintech.calc.core.parse;

import ru.tinkoff.fintech.calc.core.exce.NoValidExample;
import ru.tinkoff.fintech.calc.core.operations.Operation;
import ru.tinkoff.fintech.calc.core.operations.impl.Div;
import ru.tinkoff.fintech.calc.core.operations.impl.Mul;
import ru.tinkoff.fintech.calc.core.operations.impl.Power;
import ru.tinkoff.fintech.calc.core.operations.impl.Sum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static String parseInPrackets(String example) {
        Pattern pattern = Pattern.compile(Regular.operationsParentheses);
        Matcher matcher = pattern.matcher(example);
        return (matcher.find()) ? matcher.group() : null;
    }

    public static Integer parseOperand(String exampleTwoOperand, String regExp) {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(exampleTwoOperand);
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
        Pattern pattern = Pattern.compile(Regular.operation);
        Matcher matcher = pattern.matcher(exampleTwoOperand);
        if (matcher.find()) {
            pattern = Pattern.compile(Regular.chooseOperation);
            Matcher matcher2 = pattern.matcher(matcher.group());
            if (matcher2.find()) {
                switch (matcher2.group()) {
                    case "+":
                        return new Sum();
                    case "-":
                        return new Sum();
                    case "/":
                        return new Div();
                    case "*":
                        return new Mul();
                    case  "^":
                        return new Power();
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

    public static String findTwoOperand(String example, String regular) {
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(example);
        return (matcher.find()) ? matcher.group() : null;
    }

}
