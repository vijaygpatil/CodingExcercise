package com.selfPractice.misc;
import java.util.ArrayList;
import java.util.List;

public class ElevatorProblem {

	public static int MAX_NUMBER_OF_PPL = 3;
	public static int MAX_WEIGHT = 250;
	public static int NUMBER_OF_FLOORS = 5;

	// assume person array is 0,1,....N-1 -> so N people
	// people are in a queue , find total number of stops
	public static int solution(int N, List<Integer> weight, List<Integer> floor) {
		int i = 0;
		int last_weight = 0;
		int last_count = 0;
		List<Integer> stops = new ArrayList<>();
		int stop_count = 0;
		while (i < N) {
			// lift full, dont put any more ppl
			if (last_count + 1 > MAX_NUMBER_OF_PPL || last_weight + weight.get(i) > MAX_WEIGHT) {
				stop_count += stops.size();
				stops.clear();
				last_weight = 0;
				last_count = 0;

			}

			// fill lift with the person
			stops.add(floor.get(i));
			last_count++;
			last_weight += weight.get(i);

			// fetch next person
			i++;
		}

		// handle last lift session
		if (stops.size() > 0) {
			stop_count += stops.size();
		}

		return stop_count;
	}

	public static void main(String[] args) {
		int N = 6;
		List<Integer> weight = new ArrayList<>();
		List<Integer> stops = new ArrayList<>();
		weight.add(100);
		weight.add(70);
		weight.add(60);
		weight.add(190);
		weight.add(100);
		weight.add(10);

		stops.add(5);
		stops.add(5);
		stops.add(5);
		stops.add(4);
		stops.add(3);
		stops.add(3);

		System.out.println(solution(N, weight, stops));
	}
}
