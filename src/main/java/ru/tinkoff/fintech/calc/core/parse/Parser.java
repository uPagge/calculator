package ru.tinkoff.fintech.calc.core.parse;

import ru.tinkoff.fintech.calc.core.exce.NoValidExample;
import ru.tinkoff.fintech.calc.core.service.Operation;
import ru.tinkoff.fintech.calc.core.service.OperationEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static String parseInPrackets(String example) throws NoValidExample {
        if (valid(example)) {
            Pattern pattern = Pattern.compile(Regular.operationsParentheses);
            Matcher matcher = pattern.matcher(example);
            while (matcher.find()) {
                return matcher.group(0);
            }
        } else {
            throw new NoValidExample("Wrong example" + example);
        }
        return null;
    }

    public static Integer parseOperand(String exampleTwoOperand, String regExp) {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(exampleTwoOperand);
        if (matcher.find()) {
            String save = matcher.group();
            Integer operand = Integer.valueOf(save.replaceAll("[-+/*]", ""));
            if (save.matches(Regular.negationOperand)) {
                operand *= (-1);
            }
            return operand;
        }
        return null;
    }

    public static OperationEnum parseOperation(String exampleTwoOperand) {
        Pattern pattern = Pattern.compile("\\d+[-*/+]");
        Matcher matcher = pattern.matcher(exampleTwoOperand);
        if (matcher.find()) {
            String test = matcher.group();
            System.out.println(test);
            pattern = Pattern.compile(Regular.chooseOperation);
            Matcher matcher2 = pattern.matcher(test);
            if (matcher2.find()) {
                String test2 = matcher2.group();
                System.out.println(test2);
                switch (test2) {
                    case "+":
                        return OperationEnum.SUM;
                    case "-":
                        return OperationEnum.SUM;
                    case "/":
                        return OperationEnum.DIV;
                    case "*":
                        return OperationEnum.MUL;
                }
            }
        }
        return null;
    }

    public static String preprocessing(String example) {
        return example.replace(" ", "").replace("--", "+").replace("++", "+").replace("-+", "-");
    }

    private static Boolean valid(String exam) {
        Pattern pattern = Pattern.compile(Regular.validSymbols);
        Matcher m = pattern.matcher(exam);
        return m.matches();
    }

    public static String findTwoOperand(String exam, Pattern pattern) {
        Matcher m = pattern.matcher(exam);
        if (m.find()) {
            return m.group(0);
        } else {
            return null;
        }
    }


}
