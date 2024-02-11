package com.selfPractice.HashMap;

import java.util.*;

class DesignHashMap {
    // Initialize hash map here
    public int keySpace;
    public List<Bucket> hashMap;

    public DesignHashMap(int keySpace) {
        this.keySpace = keySpace;
        this.hashMap = new ArrayList<>(Collections.nCopies(keySpace, new Bucket()));
    }

    // Function to add value of a given key in the
    // hash map at the relevant hash address
    public void put(int key, int value) {
        int hashKey = key % this.keySpace;
        this.hashMap.get(hashKey).update(key, value);
    }

    // Function to fetch corresponding value of a given key
    public int get(int key) {
        int hashKey = key % this.keySpace;
        return this.hashMap.get(hashKey).get(key);
    }

    public void remove(int key) {
        int hashKey = key % this.keySpace;
        this.hashMap.get(hashKey).remove(key);
    }

    public static void main(String args[]) {
        int keySpace = 11;
        DesignHashMap inputHashMap = new DesignHashMap(keySpace);
        List<Integer> keysList = new ArrayList<>(Arrays.asList(5, 11, 12, 15, 22, 10));
        List<String> funcs = Arrays.asList("Get", "Get", "Put", "Get", "Put", "Get", "Get", "Remove", "Get", "Get", "Remove", "Get");
        List<List<Integer>> funcKeys = Arrays.asList(
                Arrays.asList(5), Arrays.asList(15), Arrays.asList(15, 250),
                Arrays.asList(15), Arrays.asList(121, 110), Arrays.asList(121),
                Arrays.asList(10), Arrays.asList(11), Arrays.asList(11),
                Arrays.asList(13), Arrays.asList(13), Arrays.asList(0));

        for (int i = 0; i < funcs.size(); i++) {
            if (funcs.get(i).equals("Put")) {
                System.out.println(i + 1 + ".\t put(" + funcKeys.get(i).get(0) + ", " + funcKeys.get(i).get(1) + ")");
                if (!keysList.contains(funcKeys.get(i).get(0))) {
                    keysList.add(funcKeys.get(i).get(0));
                }
                inputHashMap.put(funcKeys.get(i).get(0), funcKeys.get(i).get(1));
            } else if (funcs.get(i).equals("Get")) {
                System.out.println(i + 1 + ".\t get(" + funcKeys.get(i).get(0) + ")");
                System.out.println("\t Value returned: " + inputHashMap.get(funcKeys.get(i).get(0)));
            } else if (funcs.get(i).equals("Remove")) {
                System.out.println(i + 1 + ".\t remove(" + funcKeys.get(i).get(0) + ")");
                inputHashMap.remove(funcKeys.get(i).get(0));
            }

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}