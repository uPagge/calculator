package ru.tinkoff.fintech.calc.core;

import org.junit.Assert;
import org.junit.Test;
import ru.tinkoff.fintech.calc.core.impl.Сalculator;

public class СalculatorTest {


    @Test
    public void mul() {
        Assert.assertEquals("-50", Сalculator.calculate("5*-10"));
    }

    @Test
    public void mul1() {
        Assert.assertEquals("50", Сalculator.calculate("-5*-10"));
    }

    @Test
    public void mul2() {
        Assert.assertEquals("-50", Сalculator.calculate("-5*10"));
    }

    @Test
    public void mul3() {
        Assert.assertEquals("50", Сalculator.calculate("5*10"));
    }

    @Test
    public void div() {
        Assert.assertEquals("2", Сalculator.calculate("10/5"));
    }

    @Test
    public void div1() {
        Assert.assertEquals("-2", Сalculator.calculate("10/-5"));
    }

    @Test
    public void div2() {
        Assert.assertEquals("5", Сalculator.calculate("-10/-2"));
    }

    @Test
    public void div3() {
        Assert.assertEquals("-2", Сalculator.calculate("-10/5"));
    }

    @Test
    public void sum() {
        Assert.assertEquals("-5",  Сalculator.calculate("-10+5"));
    }

    @Test
    public void sum1() {
        Assert.assertEquals("-15", Сalculator.calculate("-10+-5"));
    }

    @Test
    public void sum2() {
        Assert.assertEquals("15", Сalculator.calculate("10+5"));
    }

    @Test
    public void sum3() {
        Assert.assertEquals("5", Сalculator.calculate("10+-5"));
    }

    @Test
    public void sub() {
        Assert.assertEquals("5", Сalculator.calculate("10-5"));
    }

    @Test
    public void sub1() {
        Assert.assertEquals("15", Сalculator.calculate("10--5"));
    }

    @Test
    public void sub2() {
        Assert.assertEquals("-15", Сalculator.calculate("-10-5"));
    }


    @Test
    public void calculate() {
        Assert.assertEquals("74", Сalculator.calculate("2 + 8 * 9"));
    }

    @Test
    public void calculate2() {
        Assert.assertEquals("90", Сalculator.calculate("(2 + 8) * 9"));
    }

    @Test
    public void calculate3() {
        Assert.assertEquals("99", Сalculator.calculate("(2 + (7+1+1)) * 9"));
    }

    @Test
    public void calculate4() {
        Assert.assertEquals("108", Сalculator.calculate("(2 + (8+4/2)) * 9"));
    }

    @Test
    public void calculate5() {
        Assert.assertEquals("9", Сalculator.calculate("(2 + (8+4/2) - (12-12+22/2)) * 9"));
    }

    @Test
    public void calculate6() {
        Assert.assertEquals("-270", Сalculator.calculate("(-2 + (-8-9) - (12-12+22/2)) * 9"));
    }

    @Test
    public void generalTest() {
        Assert.assertEquals("186732", Сalculator.calculate("(-2 + (-8-8/2+12*(12-5*(-345+1))) - (12-12+22/2+(55/5))) * 9"));
    }

    @Test
    public void generalTestNoValid() {
        Assert.assertEquals("Error", Сalculator.calculate("(-2 + (-8-8/2+12*(12-5*(error))) - (12-12+22/2+(55/5))) * 9"));
    }

    @Test
    public void generalTestNoValid2() {
        Assert.assertEquals("Error", Сalculator.calculate("(-2 + (-8-8/2+12*(12-5*(4:2))) - (12-12+22/2+(55/5))) * 9"));
    }
}