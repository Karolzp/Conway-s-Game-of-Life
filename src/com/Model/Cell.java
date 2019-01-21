package com.Model;

public class Cell {
    private boolean isAlive = false;
    private int neighbours = 0;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(int neighbours) {
        this.neighbours = neighbours;
    }
}
