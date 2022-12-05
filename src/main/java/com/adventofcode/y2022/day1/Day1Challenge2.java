package com.adventofcode.y2022.day1;

public class Day1Challenge2 extends Day1Challenge1 {

    @Override
    public String getOutput() {
        int biggestPack = getElfPackMaxElfPack(3);
        return String.valueOf(biggestPack);
    }

}
