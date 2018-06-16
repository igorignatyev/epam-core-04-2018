package com.epam.homework.task26;

import java.util.*;

public class Task26Impl implements Task26 {

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {

        Map<ISegment, Set<I2DPoint>> intersections = new TreeMap<>(Comparator.comparingDouble(o -> o.first().getX()));

        Iterator<ISegment> iter = segments.iterator();
        while (iter.hasNext()) {
            ISegment segment = iter.next();
            Set<I2DPoint> pointsOfIntersections = new HashSet<>();
            iter.forEachRemaining(anotherSegment -> {
                if (doIntersect(segment, anotherSegment)) {
                    I2DPoint pointOfIntersection = intersection(segment, anotherSegment);
                    pointsOfIntersections.add(pointOfIntersection);
                }
            });
            intersections.put(segment, pointsOfIntersections);
        }

        double minX = Double.MAX_VALUE;
        for (Map.Entry<ISegment, Set<I2DPoint>> entry : intersections.entrySet()) {
            I2DPoint minXPoint = entry.getValue().stream().min(Comparator.comparingDouble(I2DPoint::getX)).get();
            if (Double.compare(minXPoint.getX(), minX) < 0) {
                minX = minXPoint.getX();
            }
        }

        Set<I2DPoint> result = new HashSet<>();
        for (Map.Entry<ISegment, Set<I2DPoint>> entry : intersections.entrySet()) {
            for (I2DPoint point: entry.getValue()) {
                if (Double.compare(point.getX(), minX) == 0) {
                    result.add(point);
                }
            }
        }

        return result;

    }

    private I2DPoint intersection(ISegment first, ISegment second) {

        double x1 = first.first().getX();
        double y1 = first.first().getY();
        double x2 = first.second().getX();
        double y2 = first.second().getY();
        double x3 = second.first().getX();
        double y3 = second.first().getY();
        double x4 = second.second().getX();
        double y4 = second.second().getY();

        double a1 = (y2 - y1)/(x2 - x1);
        double b1 = (y1 * x2 - y2 * x1)/(x2 - x1);
        double a2 = (y4 - y3)/(x4 - x3);
        double b2 = (y3 * x4 - y4 * x3)/(x4 - x3);

        double x = (b2 - b1)/(a2 - a1);
        double y = (a1 * b2 - a2 * b1)/(a2 - a1);

        return new I2DPoint() {
            @Override
            public double getX() {
                return x;
            }

            @Override
            public double getY() {
                return y;
            }
        };

    }

    private boolean doIntersect(ISegment first, ISegment second) {

        I2DPoint p1 = first.first();
        I2DPoint p2 = first.second();
        I2DPoint p3 = second.first();
        I2DPoint p4 = second.second();

        double d1 = direction(p3, p4, p1);
        double d2 = direction(p3, p4, p2);
        double d3 = direction(p1, p2, p3);
        double d4 = direction(p1, p2, p4);

        return d1 * d2 < 0 && d3 * d4 < 0
                || Double.valueOf(0).equals(d1) && isPointOnSegment(second, p1)
                || Double.valueOf(0).equals(d2) && isPointOnSegment(second, p2)
                || Double.valueOf(0).equals(d3) && isPointOnSegment(first, p3)
                || Double.valueOf(0).equals(d4) && isPointOnSegment(first, p4);

    }

    private double direction(I2DPoint p1, I2DPoint p2, I2DPoint p3) {
        return (p3.getX() - p1.getX()) * (p2.getY() - p1.getY()) - (p3.getX() - p1.getX()) * (p2.getY() - p1.getY());
    }

    private boolean isPointOnSegment(ISegment segment, I2DPoint point) {
        return Math.min(segment.first().getX(), segment.second().getX()) <= point.getX() &&
                Math.max(segment.first().getX(), segment.second().getX()) >= point.getX() &&
                Math.min(segment.first().getY(), segment.second().getY()) <= point.getY() &&
                Math.max(segment.first().getY(), segment.second().getY()) >= point.getY();
    }

}
