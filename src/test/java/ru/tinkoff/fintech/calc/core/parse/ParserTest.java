package ru.tinkoff.fintech.calc.core.parse;

import org.junit.Assert;
import org.junit.Test;
import ru.tinkoff.fintech.calc.core.exce.NoValidExample;
import ru.tinkoff.fintech.calc.core.operations.impl.Div;
import ru.tinkoff.fintech.calc.core.operations.impl.Mul;
import ru.tinkoff.fintech.calc.core.operations.impl.Sum;

public class ParserTest {

    @Test(expected = NoValidExample.class)
    public void validationFailed() throws NoValidExample {
        Parser.valid("1/er2/3");
    }

    @Test
    public void validationSuccess() throws NoValidExample {
        Parser.valid("1+(2*3)");
    }

    @Test
    public void preProcessingSuccess() {
        Assert.assertEquals("12-45", Parser.preProcessing("12+- 45"));
        Assert.assertEquals("12/45", Parser.preProcessing("12:45"));
        Assert.assertEquals("12+45", Parser.preProcessing("12--45"));
    }

    @Test
    public void getEnumOperation() {
        Assert.assertEquals(new Div(), Parser.parseOperation("12/12"));
        Assert.assertEquals(new Sum(), Parser.parseOperation("12-34"));
        Assert.assertEquals(new Mul(), Parser.parseOperation("12*34"));
        Assert.assertEquals(new Sum(), Parser.parseOperation("12+34"));
    }

    @Test
    public void getExampleInPrackets() {
        Assert.assertEquals("(12+3)", Parser.parseInPrackets("12+(3*(12+3))"));
    }

    @Test
    public void getTwoOperand() {
        Assert.assertEquals("+12*3", Parser.findTwoOperand("12+12*3", Regular.divAndMul));
        Assert.assertNull(Parser.findTwoOperand("12+12-3", Regular.divAndMul));
        Assert.assertEquals("12+12", Parser.findTwoOperand("12+12-3", Regular.sumAndSub));
        Assert.assertNull(Parser.findTwoOperand("12*12/3", Regular.sumAndSub));
    }
}