package com.gaurang.KataCalculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator 
{
    public static int add(String input) {
    	if(input.isEmpty())
    		return 0;
    	
    	Stream<String> sum=Arrays.stream(input.split(","));
    	return sum.mapToInt(Integer::parseInt).sum();
    	}
    	
}

