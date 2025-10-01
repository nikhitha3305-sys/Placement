package structural;

import java.util.ArrayList;
import java.util.List;

/*
 * Composite Pattern demonstration.
 * Use case: Graphic objects composed of multiple shapes treated uniformly as a single object.
 * Composite pattern composes objects into tree structures to represent part-whole hierarchies.
 */

interface Graphic {
    void draw();
}

class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class CompositeGraphic implements Graphic {
    private List<Graphic> childGraphics = new ArrayList<>();

    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }

    public void remove(Graphic graphic) {
        childGraphics.remove(graphic);
    }

    @Override
    public void draw() {
        for(Graphic graphic : childGraphics) {
            graphic.draw();
        }
    }
}

public class CompositeDemo {
    public static void main(String[] args) {
        CompositeGraphic graphic = new CompositeGraphic();

        Circle circle1 = new Circle();
        Square square1 = new Square();
        CompositeGraphic subGraphic = new CompositeGraphic();

        Circle circle2 = new Circle();
        Square square2 = new Square();

        graphic.add(circle1);
        graphic.add(square1);

        subGraphic.add(circle2);
        subGraphic.add(square2);

        graphic.add(subGraphic);

        graphic.draw();
    }
}
