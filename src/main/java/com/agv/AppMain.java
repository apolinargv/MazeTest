package com.agv;

import com.agv.bo.*;
import com.agv.dto.MazeSolver;
import com.agv.dto.MazeSolverImpl;
import com.agv.vo.Coordinate;
import com.agv.vo.Maze;
import com.agv.vo.MazeImpl;
import com.agv.vo.MazeStructure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AppMain {

    private static final Logger logger = LogManager.getLogger(AppMain.class);

    public static void main(String[] args) throws Exception {
        File mazeFile = new File("src/main/resources/maze.txt");
        int coordenateX = 13;
        int coordenateY = 2;

        MazeSolver mazeSolver = new MazeSolverImpl();
        mazeSolver.userStoryOne(mazeFile,coordenateX,coordenateY);
        mazeSolver.userStoryTwo(mazeFile);
        mazeSolver.userStoryTwoPrinthPath(mazeFile);
    }



}
