package com.katas;

/**
 * @author AlvaroNav
 */
public class NumberToRomanConverter {

	public String convert(Integer num) {
		String result = "";
		int length = (int) (Math.log10(num) + 1);

		for (int idx = 0; idx < length; idx++) {

			switch (idx) {
			case 0:
				result = convertUnits(num % 10) + result;
				break;
			case 1:
				result = convertTens((num / 10) % 10) + result;
				break;
			case 2:
				result = convertCents((num / 100) % 10) + result;
				break;
			case 3:
				result = convertMills((num / 1000) % 10) + result;
				break;
			}
		}

		return result;
	}

	private String convertMills(int i) {
		String result = "";
		switch (i) {
		case 1:
			result = "M";
			break;
		case 2:
			result = "MM";
			break;
		case 3:
			result = "MMM";
			break;
		}

		return result;
	}

	private String convertCents(int i) {
		String result = "";
		switch (i) {
		case 1:
			result = "C";
			break;
		case 2:
			result = "CC";
			break;
		case 3:
			result = "CCC";
			break;
		case 4:
			result = "CD";
			break;
		case 5:
			result = "D";
			break;
		case 6:
			result = "DC";
			break;
		case 7:
			result = "DCC";
			break;
		case 8:
			result = "DCCC";
			break;
		case 9:
			result = "CM";
			break;
		}
		return result;
	}

	private String convertUnits(int i) {
		String result = "";
		switch (i) {
		case 1:
			result = "I";
			break;
		case 2:
			result = "II";
			break;
		case 3:
			result = "III";
			break;
		case 4:
			result = "IV";
			break;
		case 5:
			result = "V";
			break;
		case 6:
			result = "VI";
			break;
		case 7:
			result = "VII";
			break;
		case 8:
			result = "VIII";
			break;
		case 9:
			result = "IX";
			break;
		}
		return result;
	}

	private String convertTens(int i) {
		String result = "";
		switch (i) {
		case 1:
			result = "X";
			break;
		case 2:
			result = "XX";
			break;
		case 3:
			result = "XXX";
			break;
		case 4:
			result = "XL";
			break;
		case 5:
			result = "L";
			break;
		case 6:
			result = "LX";
			break;
		case 7:
			result = "LXX";
			break;
		case 8:
			result = "LXXX";
			break;
		case 9:
			result = "XC";
			break;
		}
		return result;
	}

}
