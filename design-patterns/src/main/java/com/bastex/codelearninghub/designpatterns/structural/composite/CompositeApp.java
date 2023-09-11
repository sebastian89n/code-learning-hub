package com.bastex.codelearninghub.designpatterns.structural.composite;

public class CompositeApp {
    public static void main(final String[] args) {
        final LineItem lineItem = new LineItem();
        final RectangleItem rectangleItem = new RectangleItem();

        final GraphicItemGroup group = new GraphicItemGroup();

        group.getGraphicItems().add(lineItem);
        group.getGraphicItems().add(rectangleItem);
        group.draw();

        final GraphicItemGroup group2 = new GraphicItemGroup();
        final LineItem lineItem1 = new LineItem();
        group2.getGraphicItems().add(lineItem1);
        group2.getGraphicItems().add(group);

        System.out.println("drawing group two");

        group2.draw();

        lineItem.draw();
    }
}
