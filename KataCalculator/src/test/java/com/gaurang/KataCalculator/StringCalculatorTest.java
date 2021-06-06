package com.gaurang.KataCalculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
    
    @Rule 
    public ExpectedException expectedexception= ExpectedException.none();
    
    @Test
    public void onNegativeNumber() {
    	expectedexception.expect(IllegalArgumentException.class);
    	expectedexception.expectMessage("number is: -3");
    	StringCalculator.add("-3");
    }
    
    @Test
    public void onMultiNegativeNumberAllInMessage() {
    	expectedexception.expect(IllegalArgumentException.class);
    	expectedexception.expectMessage("number is: -3,-2,-1");
    	StringCalculator.add("-3,1,-2,-1");
    }
    
    @Test
    public void numberMoreThan1000Ignored() {
    	assertThat(StringCalculator.add("1010,5"), is(5));
    }
    
    
}
