package com.agv.vo;

public interface Maze {


    /**
     * Get what is at a coordinate
     *
     * @param coord the coordinate
     *
     * @return the type of field on a given coordinate
     */
    public MazeStructure whatIsAt(Coordinate coord);

    /**
     * Get the start location
     *
     * @return the start location of the Maze
     */
    public Coordinate getStart();


    /**
     * Get the exit location
     *
     * @return the exit location of the maze
     */
    public Coordinate getExit();

    //public void setVisited(int row, int col, boolean value);
    /**
     * Get the number of rows
     *
     * @return the number of rows
     */
    public int getYdimension();

    /**
     * Get the number of columns
     *
     * @return the number of columns
     */
    public int getXdimension();

    /**
     * Get the number of walls
     *
     * @return the number of walls
     */
    public int getNumberTotalWalls();

    /**
     * Get total number of empty spaces
     *
     * @return the number of empty spaces
     */
    public int getNumberTotalSpaces();


    /**
     * Get bidimentional array of characters of maze
     * @return
     */
    public char[][] getMaze();

}
