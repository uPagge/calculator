package ru.tinkoff.fintech.calc.core;

import ru.tinkoff.fintech.calc.core.exce.NoValidExample;
import ru.tinkoff.fintech.calc.core.parse.Parser;
import ru.tinkoff.fintech.calc.core.parse.Regular;
import ru.tinkoff.fintech.calc.core.service.Operation;
import ru.tinkoff.fintech.calc.core.service.OperationEnum;

import java.util.regex.Pattern;

public class Calculator {

    public static String calculationExample(String exam) throws NoValidExample {
        exam = Parser.preProcessing(exam);
        Parser.valid(exam);
        while (Parser.parseInPrackets(exam) != null) {
            exam = Parser.preProcessing(exam);
            String tempSave = Parser.parseInPrackets(exam);
            String temp = tempSave.replace(")", "").replace("(", "");
            temp = calculateTwoOperands(temp, Regular.divAndMul);
            temp = calculateTwoOperands(temp, Regular.sumAndSub);
            exam = exam.replace(tempSave, temp);
        }
        String temp;
        temp = calculateTwoOperands(exam, Regular.divAndMul);
        temp = calculateTwoOperands(temp, Regular.sumAndSub);
        return temp;
    }

    private static String calculateTwoOperands(String example, String regularTwoOperands) throws NoValidExample {
        String twoOperandAndOperation = Parser.findTwoOperand(example, regularTwoOperands);
        while (twoOperandAndOperation != null) {
            Integer a = Parser.parseOperand(twoOperandAndOperation, Regular.firstOperand);
            Integer b = Parser.parseOperand(twoOperandAndOperation, Regular.seconOperand);
            OperationEnum operationEnum = Parser.parseOperation(twoOperandAndOperation);
            Integer resultOperation = Operation.chooseOperation(a, b, operationEnum);
            if (resultOperation > 0) {
                example = example.replace(twoOperandAndOperation, "+" + String.valueOf(resultOperation));
            } else {
                example = example.replace(twoOperandAndOperation, String.valueOf(resultOperation));
            }
            twoOperandAndOperation = Parser.findTwoOperand(example, regularTwoOperands);
        }
        return example;
    }

}

