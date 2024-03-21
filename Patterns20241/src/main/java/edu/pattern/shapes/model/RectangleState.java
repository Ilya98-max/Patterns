package edu.pattern.shapes.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum RectangleState {
    VALID, INVALID;

    public static RectangleState detect(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight) {
        if (topLeft == null || topRight == null || bottomLeft == null || bottomRight == null) {
            throw new IllegalArgumentException("All points must be provided");
        }

        double side1 = distanceBetweenPoints(topLeft, topRight);
        double side2 = distanceBetweenPoints(topLeft, bottomLeft);
        double side3 = distanceBetweenPoints(topRight, bottomRight);
        double side4 = distanceBetweenPoints(bottomLeft, bottomRight);

        Set<Double> uniqueSides = new HashSet<>(Arrays.asList(side1, side2, side3, side4));

        if (uniqueSides.size() == 2) {
            return RectangleState.VALID;
        } else {
            return RectangleState.INVALID;
        }
    }

    private static double distanceBetweenPoints(Point p1, Point p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
