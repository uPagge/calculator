package ru.tinkoff.fintech.calc.core;

import org.junit.Assert;
import org.junit.Test;
import ru.tinkoff.fintech.calc.core.exception.NoValidExample;

public class СalculatorTest {


    @Test
    public void multiplyPositiveByNegative() throws NoValidExample {
        Assert.assertEquals("-50", Calculator.calculationExample("5*-10"));
    }

    @Test
    public void multiplyNegativeByNegative() throws NoValidExample {
        Assert.assertEquals("+50", Calculator.calculationExample("-5*-10"));
    }

    @Test
    public void multiplyNegativeByPositive() throws NoValidExample {
        Assert.assertEquals("-50", Calculator.calculationExample("-5*10"));
    }

    @Test
    public void multiplyPositiveByPositive() throws NoValidExample {
        Assert.assertEquals("+50", Calculator.calculationExample("5*10"));
    }

    @Test
    public void divisionPositiveByPositive() throws NoValidExample {
        Assert.assertEquals("+2", Calculator.calculationExample("10/5"));
    }

    @Test
    public void divisionPositiveByNegative() throws NoValidExample {
        Assert.assertEquals("-2", Calculator.calculationExample("10/-5"));
    }

    @Test
    public void divisionNegativeByNegative() throws NoValidExample {
        Assert.assertEquals("+5", Calculator.calculationExample("-10/-2"));
    }

    @Test
    public void divisionNegativeByPositive() throws NoValidExample {
        Assert.assertEquals("-2", Calculator.calculationExample("-10/5"));
    }

    @Test
    public void summationNegativeByPositive() throws NoValidExample {
        Assert.assertEquals("-5", Calculator.calculationExample("-10+5"));
    }

    @Test
    public void summationNegativeByNegative() throws NoValidExample {
        Assert.assertEquals("-15", Calculator.calculationExample("-10+-5"));
    }

    @Test
    public void summationPositiveByPositive() throws NoValidExample {
        Assert.assertEquals("+15", Calculator.calculationExample("10+5"));
    }

    @Test
    public void summationPositiveByNegative() throws NoValidExample {
        Assert.assertEquals("+5", Calculator.calculationExample("10+-5"));
    }

    @Test
    public void subtractionPositiveByPositive() throws NoValidExample {
        Assert.assertEquals("+5", Calculator.calculationExample("10-5"));
    }

    @Test
    public void subtractionPositiveByNegativeNegative() throws NoValidExample {
        Assert.assertEquals("+15", Calculator.calculationExample("10--5"));
    }

    @Test
    public void subtractionNegativeByNegative() throws NoValidExample {
        Assert.assertEquals("-15", Calculator.calculationExample("-10-5"));
    }


    @Test
    public void calculateExampleNoParentheses() throws NoValidExample {
        Assert.assertEquals("+74", Calculator.calculationExample("2 + 8 * 9"));
    }

    @Test
    public void calculateExampleParenthesesOne() throws NoValidExample {
        Assert.assertEquals("+90", Calculator.calculationExample("(2 + 8) * 9"));
    }

    @Test
    public void calculateExampleParenthesesOneNestedOne() throws NoValidExample {
        Assert.assertEquals("+99", Calculator.calculationExample("(2 + (7+1+1)) * 9"));
        Assert.assertEquals("+108", Calculator.calculationExample("(2 + (8+4/2)) * 9"));
    }

    @Test
    public void calculateExampleParenthesesOneNestedTwo() throws NoValidExample {
        Assert.assertEquals("+9", Calculator.calculationExample("(2 + (8+4/2) - (12-12+22/2)) * 9"));
        Assert.assertEquals("-270", Calculator.calculationExample("(-2 + (-8-9) - (12-12+22/2)) * 9"));
    }

    @Test
    public void complexCalculations() throws NoValidExample {
        Assert.assertEquals("+169452", Calculator.calculationExample("(-2 + (-8-8/2+12*(12-5*(-345+1+2^5))) - (12-12+22/2+(55/5))) * 9"));
        Assert.assertEquals("+972", Calculator.calculationExample("(-2 + (-8-8/2+12^(4:2)) - (12-12+22/2+(55/5))) * 9"));

    }

    @Test(expected = NoValidExample.class)
    public void complexCalculationsFailed() throws NoValidExample {
        Calculator.calculationExample("(-2 + (-8-8/2+12*(12-5*(error))) - (12-12+22/2+(55/5))) * 9");
    }

    @Test
    public void power() throws NoValidExample {
        Assert.assertEquals("+8", Calculator.calculationExample("2^3"));
    }

    @Test
    public void power2() throws NoValidExample {
        Assert.assertEquals("+1", Calculator.calculationExample("1^-3"));
    }

    @Test
    public void power3() throws NoValidExample {
        Assert.assertEquals("-8", Calculator.calculationExample("-2^3"));
    }

    @Test
    public void power4() throws NoValidExample {
        Assert.assertEquals("-1", Calculator.calculationExample("-1^-3"));
    }

}