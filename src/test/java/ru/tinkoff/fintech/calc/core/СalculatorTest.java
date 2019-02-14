package ru.tinkoff.fintech.calc.core;

import org.junit.Assert;
import org.junit.Test;
import ru.tinkoff.fintech.calc.core.exce.NoValidExample;

public class СalculatorTest {


    @Test
    public void mul() throws NoValidExample {
        Assert.assertEquals("-50", Calculator.calculationExample("5*-10"));
    }

    @Test
    public void mul1() throws NoValidExample {
        Assert.assertEquals("+50", Calculator.calculationExample("-5*-10"));
    }

    @Test
    public void mul2() throws NoValidExample {
        Assert.assertEquals("-50", Calculator.calculationExample("-5*10"));
    }

    @Test
    public void mul3() throws NoValidExample {
        Assert.assertEquals("+50", Calculator.calculationExample("5*10"));
    }

    @Test
    public void div() throws NoValidExample {
        Assert.assertEquals("+2", Calculator.calculationExample("10/5"));
    }

    @Test
    public void div1() throws NoValidExample {
        Assert.assertEquals("-2", Calculator.calculationExample("10/-5"));
    }

    @Test
    public void div2() throws NoValidExample {
        Assert.assertEquals("+5", Calculator.calculationExample("-10/-2"));
    }

    @Test
    public void div3() throws NoValidExample {
        Assert.assertEquals("-2", Calculator.calculationExample("-10/5"));
    }

    @Test
    public void sum() throws NoValidExample {
        Assert.assertEquals("-5", Calculator.calculationExample("-10+5"));
    }

    @Test
    public void sum1() throws NoValidExample {
        Assert.assertEquals("-15", Calculator.calculationExample("-10+-5"));
    }

    @Test
    public void sum2() throws NoValidExample {
        Assert.assertEquals("+15", Calculator.calculationExample("10+5"));
    }

    @Test
    public void sum3() throws NoValidExample {
        Assert.assertEquals("+5", Calculator.calculationExample("10+-5"));
    }

    @Test
    public void sub() throws NoValidExample {
        Assert.assertEquals("+5", Calculator.calculationExample("10-5"));
    }

    @Test
    public void sub1() throws NoValidExample {
        Assert.assertEquals("+15", Calculator.calculationExample("10--5"));
    }

    @Test
    public void sub2() throws NoValidExample {
        Assert.assertEquals("-15", Calculator.calculationExample("-10-5"));
    }


    @Test
    public void calculate() throws NoValidExample {
        Assert.assertEquals("+74", Calculator.calculationExample("2 + 8 * 9"));
    }

    @Test
    public void calculate2() throws NoValidExample {
        Assert.assertEquals("+90", Calculator.calculationExample("(2 + 8) * 9"));
    }

    @Test
    public void calculate3() throws NoValidExample {
        Assert.assertEquals("+99", Calculator.calculationExample("(2 + (7+1+1)) * 9"));
    }

    @Test
    public void calculate4() throws NoValidExample {
        Assert.assertEquals("+108", Calculator.calculationExample("(2 + (8+4/2)) * 9"));
    }

    @Test
    public void calculate5() throws NoValidExample {
        Assert.assertEquals("+9", Calculator.calculationExample("(2 + (8+4/2) - (12-12+22/2)) * 9"));
    }

    @Test
    public void calculate6() throws NoValidExample {
        Assert.assertEquals("-270", Calculator.calculationExample("(-2 + (-8-9) - (12-12+22/2)) * 9"));
    }

    @Test
    public void generalTest() throws NoValidExample {
        Assert.assertEquals("+186732", Calculator.calculationExample("(-2 + (-8-8/2+12*(12-5*(-345+1))) - (12-12+22/2+(55/5))) * 9"));
    }

    @Test(expected = NoValidExample.class)
    public void generalTestNoValid() throws NoValidExample {
        Calculator.calculationExample("(-2 + (-8-8/2+12*(12-5*(error))) - (12-12+22/2+(55/5))) * 9");
    }

    @Test
    public void generalTestNoValidAndValid() throws NoValidExample {
         Assert.assertEquals("-108", Calculator.calculationExample("(-2 + (-8-8/2+12*(12-5*(4:2))) - (12-12+22/2+(55/5))) * 9"));
    }
}