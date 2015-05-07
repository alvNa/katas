package com.katas;

/**
 * @author AlvaroNav
 *
 */
public class RomanToNumberConverter {

	public Integer convert(String roman) {
		Integer result = 0 ;
		int i = 0;
		int numAux = 0;
		while (i < roman.length()){
			numAux = convertSymbol(String.valueOf(roman.charAt(i)));
			if (isSubstractingSymbol(String.valueOf(roman.charAt(i))) && i+1 < roman.length() && 
					isSubstracting(String.valueOf(roman.charAt(i)), String.valueOf(roman.charAt(i+1)))){
				numAux*=-1;
			}
			result += numAux;
			i++;
		}
		
		return result;
	}

	private int convertSymbol(String i) {
		int result = 0;
		if ("I".equals(i)) {
			result = 1;
		}else if ("V".equals(i)) {
			result = 5;
		}else if ("X".equals(i)) {
			result = 10;
		}else if ("L".equals(i)) {
			result = 50;
		}else if ("C".equals(i)) {
			result = 100;
		}else if ("D".equals(i)) {
			result = 500;
		}else if ("M".equals(i)) {
			result = 1000;
		}
		
		return result;
	}
	
	private boolean isSubstractingSymbol(String i) {
		return "I".equals(i) || "X".equals(i) || "C".equals(i);
	}
	
	private boolean isSubstracting(String a, String b) {
		boolean isSubstracting = false;
		
		if ("I".equals(a) && ("V".equals(b) || "X".equals(b))){
			isSubstracting = true;
		}
		else if ("X".equals(a) && ("L".equals(b) || "C".equals(b))){
			isSubstracting = true;
		}
		else if ("C".equals(a) && ("D".equals(b) || "M".equals(b))){
			isSubstracting = true;
		}
		
		return isSubstracting;
	}
}
