package com.gaurang.KataCalculator;


public class StringCalculator 
{
    public static int add(String input) {
    	if(input.isEmpty())
    		return 0;
    	else if(input.contains(",")){
    		String[] sum=input.split(",");
    		return Integer.parseInt(sum[0]) + Integer.parseInt(sum[1]);
    	}
    	else
    		return Integer.parseInt(input);
    	
    }
}
