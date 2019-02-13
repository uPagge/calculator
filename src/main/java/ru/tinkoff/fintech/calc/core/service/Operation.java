package ru.tinkoff.fintech.calc.core.service;

import ru.tinkoff.fintech.calc.core.parse.Regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {

    public static String calculationExample(String exam) {
        exam = exam.replace(")", "").replace("(", "");
        String result = findTwoOperandAndProcessing(exam, Pattern.compile(Regular.divAndMul));
        result = findTwoOperandAndProcessing(result, Pattern.compile(Regular.sumAndSub));
        return result;
    }

    private static String findTwoOperandAndProcessing(String exam, Pattern pattern) {
        StringBuffer result = new StringBuffer();
        Matcher m = pattern.matcher(exam);
        while (m.find()) {
            m.appendReplacement(result, processingTwoOperands(m.group(0)));
        }
        m.appendTail(result);
        m = pattern.matcher(result.toString());
        if (m.find()) {
            return findTwoOperandAndProcessing(result.toString(), pattern);
        }
        return result.toString();
    }

    private static String processingTwoOperands(String tempExam) {
        Integer operand1 = null;
        Integer operand2 = null;
        for (String s : tempExam.split(Regular.chooseOperation)) {
            if (operand1 == null && !s.equals("")) {
                operand1 = Integer.valueOf(s);
            } else if (operand2 == null && !s.equals("")) {
                operand2 = Integer.valueOf(s);
            }
        }
        if (tempExam.matches(Regular.negationFirstOperand)) {
            operand1 *= (-1);
        }
        if (tempExam.matches(Regular.negationSecondOperand)) {
            operand2 *= (-1);
        }
        tempExam = tempExam.replaceFirst(Regular.firstOperand, "");
        return chooseOperation(operand1, operand2, tempExam.charAt(0));
    }

    private static String chooseOperation(Integer operand1, Integer operand2, char operation) {
        String result = "";
        switch (operation) {
            case '+':
                result = sum(operand1, operand2);
                break;
            case '-':
                result = sub(operand1, operand2);
                break;
            case '*':
                result = mul(operand1, operand2);
                break;
            case '/':
                result = div(operand1, operand2);
                break;
        }
        return result;
    }

    private static String sum(Integer addend1, Integer addend2) {
        return String.valueOf(addend1 + addend2);
    }

    private static String sub(Integer minuend, Integer subtrahend) {
        return String.valueOf(minuend - subtrahend);
    }

    private static String div(Integer dividend, Integer divider) {
        return String.valueOf(dividend / divider);
    }

    private static String mul(Integer multiplicand, Integer multiplier) {
        return String.valueOf(multiplicand * multiplier);
    }

}
