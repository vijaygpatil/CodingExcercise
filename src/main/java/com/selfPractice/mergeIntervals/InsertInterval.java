package com.selfPractice.mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(8, 12));
        Interval insert = new Interval(4, 6);

        System.out.print("Insert and Merged intervals: ");
        for (Interval interval : InsertInterval.insertAndMerge2(intervals, insert))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

    public static List<Interval> insertAndMerge2(List<Interval> intervals, Interval insert) {

        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;

        while(i < intervals.size() && intervals.get(i).end < insert.start) {
            mergedIntervals.add(intervals.get(i++));
        }

        while(i < intervals.size() && intervals.get(i).start <= insert.end) {
            insert.start = Math.min(insert.start, intervals.get(i).start);
            insert.end = Math.max(insert.end, intervals.get(i).end);
            i++;
        }

        mergedIntervals.add(insert);

        while(i < intervals.size()) {
            mergedIntervals.add(intervals.get(i++));
        }

        return mergedIntervals;
    }




































    public static List<Interval> insertAndMerge(List<Interval> intervals, Interval insert) {

        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;

        while(i < intervals.size() && intervals.get(i).end < insert.start) {
            mergedIntervals.add(intervals.get(i++));
        }

        while(i < intervals.size() && intervals.get(i).start <= insert.end) {
            insert.start = Math.min(insert.start, intervals.get(i).start);
            insert.end = Math.max(insert.end, intervals.get(i).end);
            i++;
        }

        mergedIntervals.add(insert);

        while(i < intervals.size()) {
            mergedIntervals.add(intervals.get(i++));
        }

        return mergedIntervals;
    }
}
