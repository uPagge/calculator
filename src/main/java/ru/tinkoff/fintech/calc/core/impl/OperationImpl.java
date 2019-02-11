package ru.tinkoff.fintech.calc.core.impl;

import ru.tinkoff.fintech.calc.core.Operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationImpl implements Operation {

    private StringBuffer result;

    @Override
    public String mathOperation(Integer a, Integer b, char oper) {
        String result = "";
        switch (oper) {
            case '+':
                result = String.valueOf(a + b);
                break;
            case '-':
                result = String.valueOf(a - b);
                break;
            case '*':
                result = String.valueOf(a*b);
                break;
            case '/':
                result = String.valueOf(a / b);
                break;
        }
        return result;
    }

    private String calculationOperands(String exam, Pattern pattern) {
        result = new StringBuffer();
        Matcher m = pattern.matcher(exam);
        while (m.find()) {
            Integer a = null;
            Integer b = null;
            String tempExam = m.group(0);
            for (String s : tempExam.split("[-*/+]")) {
                if (a == null && !s.equals("")) {
                    a = Integer.valueOf(s);
                } else if (b == null && !s.equals("")) {
                    b = Integer.valueOf(s);
                }
            }
            if (tempExam.matches("^-\\d+([-*/+]|[-*/+][-*/+])\\d+")) {
                a *= (-1);
            }
            if (tempExam.matches("(^-\\d+|\\d+)[-*/+][-*/+]\\d+")) {
                b *= (-1);
            }
            tempExam = tempExam.replaceFirst("(^-\\d+|\\d+)", "");
            m.appendReplacement(result, mathOperation(a, b, tempExam.charAt(0)));
        }
        m.appendTail(result);
        m = pattern.matcher(result.toString());
        if (m.find()) {
            calculationOperands(result.toString(), pattern);
        }
        return result.toString();
    }


    @Override
    public String calculationExample(String exam) {
        exam = exam.replace(")", "").replace("(", "");
        String result = calculationOperands(exam, Pattern.compile("(^-\\d+|\\d+)[*|/](-\\d+|\\d+)"));
        result = calculationOperands(result, Pattern.compile("(^-\\d+|\\d+)[-|+](-\\d+|\\d+)"));
        return result;
    }

}
