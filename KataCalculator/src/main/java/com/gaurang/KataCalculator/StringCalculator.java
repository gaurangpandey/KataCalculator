package com.gaurang.KataCalculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
	
	private String delimiter , sum;
	
	private StringCalculator(String delimiter, String sum) {
		this.delimiter=delimiter;
		this.sum=sum;	
	}
	
	
    public static int add(String input) {
    	if(input.isEmpty())
    		return 0;
    	
    	StringCalculator calculator;
    	if(input.startsWith("//")) {
    		String[] part=input.split("\n", 2);
    		calculator = new StringCalculator(part[0].substring(2),part[1]);
    	}
    	else
    		calculator =new StringCalculator(",|\n",input);
    	
    	return calculator.number();
    	}


	private int number() {
		return Arrays.stream(sum.split(delimiter)).mapToInt(Integer::parseInt).sum();
	}
    	
}

