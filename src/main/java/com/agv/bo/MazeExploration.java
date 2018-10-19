package com.agv.bo;

import com.agv.vo.Coordinate;
import com.agv.vo.Maze;

import java.util.List;

public interface MazeExploration {
    /**
     * Validates if coordinates points to a visited location
     * @param row
     * @param col
     * @return
     */
    public boolean isLocationVisited(int row, int col);

    /**
     * Validates if coordintates points to a wall char
     * @param row
     * @param col
     * @return
     */
    public boolean isWall(int row, int col);

    /**
     * Visited bidimentional array of coordenates visited
     * @return
     */
    public boolean[][] getVisited();

    /**
     * Setting Maze Object
     * @param maze
     */
    public void setMaze(Maze maze);

    /**
     * Validates if coordenate points to a valid location
     * @param row
     * @param col
     * @return
     */
    public boolean isValidLocation(int row, int col);

    /**
     * Validates if coordenated provided was explored
     * @param row
     * @param col
     * @return
     */
    public boolean isExplored(int row, int col);

    /**
     * Defines if a coordinate of the maze was visited and asigns the step in which was visiteds
     * @param row
     * @param col
     * @param value
     */
    public void setVisited(int row, int col, boolean value);

    /**
     * Validates if is the end of the Maze
     * @param x
     * @param y
     * @return
     */
    public boolean isExit(int x, int y);

    /**
     * Return the number of steps made it to achieve the objective
     * @return
     */
    public int getSteps();

    /**
     * Returns Maze path with the steps made it
     * @return
     */
    public String[][] getMazePath();
    /**
     * Print pretty maze
     * @param path
     */
    public void printPath(List<Coordinate> path);
    /**
     * Reset all the positions visited for the explorer
     */
    public void reset();

}
