package com.adventofcode.y2019.day1;

import java.util.ArrayList;
import java.util.List;

import com.adventofcode.AbstractChallenge;

public class Day1Challenge1 extends AbstractChallenge {

    private List<Integer> moduleMasses;

    @Override
    public void initialize() {
        this.moduleMasses = new ArrayList<Integer>();
    }

    @Override
    public void processLine(String input) {
        getModuleMasses().add(Integer.valueOf(input));
    }

    private List<Integer> getModuleMasses() {
        return this.moduleMasses;
    }

    @Override
    public String getOutput() {
        Integer totalFuelRequirement = 0;
        for( Integer moduleMass : getModuleMasses() ) {
            totalFuelRequirement += getModuleFuelRequirement(moduleMass);
        }
        return totalFuelRequirement.toString();
    }

    private Integer getModuleFuelRequirement(Integer moduleMass) {
        return moduleMass / 3 - 2;
    }
    
}