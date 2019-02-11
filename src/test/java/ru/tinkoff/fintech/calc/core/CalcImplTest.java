package ru.tinkoff.fintech.calc.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.tinkoff.fintech.calc.core.impl.CalcImpl;

public class CalcImplTest {

    private Calc calc;

    @Before
    public void setUp() throws Exception {
        calc = new CalcImpl();
    }


    @Test
    public void mul() {
        calc.calculate("5*-10");
        Assert.assertEquals("-50", calc.getResult());
    }

    @Test
    public void mul1() {
        calc.calculate("-5*-10");
        Assert.assertEquals("50", calc.getResult());
    }

    @Test
    public void mul2() {
        calc.calculate("-5*10");
        Assert.assertEquals("-50", calc.getResult());
    }

    @Test
    public void mul3() {
        calc.calculate("5*10");
        Assert.assertEquals("50", calc.getResult());
    }

    @Test
    public void div() {
        calc.calculate("10/5");
        Assert.assertEquals("2", calc.getResult());
    }

    @Test
    public void div1() {
        calc.calculate("10/-5");
        Assert.assertEquals("-2", calc.getResult());
    }

    @Test
    public void div2() {
        calc.calculate("-10/-2");
        Assert.assertEquals("5", calc.getResult());
    }

    @Test
    public void div3() {
        calc.calculate("-10/5");
        Assert.assertEquals("-2", calc.getResult());
    }

    @Test
    public void sum() {
        calc.calculate("-10+5");
        Assert.assertEquals("-5", calc.getResult());
    }

    @Test
    public void sum1() {
        calc.calculate("-10+-5");
        Assert.assertEquals("-15", calc.getResult());
    }

    @Test
    public void sum2() {
        calc.calculate("10+5");
        Assert.assertEquals("15", calc.getResult());
    }

    @Test
    public void sum3() {
        calc.calculate("10+-5");
        Assert.assertEquals("5", calc.getResult());
    }

    @Test
    public void sub() {
        calc.calculate("10-5");
        Assert.assertEquals("5", calc.getResult());
    }

    @Test
    public void sub1() {
        calc.calculate("10--5");
        Assert.assertEquals("15", calc.getResult());
    }

    @Test
    public void sub2() {
        calc.calculate("-10-5");
        Assert.assertEquals("-15", calc.getResult());
    }


    @Test
    public void calculate() {
        calc.calculate("2 + 8 * 9");
        Assert.assertEquals("74", calc.getResult());
    }

    @Test
    public void calculate2() {
        calc.calculate("(2 + 8) * 9");
        Assert.assertEquals("90", calc.getResult());
    }

    @Test
    public void calculate3() {
        calc.calculate("(2 + (7+1+1)) * 9");
        Assert.assertEquals("99", calc.getResult());
    }

    @Test
    public void calculate4() {
        calc.calculate("(2 + (8+4/2)) * 9");
        Assert.assertEquals("108", calc.getResult());
    }

    @Test
    public void calculate5() {
        calc.calculate("(2 + (8+4/2) - (12-12+22/2)) * 9");
        Assert.assertEquals("9", calc.getResult());
    }

    @Test
    public void calculate6() {
        calc.calculate("(-2 + (-8-9) - (12-12+22/2)) * 9");
        Assert.assertEquals("-270", calc.getResult());
    }

    @Test
    public void generalTest() {
        calc.calculate("(-2 + (-8-8/2+12*(12-5*(-345+1))) - (12-12+22/2+(55/5))) * 9");
        Assert.assertEquals("186732", calc.getResult());
    }
}