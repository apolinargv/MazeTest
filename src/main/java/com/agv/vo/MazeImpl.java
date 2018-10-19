package com.agv.vo;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MazeImpl implements Maze{
    private static final Logger logger = LogManager.getLogger(MazeImpl.class);

    private int numberTotalWalls;
    private int numberTotalSpaces;
    private int xdimension;
    private int ydimension;
    private final String ENDOFLINES = "[\n]?\n";
    private char[][] maze;
    private String[] lines;

    private String mazeStr;
    private Coordinate start;
    private Coordinate end;

    /**
     * Constructor which creates and initialize a Maze Object from File Object
     * @param mazeFile object
     * @throws FileNotFoundException
     */
    public MazeImpl(File mazeFile) throws FileNotFoundException {
        numberTotalSpaces=0;

        numberTotalWalls=0;


        mazeStr = "";

        try (Scanner input = new Scanner(mazeFile)) {
            /**
             * Retrieve all characters into a String Object
             */
            while (input.hasNextLine()) {
                mazeStr += input.nextLine() + "\n";
            }
        }
        /**
         * Initialize object Maze
         */
        initializeMaze(mazeStr);

    }

    /**
     * Get String Object of Maze
     * @return
     */
    public String getMazeStr(){
        return mazeStr;
    }


    /**
     * Maze validated and initialized from String object
     * @param textMaze
     */
    private void initializeMaze(String textMaze) {
        /**
         * Validation with Guava Object of important variables
         */
        Preconditions.checkArgument(!Strings.isNullOrEmpty(textMaze), "Maze can not be empty!");
        Preconditions.checkArgument(countCharsOfStringProv(textMaze, MazeStructure.START.getValue()) == 1, "Maze must have one starting point only!");
        Preconditions.checkArgument(countCharsOfStringProv(textMaze, MazeStructure.EXIT.getValue()) == 1, "Maze must have just one exit point!");

        lines = textMaze.split(ENDOFLINES);
        Preconditions.checkArgument(evaluationLeghtOfRows(lines), "Maze rows must have the same number of blocks!");
        ydimension = lines.length;
        xdimension = lines[0].length();

        start = findLocation(textMaze, MazeStructure.START);
        end = findLocation(textMaze, MazeStructure.EXIT);



        numberTotalWalls = countCharsOfStringProv(textMaze, MazeStructure.WALL.getValue());
        numberTotalSpaces = countCharsOfStringProv(textMaze, MazeStructure.SPACE.getValue());


        int indexOfStart = textMaze.replaceAll(ENDOFLINES, "").indexOf(MazeStructure.START.getValue());
        int indexOfExit = textMaze.replaceAll(ENDOFLINES, "").indexOf(MazeStructure.EXIT.getValue());
        String path = textMaze.replaceAll(ENDOFLINES, "").substring(indexOfStart,indexOfExit);

    }

    /**
     * Function to count c character on the string provided
     * @param str
     * @param c character to find and count
     * @return
     */
    private final int countCharsOfStringProv(String str, char c) {
        return (int)str.chars().filter(ch -> ch == c).count();
    }

    /**
     * Find specific location of a character provided and mazeStructure
     * @param mazeStr
     * @param mazeStructure
     * @return
     */
    private final Coordinate findLocation(String mazeStr, MazeStructure mazeStructure) {

        int indexOfLocation = mazeStr.replaceAll(ENDOFLINES, "").indexOf(mazeStructure.getValue());

        return new Coordinate(indexOfLocation % xdimension, indexOfLocation / xdimension);
    }

    /**
     * Evaluates lenth of every row set in the array String. Also Initializes the Maze object array of chars
     * @param mazeData
     * @return
     */
    private final boolean evaluationLeghtOfRows(String[] mazeData) {
        maze = null;
        maze = new char[mazeData.length][ydimension];

        for(int i = 0; i< mazeData.length; i++){
            if (mazeData[0].length()!=mazeData[i].length()) {
                return false;
            }

            maze[i] = mazeData[i].toCharArray();

        }

        return true;
    }




    /**
     * Finds a MazeStructure Object located at certain coordinate
     * @param coord
     * @return
     */
    public MazeStructure whatIsAt(Coordinate coord) {
        return MazeStructure.from(lines[coord.getYposition()].charAt(coord.getXposition()));
    }

    /**
     *  Total of walls located in all maze
     * @return
     */
    public int getNumberTotalWalls() {
        return numberTotalWalls;
    }

    /**
     * Total of number spaces in maze
     * @return
     */
    public int getNumberTotalSpaces() {
        return numberTotalSpaces;
    }

    /**
     * Get Coordinate of start point
     * @return
     */
    public Coordinate getStart() {
        return start;
    }

    /**
     * Get Coordinate of End point
     * @return
     */
    public Coordinate getExit() {
        return end;
    }

    /**
     * Get dimension X
     * @return
     */
    public int getXdimension() {
        return xdimension;
    }

    /**
     * Get Dimension Y
     * @return
     */
    public int getYdimension() {
        return ydimension;
    }

    /**
     * Get maze char Array
     * @return
     */
    public char[][] getMaze() {
        return maze;
    }


}
