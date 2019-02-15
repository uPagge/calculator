package ru.tinkoff.fintech.calc.core;

import ru.tinkoff.fintech.calc.core.exception.NoValidExample;
import ru.tinkoff.fintech.calc.core.exception.WrongNumberOfParameters;
import ru.tinkoff.fintech.calc.core.operations.Operation;
import ru.tinkoff.fintech.calc.core.parse.Parser;
import ru.tinkoff.fintech.calc.core.parse.Regular;

public class Calculator {

    public static String calculationExample(String example) throws NoValidExample, WrongNumberOfParameters {
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
        example = calculateOneOperands(example, Regular.factorial);
        example = calculateTwoOperands(example, Regular.power);
        example = calculateTwoOperands(example, Regular.divAndMul);
        return calculateTwoOperands(example, Regular.sumAndSub);
    }

    private static String calculateTwoOperands(String example, String regularTwoOperands) {
        String twoOperandAndOperation = Parser.findOperand(example, regularTwoOperands);
        while (twoOperandAndOperation != null) {
            Operation operation = Parser.parseOperation(twoOperandAndOperation);
            Integer operand1 = Parser.parseOperand(twoOperandAndOperation, Regular.firstOperand);
            Integer operand2 = Parser.parseOperand(twoOperandAndOperation, Regular.seconOperand);
            Integer resultOperation = operation.performingOperation(operand1, operand2);
            example = example.replace(twoOperandAndOperation, resultFormatting(resultOperation));
            twoOperandAndOperation = Parser.findOperand(example, regularTwoOperands);
        }
        return example;
    }

    private static String calculateOneOperands(String example, String regularOneOperand) {
        String oneOperandAndOperation = Parser.findOperand(example, regularOneOperand);
        while (oneOperandAndOperation != null) {
            Operation operation = Parser.parseOperation(oneOperandAndOperation);
            Integer operand = Parser.parseOperand(oneOperandAndOperation, Regular.firstOperand);
            Integer resultOperation = operation.performingOperation(operand);
            example = example.replace(oneOperandAndOperation, resultFormatting(resultOperation));
            oneOperandAndOperation = Parser.findOperand(example, regularOneOperand);
        }
        return example;
    }

    private static String resultFormatting(Integer result) {
        return (result > 0) ? String.valueOf("+" + result) : String.valueOf(result);
    }

}

