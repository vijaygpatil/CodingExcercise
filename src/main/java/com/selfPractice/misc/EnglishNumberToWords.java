package com.selfPractice.misc;

import java.text.DecimalFormat;

public class EnglishNumberToWords {

	private static final String[] tentys = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety" };

	private static final String[] oneTeens = { "", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen" };

	private static String getEnglishTransformation(int number) {
		String result;

		if (number % 100 < 20) {
			result = oneTeens[number % 100];
			number /= 100;
		} else {
			result = oneTeens[number % 10];
			number /= 10;

			result = tentys[number % 10] + result;
			number /= 10;
		}
		if (number == 0)
			return result;
		return oneTeens[number] + " hundred" + result;
	}

	public static String convert(long num) {
		// 0 to 999 999 999 999
		if (num == 0) {
			return "zero";
		}

		String numString = new DecimalFormat("000000000000").format(num);

		// XXXnnnnnnnnn
		int billions = Integer.parseInt(numString.substring(0, 3));
		// nnnXXXnnnnnn
		int millions = Integer.parseInt(numString.substring(3, 6));
		// nnnnnnXXXnnn
		int hundredThousands = Integer.parseInt(numString.substring(6, 9));
		// nnnnnnnnnXXX
		int thousands = Integer.parseInt(numString.substring(9, 12));

		String billionStr;
		switch (billions) {
			case 0:
				billionStr = "";
				break;
			case 1:
				billionStr = getEnglishTransformation(billions) + " billion ";
				break;
			default:
				billionStr = getEnglishTransformation(billions) + " billion ";
		}
		String result = billionStr;

		String millionStr;
		switch (millions) {
			case 0:
				millionStr = "";
				break;
			case 1:
				millionStr = getEnglishTransformation(millions) + " million ";
				break;
			default:
				millionStr = getEnglishTransformation(millions) + " million ";
		}
		result = result + millionStr;

		String hundredThousandStr;
		switch (hundredThousands) {
			case 0:
				hundredThousandStr = "";
				break;
			case 1:
				hundredThousandStr = "one thousand ";
				break;
			default:
				hundredThousandStr = getEnglishTransformation(hundredThousands) + " thousand ";
		}
		result = result + hundredThousandStr;
		
		result = result + getEnglishTransformation(thousands);

		// remove extra spaces!
		return result;//.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
	}

	/**
	 * testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println("*** " + EnglishNumberToWords.convert(0));
//		System.out.println("*** " + EnglishNumberToWords.convert(1));
//		System.out.println("*** " + EnglishNumberToWords.convert(16));
//		System.out.println("*** " + EnglishNumberToWords.convert(100));
//		System.out.println("*** " + EnglishNumberToWords.convert(118));
//		System.out.println("*** " + EnglishNumberToWords.convert(200));
//		System.out.println("*** " + EnglishNumberToWords.convert(219));
//		System.out.println("*** " + EnglishNumberToWords.convert(800));
//		System.out.println("*** " + EnglishNumberToWords.convert(801));
//		System.out.println("*** " + EnglishNumberToWords.convert(1316));
//		System.out.println("*** " + EnglishNumberToWords.convert(1000000));
//		System.out.println("*** " + EnglishNumberToWords.convert(2000000));
//		System.out.println("*** " + EnglishNumberToWords.convert(3000200));
//		System.out.println("*** " + EnglishNumberToWords.convert(700000));
//		System.out.println("*** " + EnglishNumberToWords.convert(9000000));
//		System.out.println("*** " + EnglishNumberToWords.convert(9001000));
//		System.out.println("*** " + EnglishNumberToWords.convert(123456789));
		System.out.println("*** " + EnglishNumberToWords.convert(2147483647));
//		System.out.println("*** " + EnglishNumberToWords.convert(3000000010L));

		/*
		 *** zero one sixteen one hundred one hundred eighteen two hundred two
		 * hundred nineteen eight hundred eight hundred one one thousand three
		 * hundred sixteen one million two millions three millions two hundred
		 *** seven hundred thousand nine millions nine millions one thousand one
		 * hundred twenty three millions four hundred fifty six thousand seven
		 * hundred eighty nine two billion one hundred forty seven millions four
		 * hundred eighty three thousand six hundred forty seven three billion
		 * ten
		 **/
	}
}
