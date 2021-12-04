package com.adventofcode.y2021.day1;

import java.util.ArrayList;
import java.util.List;

import com.adventofcode.AbstractChallenge;

public class Day1Challenge1 extends AbstractChallenge {

    private List<Integer> depths;

    @Override
    public String getOutput() {
        Integer previous = Integer.MAX_VALUE;
        int count = 0;
        for(Integer depth : depths) {
            if(depth > previous) {
                count++;
            }
            previous = depth;
        }
        return String.valueOf(count);
    }

    @Override
    public void initialize() {
        depths = new ArrayList<>();     
    }

    @Override
    public void processLine(String input) {
        depths.add(Integer.parseInt(input));
    }
    


}
