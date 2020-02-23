package com.selfPractice.Subsets;

import java.util.ArrayList;
import java.util.List;

public class LetterCaseStringPermutation {
    public static List<String> findLetterCaseStringPermutations2(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null)
            return permutations;

        permutations.add(str);
        // process every character of the string one by one
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) { // only process characters, skip digits
                // we will take all existing permutations and change the letter case appropriately
                int n = permutations.size();
                for (int j = 0; j < n; j++) {
                    char[] chs = permutations.get(j).toCharArray();
                    // if the current character is in upper case change it to lower case or vice versa
                    if (Character.isUpperCase(chs[i]))
                        chs[i] = Character.toLowerCase(chs[i]);
                    else
                        chs[i] = Character.toUpperCase(chs[i]);
                    permutations.add(String.valueOf(chs));
                }
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations3("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations3("ab7c");
        System.out.println(" String permutations are: " + result);
    }

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> result = new ArrayList<>();
        if(str == null) {
            return result;
        }

        result.add(str);
        for(int i = 0; i < str.length(); i++) {
            if(Character.isLetter(str.charAt(i))) {
                int n = result.size();
                for(int j = 0; j < n; j++) {
                    char[] chs = result.get(j).toCharArray();
                    if(Character.isUpperCase(chs[i])){
                        chs[i] = Character.toLowerCase(chs[i]);
                    } else {
                        chs[i] = Character.toUpperCase(chs[i]);
                    }

                    result.add(String.valueOf(chs));
                }
            }
        }
        return result;
    }

    public static List<String> findLetterCaseStringPermutations3(String str) {
        List<String> results = new ArrayList<>();
        if(str == null) {
            return results;
        }

        results.add(str);
        for(int i = 0; i < str.length(); i++) {
            if(Character.isLetter(str.charAt(i))) {
                int n = results.size();
                for(int j = 0; j < n; j++) {
                    char[] chs = results.get(j).toCharArray();
                    if(Character.isUpperCase(chs[i])){
                        chs[i] = Character.toLowerCase(chs[i]);
                    } else {
                        chs[i] = Character.toUpperCase(chs[i]);
                    }
                    results.add(String.valueOf(chs));
                }
            }
        }
        return results;
    }
}
