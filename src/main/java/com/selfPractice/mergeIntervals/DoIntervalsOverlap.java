package com.selfPractice.mergeIntervals;

import java.util.*;

public class DoIntervalsOverlap {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Overlap Intervals: "+DoIntervalsOverlap.overlap(input));
    }

    public static boolean overlap(List<Interval> intervals) {
        if(intervals.size() < 2) {
            throw new IllegalArgumentException();
        }

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start)); //O(N*logN)

        List<Interval> mergedIntervals = new LinkedList<>();
        Iterator<Interval> intervalIterator = intervals.iterator();
        Interval interval = intervalIterator.next();
        int start = interval.start;
        int end = interval.end;

        while(intervalIterator.hasNext()) {
            interval = intervalIterator.next();
            if(interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                mergedIntervals.add(0, new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        mergedIntervals.add(0, new Interval(start, end));
        System.out.print("Merged intervals: ");
        for (Interval inter : mergedIntervals)
            System.out.print("[" + inter.start + "," + inter.end + "] ");
        System.out.println();
        return mergedIntervals.size() > 0;
    }
}
