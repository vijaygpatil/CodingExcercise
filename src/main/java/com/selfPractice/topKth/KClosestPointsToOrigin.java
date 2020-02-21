package com.selfPractice.topKth;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints2(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }

    public static List<Point> findClosestPoints(Point[] points, int k) {
        PriorityQueue<Point> distanceSquareMinHeap = new PriorityQueue<>((a, b) -> a.distFromOrigin() - b.distFromOrigin());
        for(Point point : points) {
            distanceSquareMinHeap.add(point);
        }

        List<Point> resultList = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            resultList.add(distanceSquareMinHeap.peek());
            distanceSquareMinHeap.poll();
        }

        return resultList;
    }

    public static List<Point> findClosestPoints2(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a, b) -> b.distFromOrigin() - a.distFromOrigin());
        int i = 0;
        for(; i < k; i++) {
            maxHeap.add(points[i]);
        }

        for(; i < points.length; i++) {
            if(points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
                maxHeap.poll();
                maxHeap.add(points[i]);
            }
        }

        return new ArrayList<>(maxHeap);
    }
}
