package com.bastex.codelearninghub.designpatterns.structural.composite;

public class CompositeApp {
    public static void main(final String[] args) {
        final Line line = new Line();
        final Rectangle rectangle = new Rectangle();

        final GraphicItemGroup group = new GraphicItemGroup();

        group.getGraphics().add(line);
        group.getGraphics().add(rectangle);
        group.draw();

        final GraphicItemGroup group2 = new GraphicItemGroup();
        final Line line1 = new Line();
        group2.getGraphics().add(line1);
        group2.getGraphics().add(group);

        System.out.println("drawing group two");

        group2.draw();

        line.draw();
    }
}
