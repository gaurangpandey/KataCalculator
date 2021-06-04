package com.gaurang.KataCalculator;


public class StringCalculator 
{
    public static int add(String input) {
    	if(input.isEmpty())
    		return 0;
    	else
    		return Integer.parseInt(input);
    	
    }
}
