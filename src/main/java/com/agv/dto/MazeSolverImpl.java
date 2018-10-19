package com.agv.dto;

import com.agv.bo.MazeExploration;
import com.agv.bo.MazeExplorationImpl;
import com.agv.bo.RobotExplorer;
import com.agv.bo.RobotExplorerImpl;
import com.agv.vo.Coordinate;
import com.agv.vo.Maze;
import com.agv.vo.MazeImpl;
import com.agv.vo.MazeStructure;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class MazeSolverImpl implements MazeSolver {
    private static final Logger logger = LogManager.getLogger(MazeSolverImpl.class);

    private MazeExploration exploration;
    private List<Coordinate> coordinatesSolution;


    @Override
    public void userStoryOneOne(File file) throws  FileNotFoundException{
        Maze maze = new MazeImpl(file);
        logger.info("\n--------------------MAZE-------------------------\n\n"+((MazeImpl) maze).getMazeStr());

        logger.info("\n\n-------------SECTION 1.1-------------\nAfter a maze has been created the number of walls and empty spaces should be available to me");
        logger.info("Number of total walls in the maze: " + maze.getNumberTotalWalls());
        logger.info("Number of total empty spaces in the maze: " + maze.getNumberTotalSpaces());
    }

    @Override
    public void userStoryOneTwo(File file, int x, int y) throws  FileNotFoundException{
        Maze maze = new MazeImpl(file);
        exploration = new MazeExplorationImpl(maze);
        validateCoordenates(exploration,x,y);
        logger.info("\n\n-------------SECTION 1.2-------------\nAfter a maze has been created I should be able to put in a co ordinate and know what exists at that point");
        logger.info("Coordenate provided: (X="+x + ",Y="+y+")");


        if(exploration.isValidLocation(x,y)){
            Coordinate coor = new Coordinate(x,y);
            MazeStructure ms = maze.whatIsAt(coor);
            logger.info("Information founded: "+ ms + " = " + ms.getValue());
        }else{
            logger.error("Coordenate is wrong");
        }

    }

    @Override
    public void userStoryOne(File file, int x, int y) throws FileNotFoundException {
        //Maze maze = new MazeImpl(file);

        userStoryOneOne(file);
        userStoryOneTwo(file,x,y);

    }

    @Override
    public void userStoryTwo(File file) throws FileNotFoundException {
        Maze maze = new MazeImpl(file);
        exploration = new MazeExplorationImpl(maze);
        RobotExplorer robot = new RobotExplorerImpl(maze,exploration);

        coordinatesSolution = robot.lookForExit();

        logger.info("\n--------------------MAZE-------------------------\n\n"+((MazeImpl) maze).getMazeStr());
        logger.info("\n\n-------------SECTION 2.1-------------\nGiven a maze the explorer should be able to drop in to the Start point");
        //Coordinate start = ;
        logger.info("Coordinate of Start Point: (X="+ (1+maze.getStart().getXposition()) + ",Y="+(1+maze.getStart().getYposition())+")");
        logger.info("Coordinate of Exit Point: (X="+ (1+maze.getExit().getXposition()) + ",Y="+(1+maze.getExit().getYposition())+")");
        exploration.reset();

    }

    public void userStoryTwoPrinthPath(File file) throws FileNotFoundException{
        if(exploration==null){
            userStoryTwo(file);
        }

        exploration.printPath(coordinatesSolution);
        exploration.reset();
    }

    private void validateCoordenates(MazeExploration mazeExploration , int x, int y){
        Preconditions.checkArgument(mazeExploration.isValidLocation(y,x), "Coordenate provided is out of range!" );
    }
}
