package com.selfPractice.misc;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MorseCodeToEnglish {
	public static void main(String[] args) {
		MorseCodeToEnglish obj = new MorseCodeToEnglish();
		System.out.println(obj.getFile("resource/morseCode.txt"));
	}
	
	String getFile(String fileName) {
		StringBuilder result = new StringBuilder("");

		//Get file from resource folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();
	}
}
