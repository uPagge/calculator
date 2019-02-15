package ru.tinkoff.fintech.calc.core;

import org.junit.Assert;
import org.junit.Test;
import ru.tinkoff.fintech.calc.core.exception.NoValidExample;
import ru.tinkoff.fintech.calc.core.exception.WrongNumberOfParameters;

public class СalculatorTest {


    @Test
    public void multiplyPositiveByNegative() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-50", Calculator.calculationExample("5*-10"));
    }

    @Test
    public void multiplyNegativeByNegative() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+50", Calculator.calculationExample("-5*-10"));
    }

    @Test
    public void multiplyNegativeByPositive() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-50", Calculator.calculationExample("-5*10"));
    }

    @Test
    public void multiplyPositiveByPositive() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+50", Calculator.calculationExample("5*10"));
    }

    @Test
    public void divisionPositiveByPositive() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+2", Calculator.calculationExample("10/5"));
    }

    @Test
    public void divisionPositiveByNegative() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-2", Calculator.calculationExample("10/-5"));
    }

    @Test
    public void divisionNegativeByNegative() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+5", Calculator.calculationExample("-10/-2"));
    }

    @Test
    public void divisionNegativeByPositive() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-2", Calculator.calculationExample("-10/5"));
    }

    @Test
    public void summationNegativeByPositive() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-5", Calculator.calculationExample("-10+5"));
    }

    @Test
    public void summationNegativeByNegative() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-15", Calculator.calculationExample("-10+-5"));
    }

    @Test
    public void summationPositiveByPositive() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+15", Calculator.calculationExample("10+5"));
    }

    @Test
    public void summationPositiveByNegative() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+5", Calculator.calculationExample("10+-5"));
    }

    @Test
    public void subtractionPositiveByPositive() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+5", Calculator.calculationExample("10-5"));
    }

    @Test
    public void subtractionPositiveByNegativeNegative() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+15", Calculator.calculationExample("10--5"));
    }

    @Test
    public void subtractionNegativeByNegative() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-15", Calculator.calculationExample("-10-5"));
    }

    @Test
    public void subtractionNegativeByPositiveNegative() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-15", Calculator.calculationExample("-10+-5"));
    }


    @Test
    public void calculateExampleNoParentheses() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-1430", Calculator.calculationExample("2 + 8 - 6! * 2"));
    }

    @Test
    public void calculateExampleParenthesesOne() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+90", Calculator.calculationExample("(2 + 8) * 9"));
    }

    @Test
    public void calculateExampleParenthesesOneNestedOne() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+1098", Calculator.calculationExample("(2 + (3+1+1)!) * 9"));
        Assert.assertEquals("+108", Calculator.calculationExample("(2 + (8+4/2)) * 9"));
    }

    @Test
    public void calculateExampleParenthesesOneNestedTwo() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+9", Calculator.calculationExample("(2 + (8+4/2) - (12-12+22/2)) * 9"));
        Assert.assertEquals("-270", Calculator.calculationExample("(-2 + (-8-9) - (12-12+22/2)) * 9"));
    }

    @Test
    public void complexCalculations() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-4012308", Calculator.calculationExample("(-2 + (-8-8/2+12*(12-5*(-345+1+3!^5))) - (12-12+22/2+(55/5))) * 9"));
        Assert.assertEquals("+972", Calculator.calculationExample("(-2 + (-8-8/2+12^(4:2)) - (12-12+22/2+(55/5))) * 9"));

    }

    @Test(expected = NoValidExample.class)
    public void complexCalculationsFailed() throws NoValidExample, WrongNumberOfParameters {
        Calculator.calculationExample("(-2 + (-8-8/2+12*(12-5*(error))) - (12-12+22/2+(55/5))) * 9");
    }

    @Test
    public void power() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+8", Calculator.calculationExample("2^3"));
    }

    @Test
    public void power2() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+1", Calculator.calculationExample("1^-3"));
    }

    @Test
    public void power3() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-8", Calculator.calculationExample("-2^3"));
    }

    @Test
    public void power4() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-1", Calculator.calculationExample("-1^-3"));
    }

    @Test
    public void factorial() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+6", Calculator.calculationExample("3!"));
    }

    @Test
    public void factorial2() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-6", Calculator.calculationExample("-3!"));
    }

    @Test
    public void factorial3() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("+12", Calculator.calculationExample("2*3!"));
    }

    @Test
    public void factorial4() throws NoValidExample, WrongNumberOfParameters {
        Assert.assertEquals("-12", Calculator.calculationExample("2*-3!"));
    }

}