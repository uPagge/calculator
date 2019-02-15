package ru.tinkoff.fintech.calc.core.parse;

import org.junit.Assert;
import org.junit.Test;
import ru.tinkoff.fintech.calc.core.exception.NoValidExample;
import ru.tinkoff.fintech.calc.core.operations.Operation;
import ru.tinkoff.fintech.calc.core.operations.Division;
import ru.tinkoff.fintech.calc.core.operations.Multiplication;
import ru.tinkoff.fintech.calc.core.operations.Exponentiation;
import ru.tinkoff.fintech.calc.core.operations.Sum;

public class ParserTest {

    @Test(expected = NoValidExample.class)
    public void validationFailed() throws NoValidExample {
        Parser.valid("1/er2/3");
    }

    @Test
    public void validationSuccess() throws NoValidExample {
        Parser.valid("1+(2*3^2)");
    }

    @Test
    public void preProcessingSuccess() {
        Assert.assertEquals("12-45", Parser.preProcessing("12+- 45"));
        Assert.assertEquals("12/45", Parser.preProcessing("12:45"));
        Assert.assertEquals("12+45", Parser.preProcessing("12--45"));
    }

    @Test
    public void getEnumOperation() {
        Operation operation = Parser.parseOperation("12/15");
        Assert.assertTrue(operation instanceof Division);
        operation = Parser.parseOperation("12-34");
        Assert.assertTrue(operation instanceof Sum);
        operation = Parser.parseOperation("12*34");
        Assert.assertTrue(operation instanceof Multiplication);
        operation = Parser.parseOperation("12+34");
        Assert.assertTrue(operation instanceof Sum);
        operation = Parser.parseOperation("12^34");
        Assert.assertTrue(operation instanceof Exponentiation);
    }

    @Test
    public void getExampleInPrackets() {
        Assert.assertEquals("(12+3)", Parser.parseInPrackets("12+(3*(12+3))"));
    }

    @Test
    public void getTwoOperand() {
        Assert.assertEquals("+12*3", Parser.findOperand("12+12*3", Regular.divAndMul));
        Assert.assertNull(Parser.findOperand("12+12-3", Regular.divAndMul));
        Assert.assertEquals("12+12", Parser.findOperand("12+12-3", Regular.sumAndSub));
        Assert.assertNull(Parser.findOperand("12*12/3", Regular.sumAndSub));
        Assert.assertEquals("12^2", Parser.findOperand("2*12^2-3", Regular.power));
        Assert.assertNull(Parser.findOperand("12*12/3", Regular.power));
    }
}