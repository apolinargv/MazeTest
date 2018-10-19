package com.agv.bo;

import com.agv.vo.Coordinate;
import com.agv.vo.Maze;

import java.util.List;
import java.util.Optional;

public interface RobotExplorer {

    public List<Coordinate> lookForExit();
    public void setMaze(Maze maze);


}
