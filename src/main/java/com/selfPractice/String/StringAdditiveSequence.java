package com.selfPractice.String;

public class StringAdditiveSequence {
	public static void main(String[] args) {
		String num = "235813";
		boolean res = isAdditiveNumber(num);
		System.out.println(res);

		num = "199100199";
		res = isAdditiveNumber(num);
		System.out.println(res);
		
		num = "1991001992";
		res = isAdditiveNumber(num);
		System.out.println(res);
	}

	public static boolean isAdditiveNumber(String num) {
		for (int i = 1; i <= num.length() / 2; i++) { // for every end i
			for (int j = i + 1; j < num.length(); j++) {
				if (isValid(num.substring(0, i), num.substring(i, j), num.substring(j)))
					return true;
			}
		}
		return false;
	}

	private static boolean isValid(String a, String b, String rest) {
		if (rest.length() == 0)
			return true;
		if (a.charAt(0) == '0' && a.length() != 1)
			return false;
		if (b.charAt(0) == '0' && b.length() != 1)
			return false;
		String c = add(a, b, 0);
		return rest.indexOf(c) == 0 && isValid(b, c, rest.substring(c.length()));
	}

	private static String add(String a, String b, int c) {
		if (a.length() == 0 && b.length() == 0)
			return c == 0 ? "" : "" + c;
		int x = 0, y = 0;
		if (a.length() != 0) {
			x = a.charAt(a.length() - 1) - '0';
			a = a.substring(0, a.length() - 1);
		}
		if (b.length() != 0) {
			y = b.charAt(b.length() - 1) - '0';
			b = b.substring(0, b.length() - 1);
		}
		int res = (x + y + c) % 10;
		c = (x + y + c) / 10;
		return add(a, b, c) + res;
	}
}