package edu.pattern.shapes.observer.impl;

import edu.pattern.shapes.model.Rectangle;

import edu.pattern.shapes.model.RectangleState;
import edu.pattern.shapes.model.Warehouse;
import edu.pattern.shapes.observer.RectangleObserver;
import edu.pattern.shapes.service.RectangleService;
;

public class RectangleObserverImpl implements RectangleObserver {
    @Override
    public void update(Rectangle rectangle) {
        RectangleState state = RectangleState.detect(rectangle.getTopLeft(), rectangle.getTopRight(),
                rectangle.getBottomLeft(), rectangle.getBottomRight());
        if (state == RectangleState.VALID) {
            RectangleService service = new RectangleService();
            double perimeter = service.calculatePerimeter(rectangle);
            int key = rectangle.getId();
            Warehouse warehouse = Warehouse.getInstance();
            warehouse.put(key, perimeter);
        } else {

        }
    }
}
