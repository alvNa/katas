package com.katas;

/**
 * @author AlvaroNav
 * */
public class FizzBuzz {
	public static final String FIZZ_VALUE = "Fizz";
	public static final String BUZZ_VALUE = "Buzz";
	public static final String FIZZBUZZ_VALUE = "Buzz";
	
	public boolean isFizz(int i) {
		return i % 3 == 0;
	}

	public boolean isBuzz(int i) {
		return i % 5 == 0;
	}

	public boolean isFizzBuzz(int i) {
		return i % 3 == 0 && i % 5 == 0;
	}

	public String toFizzBuzz(int i) {
		String num = "";
		if (isFizzBuzz(i)) {
			num = FIZZBUZZ_VALUE;
		} else if (isFizz(i)) {
			num = FIZZ_VALUE;
		} else if (isBuzz(i)) {
			num = BUZZ_VALUE;
		} else {
			num = Integer.toString(i);
		}
		return num;
	}

	public String[] toFizzBuzz(int[] array) {
		String[] result = new String[array.length];

		for (int i = 0; i < array.length; i++) {
			result[i] = toFizzBuzz(array[i]);
		}

		return result;
	}

	public static void main(String[] args) {
		FizzBuzz fb = new FizzBuzz();

		for (int i = 1; i <= 100; i++) {
			System.out.println(fb.toFizzBuzz(i));
		}
	}
}
