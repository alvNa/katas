package com.katas;

import java.util.ArrayList;
import java.util.List;
/**
 * @author AlvaroNav
 * */
public class StringCalculator{
	private StringSplitter stringSplitter;
	
	public void setStringSplitter(StringSplitter stringSplitter) {
		this.stringSplitter = stringSplitter;
	}

	public int add(String numbers) {		
		Integer result = 0;
		List<Integer> negatives = new ArrayList<Integer>();
	
		for (Integer num: stringSplitter.split(numbers)){
			if (num<0){
				negatives.add(num);
			}
			else if (num<=1000)
			{
				result += num;
			}
		}
		
		if (!negatives.isEmpty())
		{
			throw new NumberFormatException("negatives not allowed - " + negatives.toString());
		}
		
		return result;
	}

}
