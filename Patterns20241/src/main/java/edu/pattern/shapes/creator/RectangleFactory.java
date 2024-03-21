package edu.pattern.shapes.creator;

import edu.pattern.shapes.model.Rectangle;

import java.util.List;


import edu.pattern.shapes.model.Point;

import java.util.List;

public interface RectangleFactory {
    List<Rectangle> createRectanglesFromFile(String filePath);
}
