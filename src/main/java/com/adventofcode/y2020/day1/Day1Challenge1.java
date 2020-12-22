package com.adventofcode.y2020.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.adventofcode.AbstractChallenge;

public class Day1Challenge1 extends AbstractChallenge {

    private List<Integer> expenses;
    private static final Integer TOTAL = 2020;

    @Override
    public void initialize() {
        expenses = new ArrayList<>();
    }

    @Override
    public void processLine(String input) {
        getExpenses().add(Integer.parseInt(input));
    }

    private List<Integer> getExpenses() {
        return expenses;
    }

    @Override
    public String getOutput() {
        Collections.sort(getExpenses());
        for( Integer expense : getExpenses() ) {
            if( getExpenses().contains(TOTAL - expense) ) {
                return String.valueOf(expense * (TOTAL - expense));
            }
        }
        return "0";
    }
    
}
