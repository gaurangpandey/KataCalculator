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
    
    @Test
    public void sumSingleNumberToself() {
    	assertThat(StringCalculator.add("5"), is(5));
    }
    @Test
    public void sumTwoNumberComma() {
    	assertThat(StringCalculator.add("2,2"), is(4));
    }
    @Test
    public void sumNumberNewline() {
    	assertThat(StringCalculator.add("1\n2,3"),is(6));
    }
    @Test
    public void sumNumberDelimiter() {
    	assertThat(StringCalculator.add("//;\n1;2"), is(3));
    }
    @Test(expected = IllegalArgumentException.class)
    public void OnNegativeNumber() {
    	StringCalculator.add("-3");
    }
    
    
}
