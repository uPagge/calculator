package ru.tinkoff.fintech.calc.core;

import org.junit.Assert;
import org.junit.Test;
import ru.tinkoff.fintech.calc.core.exception.NoValidExample;

public class СalculatorTest {


    @Test
    public void multiplyPositiveByNegative() {
        Assert.assertEquals("-50", Calculator.calculationExample("5*-10"));
    }

    @Test
    public void multiplyNegativeByNegative() {
        Assert.assertEquals("+50", Calculator.calculationExample("-5*-10"));
    }

    @Test
    public void multiplyNegativeByPositive() {
        Assert.assertEquals("-50", Calculator.calculationExample("-5*10"));
    }

    @Test
    public void multiplyPositiveByPositive() {
        Assert.assertEquals("+50", Calculator.calculationExample("5*10"));
    }

    @Test
    public void divisionPositiveByPositive() {
        Assert.assertEquals("+2", Calculator.calculationExample("10/5"));
    }

    @Test
    public void divisionPositiveByNegative() {
        Assert.assertEquals("-2", Calculator.calculationExample("10/-5"));
    }

    @Test
    public void divisionNegativeByNegative() {
        Assert.assertEquals("+5", Calculator.calculationExample("-10/-2"));
    }

    @Test
    public void divisionNegativeByPositive() {
        Assert.assertEquals("-2", Calculator.calculationExample("-10/5"));
    }

    @Test
    public void summationNegativeByPositive() {
        Assert.assertEquals("-5", Calculator.calculationExample("-10+5"));
    }

    @Test
    public void summationNegativeByNegative() {
        Assert.assertEquals("-15", Calculator.calculationExample("-10+-5"));
    }

    @Test
    public void summationPositiveByPositive() {
        Assert.assertEquals("+15", Calculator.calculationExample("10+5"));
    }

    @Test
    public void summationPositiveByNegative() {
        Assert.assertEquals("+5", Calculator.calculationExample("10+-5"));
    }

    @Test
    public void subtractionPositiveByPositive() {
        Assert.assertEquals("+5", Calculator.calculationExample("10-5"));
    }

    @Test
    public void subtractionPositiveByNegativeNegative() {
        Assert.assertEquals("+15", Calculator.calculationExample("10--5"));
    }

    @Test
    public void subtractionNegativeByNegative() {
        Assert.assertEquals("-15", Calculator.calculationExample("-10-5"));
    }

    @Test
    public void subtractionNegativeByPositiveNegative() {
        Assert.assertEquals("-15", Calculator.calculationExample("-10+-5"));
    }


    @Test
    public void calculateExampleNoParentheses() {
        Assert.assertEquals("+1450", Calculator.calculationExample("2 + 8 - 6! * 2"));
    }

    @Test
    public void calculateExampleParenthesesOne() {
        Assert.assertEquals("+90", Calculator.calculationExample("(2 + 8) * 9"));
    }

    @Test
    public void calculateExampleParenthesesOneNestedOne() {
        Assert.assertEquals("+1098", Calculator.calculationExample("(2 + (3+1+1)!) * 9"));
        Assert.assertEquals("+108", Calculator.calculationExample("(2 + (8+4/2)) * 9"));
    }

    @Test
    public void calculateExampleParenthesesOneNestedTwo() {
        Assert.assertEquals("+9", Calculator.calculationExample("(2 + (8+4/2) - (12-12+22/2)) * 9"));
        Assert.assertEquals("-270", Calculator.calculationExample("(-2 + (-8-9) - (12-12+22/2)) * 9"));
    }

    @Test
    public void complexCalculations() {
        Assert.assertEquals("-4012308", Calculator.calculationExample("(-2 + (-8-8/2+12*(12-5*(-345+1+3!^5))) - (12-12+22/2+(55/5))) * 9"));
        Assert.assertEquals("+972", Calculator.calculationExample("(-2 + (-8-8/2+12^(4:2)) - (12-12+22/2+(55/5))) * 9"));

    }

    @Test(expected = NoValidExample.class)
    public void complexCalculationsFailed() {
        Calculator.calculationExample("(-2 + (-8-8/2+12*(12-5*(error))) - (12-12+22/2+(55/5))) * 9");
    }

    @Test
    public void power() {
        Assert.assertEquals("+8", Calculator.calculationExample("2^3"));
    }

    @Test
    public void power2() {
        Assert.assertEquals("+1", Calculator.calculationExample("1^-3"));
    }

    @Test
    public void power3() {
        Assert.assertEquals("-8", Calculator.calculationExample("-2^3"));
    }

    @Test
    public void power4() {
        Assert.assertEquals("-1", Calculator.calculationExample("-1^-3"));
    }

    @Test
    public void factorial() {
        Assert.assertEquals("+6", Calculator.calculationExample("3!"));
    }

    @Test
    public void factorial2() {
        Assert.assertEquals("+6", Calculator.calculationExample("-3!"));
    }

    @Test
    public void factorial3() {
        Assert.assertEquals("+12", Calculator.calculationExample("2*3!"));
    }

    @Test
    public void factorial4() {
        Assert.assertEquals("+12", Calculator.calculationExample("2*-3!"));
    }

}