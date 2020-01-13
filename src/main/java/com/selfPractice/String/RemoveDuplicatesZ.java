package com.selfPractice.String;

public class RemoveDuplicatesZ {

	public static String removeDup(char[] buf, int n) {
		char lastchar = buf[0];
		// i: index of input char
		// o: index of output char
		int o = 1;
		for (int i = 1; i < buf.length; i++) {
			if (o > 0 && buf[i] == buf[o - 1]) {
				lastchar = buf[o - 1];
				while (o > 0 && buf[o - 1] == lastchar) {
					o--;
				}
			} else if (buf[i] == lastchar) {
				// Don't copy to output
			} else {
				buf[o++] = buf[i];
			}
		}
		return new String(buf, 0, o);
	}

	public static void main(String[] args) {
		char str1[] = "geeksforgeeg".toCharArray();
		System.out.println(removeDup(str1, str1.length));

		char str2[] = "azxxxzy".toCharArray();
		System.out.println(removeDup(str2, str2.length));

		char str3[] = "caaabbbaac".toCharArray();
		System.out.println(removeDup(str3, str3.length));

		char str4[] = "gghhg".toCharArray();
		System.out.println(removeDup(str4, str4.length));

		char str5[] = "aaaacddddcappp".toCharArray();
		System.out.println(removeDup(str5, str5.length));

		char str6[] = "aaaaaaaaaa".toCharArray();
		System.out.println(removeDup(str6, str6.length));

		char str7[] = "qpaaaaadaaaaadprq".toCharArray();
		System.out.println(removeDup(str7, str7.length));

		char str8[] = "acaaabbbacdddd".toCharArray();
		System.out.println(removeDup(str8, str8.length));

		char str9[] = "acbbcddc".toCharArray();
		System.out.println(removeDup2(str9, str9.length));
	}

	// This function recursively removes duplicates
	// and returns modified string
	public static String removeDup2(char[] str, int n) {
		int k = 0; // To store index of result
		int i;
		// Start from second character and add
		// unique ones
		for (i = 1; i < n; i++) {
			// If different, increment k and add
			// previous character
			if (str[i - 1] != str[i])
				str[k++] = str[i - 1];

			else
				// Keep skipping (removing) characters
				// while they are same.
				while (str[i - 1] == str[i])
				i++;
		}

		// Add last character and terminator
		str[k++] = str[i - 1];
		str[k] = '\0';

		// Recur for string if there were some removed
		// character
		if (k != n)
			removeDup(str, k);// Shlemial Painter's Algorithm

		// If all characters were unique
		else
			return str.toString();
		return null;
	}
}
