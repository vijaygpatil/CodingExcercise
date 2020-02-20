package com.selfPractice.mergeIntervals;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        // sort the intervals by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<Interval>();
        for(int i = 0; i < intervals.size() ; i++) {
            int aend = intervals.get(i).end;
            int bstart = 0;
            if(intervals.get(i+1) != null) {
                bstart = intervals.get(i + 1).start;
            } else {
                mergedIntervals.add(0, intervals.get(i));
            }

            if(bstart <= aend ) {
                Interval mergedInterval = new Interval(intervals.get(i).start, Math.max(intervals.get(i+1).end, aend));
                mergedIntervals.add(0, mergedInterval);
                i++;
            } else {
                mergedIntervals.add(0, intervals.get(i));
            }
        }

        return mergedIntervals;
    }

    public static List<Interval> merge1(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        // sort the intervals by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalItr.hasNext()) {
            interval = intervalItr.next();
            if (interval.start <= end) { // overlapping intervals, adjust the 'end'
                end = Math.max(interval.end, end);
            } else { // non-overlapping interval, add the previous interval and reset
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // add the last interval
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }
}
