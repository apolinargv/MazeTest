package com.agv.vo;

/**
 * Class that represents a coordinate in the maze
 */
public class Coordinate {
    private int xposition;
    private int yposition;
    private Coordinate parent;

    public Coordinate(int xposition, int yposition, Coordinate parent) {
        this.xposition = xposition;
        this.yposition = yposition;
        this.parent = parent;
    }

    public Coordinate(int xposition, int yposition) {
        this.xposition = xposition;
        this.yposition = yposition;
    }

    public Coordinate getParent() {
        return parent;
    }

    public void setParent(Coordinate parent) {
        this.parent = parent;
    }

    public int getXposition() {
        return xposition;
    }

    public void setXposition(int xposition) {
        this.xposition = xposition;
    }

    public int getYposition() {
        return yposition;
    }

    public void setYposition(int yposition) {
        this.yposition = yposition;
    }
}
