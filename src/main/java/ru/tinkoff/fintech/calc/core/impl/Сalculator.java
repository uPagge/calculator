package ru.tinkoff.fintech.calc.core.impl;

import ru.tinkoff.fintech.calc.core.Regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Сalculator {

    public static String calculate(String example) {
        example = example.replace(" ", "");
        if (valid(example)) {
            Pattern pattern = Pattern.compile(Regular.operationsParentheses());
            Matcher matcher = pattern.matcher(example);
            StringBuffer tempExam = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(tempExam, Operation.calculationExample(matcher.group(0)));
            }
            matcher.appendTail(tempExam);
            matcher = pattern.matcher(tempExam.toString());
            if (matcher.find()) {
                return calculate(tempExam.toString());
            }
            return Operation.calculationExample(tempExam.toString());
        } else {
            return "Error";
        }
    }

    private static Boolean valid(String exam) {
        Pattern pattern = Pattern.compile(Regular.validSymbols());
        Matcher m = pattern.matcher(exam);
        return m.matches();
    }

}

