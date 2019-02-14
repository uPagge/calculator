package ru.tinkoff.fintech.calc.core.service;

import ru.tinkoff.fintech.calc.core.exce.NoValidExample;
import ru.tinkoff.fintech.calc.core.parse.Parser;
import ru.tinkoff.fintech.calc.core.parse.Regular;

import java.util.regex.Pattern;

public class Calculator {

    public static String calculationExample(String exam) throws NoValidExample {
        exam = Parser.preprocessing(exam);
        while (Parser.parseInPrackets(exam) != null) {
            exam = Parser.preprocessing(exam);
            String tempSave = Parser.parseInPrackets(exam);
            String temp = tempSave.replace(")", "").replace("(", "");
            temp = test(temp, Pattern.compile(Regular.divAndMul));
            temp = test(temp, Pattern.compile(Regular.sumAndSub));
            exam = exam.replace(tempSave, temp);
        }
        String temp;
        temp = test(exam, Pattern.compile(Regular.divAndMul));
        temp = test(temp, Pattern.compile(Regular.sumAndSub));
        return temp;
    }

    private static String test(String temp, Pattern pattern) {
        String twoOperandAndOperation = Parser.findTwoOperand(temp, pattern);
        while (twoOperandAndOperation != null) {
            Integer resultOperation;
            Integer a = Parser.parseOperand(twoOperandAndOperation, Regular.firstOperand);
            Integer b = Parser.parseOperand(twoOperandAndOperation, Regular.seconOperand);
            OperationEnum operationEnum = Parser.parseOperation(twoOperandAndOperation);
            resultOperation = Operation.chooseOperation(a, b, operationEnum);
            if (resultOperation > 0) {
                temp = temp.replace(twoOperandAndOperation, "+" + String.valueOf(resultOperation));
            } else {
                temp = temp.replace(twoOperandAndOperation, String.valueOf(resultOperation));
            }
            twoOperandAndOperation = Parser.findTwoOperand(temp, pattern);
        }
        return temp;
    }

}

