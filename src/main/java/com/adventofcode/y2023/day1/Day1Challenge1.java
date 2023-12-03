package com.adventofcode.y2023.day1;

import com.adventofcode.AbstractChallenge;

public class Day1Challenge1 extends AbstractChallenge {

    int runningTotal;

    @Override
    public void initialize() {
        runningTotal = 0;
    }

    @Override
    public void processLine(String input) {
        String numbers = input.replaceAll("\\D", "");
        if( numbers.length() > 0 ) {
            char first = numbers.charAt(0);
            char last = numbers.charAt(numbers.length() - 1);

            int lineID = Character.getNumericValue(first) * 10 + Character.getNumericValue(last);
            runningTotal += lineID;
        }
    }

    @Override
    public String getOutput() {
        return String.valueOf(runningTotal);
    }

}
