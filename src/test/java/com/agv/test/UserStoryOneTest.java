package com.agv.test;

import com.agv.bo.MazeExploration;
import com.agv.dto.MazeSolver;
import com.agv.dto.MazeSolverImpl;
import com.agv.vo.Maze;
import com.agv.vo.MazeImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class UserStoryOneTest {
    private static final Logger logger = LogManager.getLogger(UserStoryOneTest.class);
    /**
     * Basic Objects and data types to change
     */
    private String fileName = "src/main/resources/maze.txt";


    /**
     * Objects created from basic ones
     */
    private int coordenatex;
    private int coordenatey;
    private Maze maze ;
    private MazeExploration mazeExploration;
    private File file;



    @Test
    public void countSpacesAndWalls(){
        MazeSolver mazeSolver = new MazeSolverImpl();
        try {
            file = new File(fileName);
            mazeSolver.userStoryOneOne(file);
        }catch(Exception e){
            logger.error("Problem to open file: " + fileName, e);
        }
    }

    @Test
    public void retrieveCharFromSpecificCoordenate(){
        coordenatex = 10;
        coordenatey = 2;

        MazeSolver mazeSolver = new MazeSolverImpl();

        try {
            file = new File(fileName);
            mazeSolver.userStoryOneTwo(file,coordenatex,coordenatey);
        }catch(Exception e){
            logger.error("Problem to open file: " + fileName, e);
        }
    }

    @Test
    public void retrieveCharFromWrongCoordenate(){
        coordenatex = 16;
        coordenatey = 20;

        MazeSolver mazeSolver = new MazeSolverImpl();

        try {
            file = new File(fileName);
            mazeSolver.userStoryOneTwo(file,coordenatex,coordenatey);
        }catch(Exception e){
            logger.error("Problem to open file: " + fileName, e);
        }
    }

    @Test
    public void wrongFileStructure(){
        coordenatex = 3;
        coordenatey = 2;
        String fileName = "src/main/resources/mazewrongdimentions.txt";

        MazeSolver mazeSolver = new MazeSolverImpl();

        try {
            file = new File(fileName);
            mazeSolver.userStoryOneTwo(file,coordenatex,coordenatey);
        }catch(Exception e){
            logger.error("Problem to open file: " + fileName, e);
        }
    }

    @Test
    public void starsPointsFile(){
        coordenatex = 3;
        coordenatey = 2;
        String fileName = "src/main/resources/mazewrongstarts.txt";

        MazeSolver mazeSolver = new MazeSolverImpl();

        try {
            file = new File(fileName);
            mazeSolver.userStoryOneTwo(file,coordenatex,coordenatey);
        }catch(Exception e){
            logger.error("Problem to open file: " + fileName, e);
        }
    }

}
