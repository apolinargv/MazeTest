package com.agv.vo;

import java.util.Arrays;
import java.util.Optional;

public enum MazeStructure {
    SPACE(' ',0),
    WALL('X',1),
    START('S',2),
    EXIT('F',3),
    ROAD('.',4);

    private char value;
    private int valueInt;

    MazeStructure(char val, int valueInte){

        this.value = val;
        this.valueInt = valueInte;
    }



    public static char getValue(int val){
        char value = '#';
        for(MazeStructure ins : MazeStructure.values()){
            if(ins.valueInt==val){
                value = ins.getValue();
                break;
            }
        }
        return value;
    }

    public char getValue(){
        return value;
    }

    public int getValueNum(){
        return valueInt;
    }

    public static MazeStructure from(char ch) {
        Optional<MazeStructure> structureFromChar = Arrays.stream(MazeStructure.values()).filter(ms -> ms.value == ch).findFirst();
        return structureFromChar.orElseThrow(() -> new IllegalArgumentException(String.format("Maze not recognised from '%s'!", ch)));
    }

}
