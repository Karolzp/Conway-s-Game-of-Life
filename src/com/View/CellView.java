package com.View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CellView {
    private Rectangle cellGraphicRepresentation = new Rectangle();
    private Color alive = Color.BLACK;
    private Color dead = Color.WHITE;

    public CellView() {
        this.cellGraphicRepresentation.setHeight(10);
        this.cellGraphicRepresentation.setWidth(10);
        this.makeCellDead();
    }

    public Rectangle getCellGraphicRepresentation() {
        return cellGraphicRepresentation;
    }

    public void makeCellAlive() {
        this.cellGraphicRepresentation.setFill(alive);
    }

    public void makeCellDead() {
        this.cellGraphicRepresentation.setFill(dead);
    }

}
