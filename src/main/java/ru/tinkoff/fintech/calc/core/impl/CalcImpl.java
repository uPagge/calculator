package ru.tinkoff.fintech.calc.core.impl;

import ru.tinkoff.fintech.calc.core.Calc;
import ru.tinkoff.fintech.calc.core.Operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcImpl implements Calc {

    private StringBuffer tempExam;
    private String result;

    private Operation operation = new OperationImpl();

    public CalcImpl() {

    }

    @Override
    public void calculate(String exam) {
        exam = exam.replace(" ", "");
        Pattern pattern = Pattern.compile("\\([\\d-+/*.,]+\\)");
        Matcher m = pattern.matcher(exam);
        tempExam = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(tempExam, operation.calculationExample(m.group(0)));
        }
        m.appendTail(tempExam);
        m = pattern.matcher(tempExam.toString());
        if (m.find()) {
            calculate(tempExam.toString());
        }
        result = operation.calculationExample(tempExam.toString());
    }

    public String getResult() {
        return result;
    }

}

