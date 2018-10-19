package com.agv.dto;

import com.agv.bo.MazeExploration;
import com.agv.vo.Coordinate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface MazeSolver {

    public void userStoryOneOne(File file) throws  FileNotFoundException;
    public void userStoryOneTwo(File file, int x, int y) throws  FileNotFoundException;
    public void userStoryOne(File file, int x, int y) throws FileNotFoundException ;

    public void userStoryTwo(File file) throws FileNotFoundException;
    public void userStoryTwoPrinthPath(File file) throws FileNotFoundException;

}
