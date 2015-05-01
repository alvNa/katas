package com.katas;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AlvaroNav
 * */
public class StringSplitter {

	public List<Integer> split(String numbers) {
		List<Integer> result = new ArrayList<Integer>();
		if (!numbers.isEmpty()) {
			String delimiter =",";
			String _numbers;
			
			if (numbers.startsWith("//")){
				String[] pre = numbers.split("\n");	
				delimiter = pre[0].split("//")[1];
				delimiter = delimiter.replaceAll("\\]\\[", "\\|");
				delimiter = delimiter.substring(delimiter.indexOf("[")+1,delimiter.indexOf("]"));
				delimiter = delimiter.replaceAll("\\*", "\\\\*");
				_numbers = pre[1];
			}
			else{
				_numbers = numbers;
			}
			
			String[] args = _numbers.split(""+delimiter+"|\n");
			for (String arg : args) {
				result.add(Integer.valueOf(arg));
			}
		}
		return result;
	}

}
