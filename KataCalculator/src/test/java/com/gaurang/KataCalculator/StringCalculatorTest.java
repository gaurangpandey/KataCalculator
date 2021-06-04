package com.gaurang.KataCalculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringCalculatorTest 
{
    @Test
    public void sumEmptyStringTo0() {
        assertThat(StringCalculator.add(""), is(0));
    }
}
