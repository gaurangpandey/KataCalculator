package com.gaurang.KataCalculator;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
		exceptionNoNegative();
		return getNumber().sum();
	}
	private void exceptionNoNegative() {
		String message=getNumber().filter(n -> n <0).mapToObj(Integer::toString).collect(Collectors.joining(","));
		if(!message.isEmpty()) {
			throw new IllegalArgumentException("number is: "+message);
		}
	}

	private IntStream getNumber() {
		return Arrays.stream(sum.split(delimiter)).mapToInt(Integer::parseInt).filter(n -> n<1000);
	}  	
}

