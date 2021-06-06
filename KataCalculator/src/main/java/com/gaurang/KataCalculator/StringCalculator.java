package com.gaurang.KataCalculator;

import java.util.Arrays;
import java.util.regex.Pattern;
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
    		String header = part[0];
			calculator = new StringCalculator(parseHeader(header),part[1]);
    	}
    	else
    		calculator =new StringCalculator(",|\n",input);
    	
    	return calculator.number();
    	}

	private static String parseHeader(String header) {
		String delimiter = header.substring(2);
		if(delimiter.startsWith("[")) {
			delimiter=delimiter.substring(1,delimiter.length()-1);
		}
		return Pattern.quote(delimiter);
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

