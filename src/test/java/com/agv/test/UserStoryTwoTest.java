package com.agv.test;

import com.agv.dto.MazeSolver;
import com.agv.dto.MazeSolverImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.File;

public class UserStoryTwoTest {
    private static final Logger logger = LogManager.getLogger(UserStoryTwoTest.class);

    private String fileName = "src/main/resources/maze.txt";
    private File file;

    @Test
    public void solveSolution(){
        MazeSolver mazeSolver = new MazeSolverImpl();
        try {
            file = new File(fileName);
            mazeSolver.userStoryTwo(file);
        }catch(Exception e){
            logger.error("Problem to open file: " + fileName, e);
        }


    }

    @Test
    public void printPath(){
        MazeSolver mazeSolver = new MazeSolverImpl();
        try {
            file = new File(fileName);
            mazeSolver.userStoryTwoPrinthPath(file);
        }catch(Exception e){
            logger.error("Problem to open file: " + fileName, e);
        }
        

    }
}
