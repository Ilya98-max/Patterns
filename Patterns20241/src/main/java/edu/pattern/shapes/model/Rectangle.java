package edu.pattern.shapes.model;

import edu.pattern.shapes.observer.Observable;
import edu.pattern.shapes.observer.RectangleObserver;
import edu.pattern.shapes.observer.impl.RectangleObserverImpl;
import edu.pattern.shapes.util.IdGenerator;


import java.util.logging.Logger;



public class Rectangle implements Observable {
    private static final Logger logger = Logger.getLogger(String.valueOf(Rectangle.class));

    private Point topLeft;
    private Point topRight;
    private Point bottomLeft;
    private Point bottomRight;

    private RectangleObserver observer = new RectangleObserverImpl();
    private int id;

    public Rectangle(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
        this.id = IdGenerator.increment();
        logger.info("Rectangle with id " + id + " and points " + topLeft + ", " + topRight + ", " + bottomLeft + ", " + bottomRight + " is created");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyObservers();
        logger.info("Id of rectangle with id " + id + " is changed");
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
        notifyObservers();
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
        notifyObservers();
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
        notifyObservers();
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
        notifyObservers();
    }

    @Override
    public void attach() {
        observer = new RectangleObserverImpl();
    }

    @Override
    public void detach() {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.update(this);
        }
    }
}





