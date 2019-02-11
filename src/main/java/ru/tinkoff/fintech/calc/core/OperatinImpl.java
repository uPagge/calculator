package ru.tinkoff.fintech.calc.core;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperatinImpl implements Operation {

    private StringBuffer result;

    @Override
    public String oper(Integer a, Integer b, char oper) {
        String result = "";
        if (oper == '+') {
            result = String.valueOf(a + b);
        }
        if (oper == '-') {
            result = String.valueOf(a - b);
        }
        if (oper == '*') {
            result = String.valueOf(a * b);
        }
        if (oper == '/') {
            result = String.valueOf(a / b);
        }
        return result;
    }

    private String govnocod(String exam, Pattern pattern) {
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
            m.appendReplacement(result, oper(a, b, tempExam.charAt(0)));
        }
        m.appendTail(result);
        m = pattern.matcher(result.toString());
        if (m.find()) {
            govnocod(result.toString(), pattern);
        }
        return result.toString();
    }


    @Override
    public String parse(String exam) {
        exam = exam.replace(")", "").replace("(", "");
        String result = govnocod(exam, Pattern.compile("(^-\\d+|\\d+)[*|/](-\\d+|\\d+)"));
        result = govnocod(result, Pattern.compile("(^-\\d+|\\d+)[+|-](-\\d+|\\d+)"));
        return result;
    }

}
