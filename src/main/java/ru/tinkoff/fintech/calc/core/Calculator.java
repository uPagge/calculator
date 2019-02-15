package ru.tinkoff.fintech.calc.core;

import ru.tinkoff.fintech.calc.core.exception.NoValidExample;
import ru.tinkoff.fintech.calc.core.operations.Operation;
import ru.tinkoff.fintech.calc.core.operations.Subtraction;
import ru.tinkoff.fintech.calc.core.parse.Parser;
import ru.tinkoff.fintech.calc.core.parse.Regular;

public class Calculator {

    public static String calculationExample(String example) throws NoValidExample {
        example = Parser.preProcessing(example);
        Parser.valid(example);
        while (Parser.parseInPrackets(example) != null) {
            example = Parser.preProcessing(example);
            String tempSave = Parser.parseInPrackets(example);
            String resultInPrackets = calculationPriority(tempSave.replace(")", "").replace("(", ""));
            example = example.replace(tempSave, resultInPrackets);
        }
        return calculationPriority(example);
    }

    private static String calculationPriority(String example) {
        example = calculateTwoOperands(example, Regular.power);
        example = calculateTwoOperands(example, Regular.divAndMul);
        return calculateTwoOperands(example, Regular.sumAndSub);
    }

    private static String calculateTwoOperands(String example, String regularTwoOperands) {
        String twoOperandAndOperation = Parser.findTwoOperand(example, regularTwoOperands);
        while (twoOperandAndOperation != null) {
            Operation operation = Parser.parseOperation(twoOperandAndOperation);
            Integer a = Parser.parseOperand(twoOperandAndOperation, Regular.firstOperand);
            Integer b = Parser.parseOperand(twoOperandAndOperation, Regular.seconOperand);
            if (operation instanceof Subtraction) {
                b *= (-1);
            }
            Integer resultOperation = operation.performingOperation(a,b);
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

