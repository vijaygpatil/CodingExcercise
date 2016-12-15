package com.selfPractice.misc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapExample {

	public static void main(String[] args) {
		// creating unsorted map of employee id as a key and employee name as a
		// value
		Map<Integer, String> unsortMap = new HashMap<>();
		unsortMap.put(10, "Ashraf");
		unsortMap.put(5, "Sara");
		unsortMap.put(6, "Mohamed");
		unsortMap.put(20, "Esraa");
		unsortMap.put(1, "Bahaa");
		unsortMap.put(7, "Dalia");
		unsortMap.put(8, "Amira");
		unsortMap.put(99, "Ahmed");
		unsortMap.put(50, "Sama");
		unsortMap.put(2, "Nada");
		unsortMap.put(9, "Osama");

		System.out.println("Unsort Map......");
		printMap(unsortMap);

		// Using the default natural ordering of sorted map Integer key which
		// implement Comparable interface
		System.out.println("\nSorted Map in ascending order......");
		Map<Integer, String> ascSortedMap = new TreeMap<>();
		ascSortedMap.putAll(unsortMap);
		printMap(ascSortedMap);

		// Forcing the descending order by creating our own comparator then
		// passing it to the sorted map at creation time
		System.out.println("\nSorted Map in descending order......");
		Map<Integer, String> desSortedMap = new TreeMap<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		desSortedMap.putAll(unsortMap);
		printMap(desSortedMap);

	}

	public static void printMap(Map<Integer, String> map) {
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
	}
}
