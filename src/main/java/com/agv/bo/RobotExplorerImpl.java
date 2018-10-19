package com.agv.bo;

import com.agv.bo.RobotExplorer;
import com.agv.vo.Coordinate;
import com.agv.vo.Maze;
import com.agv.vo.MazeStructure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class RobotExplorerImpl implements RobotExplorer {
    private static final Logger logger = LogManager.getLogger(RobotExplorerImpl.class);
    private Maze maze;
    private MazeExploration mazeExploration;
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public RobotExplorerImpl(Maze maze, MazeExploration mazeExploration) {
        this.maze = maze;
        this.mazeExploration = mazeExploration;
    }

    /**
     * Explorer looks for the Exit in a Recursive way
     * @return
     */
    @Override
    public List<Coordinate> lookForExit() {
        List<Coordinate> path = new ArrayList<>();
        if (explore(maze.getStart()
                        .getXposition(),
                maze.getStart()
                        .getYposition(),
                path)) {
            return path;
        }
        return Collections.emptyList();
    }


    @Override
    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    /**
     * Exploration Recursive method
     * @param row
     * @param col
     * @param path
     * @return
     */
    private boolean explore(int row, int col, List<Coordinate> path) {
        if (!mazeExploration.isValidLocation(row, col) || mazeExploration.isWall(row, col) || mazeExploration.isExplored(row, col)) {
            return false;
        }

        path.add(new Coordinate(row, col));
        mazeExploration.setVisited(row, col, true);

        if (mazeExploration.isExit(row, col)) {
            return true;
        }

        /**
         * Directions to be take it, North, South, West, East
         */
        for (int[] direction : DIRECTIONS) {
            Coordinate coordinate = getNextCoordinate(row, col, direction[0], direction[1]);
            if (explore(coordinate.getXposition(), coordinate.getYposition(), path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    /**
     * Row Directions of the explorer
     * @param row
     * @param col
     * @param i
     * @param j
     * @return
     */
    private Coordinate getNextCoordinate(int row, int col, int i, int j) {
        return new Coordinate(row + i, col + j);
    }

}
