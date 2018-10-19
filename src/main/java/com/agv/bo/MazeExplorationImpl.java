package com.agv.bo;

import com.agv.vo.Coordinate;
import com.agv.vo.Maze;
import com.agv.vo.MazeImpl;
import com.agv.vo.MazeStructure;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class MazeExplorationImpl implements  MazeExploration {
    private static final Logger logger = LogManager.getLogger(MazeExploration.class);
    private String[][] mazePath;
    private boolean visited[][];
    private String orderVisited[][];
    private int steps;
    private Maze maze;

    public MazeExplorationImpl(Maze maze){
        this.maze = maze;
        visited = new boolean[maze.getXdimension()][maze.getYdimension()];
        orderVisited = new String[maze.getXdimension()][maze.getYdimension()];;
        steps = 0;
    }

    /**
     * Validates if coordinates points to a visited location
     * @param row
     * @param col
     * @return
     */
    public boolean isLocationVisited(int row, int col) {
        return visited[row][col];
    }

    /**
     * Validates if coordintates points to a wall char
     * @param row
     * @param col
     * @return
     */
    public boolean isWall(int row, int col) {
        return maze.getMaze()[row][col] == MazeStructure.WALL.getValue();
    }

    /**
     * Visited bidimentional array of coordenates visited
     * @return
     */
    public boolean[][] getVisited() {
        return visited;
    }

    /**
     * Setting Maze Object
     * @param maze
     */
    public void setMaze(Maze maze){
        this.maze = maze;
    }

    /**
     * Validates if coordenate points to a valid location
     * @param row
     * @param col
     * @return
     */
    public boolean isValidLocation(int row, int col) {
        if (row < 0 || row >= maze.getYdimension() || col < 0 || col >= maze.getXdimension()) {
            return false;
        }
        return true;
    }

    /**
     * Validates if coordenated provided was explored
     * @param row
     * @param col
     * @return
     */
    public boolean isExplored(int row, int col) {
        return visited[row][col];
    }

    /**
     * Defines if a coordinate of the maze was visited and asigns the step in which was visiteds
     * @param row
     * @param col
     * @param value
     */
    public void setVisited(int row, int col, boolean value) {
        visited[row][col] = value;
        steps++;
        orderVisited[row][col] = StringUtils.leftPad(String.valueOf(steps),3,'0') ;
    }

    /**
     * Validates if is the end of the Maze
     * @param x
     * @param y
     * @return
     */
    public boolean isExit(int x, int y) {
        return x == maze.getExit().getXposition() && y == maze.getExit().getYposition();
    }

    /**
     * Return the number of steps made it to achieve the objective
     * @return
     */
    public int getSteps() {
        return steps;
    }

    /**
     * Returns Maze path with the steps made it
     * @return
     */
    public String[][] getMazePath() {
        return mazePath;
    }

    /**
     * Order and changes characters for the number of step made it of the explorer
     */
    private void transformMazePath(){
        char[][] tempMaze = Arrays.stream(maze.getMaze())
                .map(char[]::clone)
                .toArray(char[][]::new);

        mazePath = new String[maze.getXdimension()][maze.getYdimension()];
        for(int y=0;y<maze.getYdimension();y++){
            for(int x=0;x<maze.getXdimension();x++){

                if(tempMaze[y][x]==MazeStructure.SPACE.getValue() && orderVisited[y][x]!=null){
                    mazePath[y][x] = new String(orderVisited[y][x]);
                }else{
                    String val = StringUtils.leftPad(String.valueOf(tempMaze[y][x]),2,' ');

                    val = StringUtils.rightPad(val,3,' ');

                    mazePath[y][x] = val;
                }
            }
        }

    }

    /**
     * Print pretty maze
     * @param path
     */
    public void printPath(List<Coordinate> path) {
        transformMazePath();

        String val = Arrays.deepToString(getMazePath()).replace("], ", "]\n");
        logger.info("\n"+val);

    }

    public String toString(char[][] mazeCh) {
        StringBuilder result = new StringBuilder(maze.getYdimension() * (maze.getXdimension() + 1));
        for (int row = 0; row < maze.getXdimension(); row++) {
            for (int col = 0; col < maze.getYdimension(); col++) {
                if (mazeCh[row][col] == MazeStructure.SPACE.getValue()) {
                    result.append(MazeStructure.SPACE.getValue());
                } else if (mazeCh[row][col] == MazeStructure.WALL.getValue()) {
                    result.append(MazeStructure.WALL.getValue());
                } else if (mazeCh[row][col] == MazeStructure.START.getValue()) {
                    result.append(MazeStructure.START.getValue());
                } else if (mazeCh[row][col] == MazeStructure.EXIT.getValue()) {
                    result.append(MazeStructure.EXIT.getValue());
                } else {
                    result.append(MazeStructure.ROAD.getValue());
                }
            }
            result.append('\n');
        }
        return result.toString();
    }

    /**
     * Reset all the positions visited for the explorer
     */
    public void reset() {
        for (int i = 0; i < visited.length; i++)
            Arrays.fill(visited[i], false);
    }
}
