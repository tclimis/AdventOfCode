package com.adventofcode.y2020.day1;

import java.util.Collections;

public class Day1Challenge2 extends Day1Challenge1 {
    
    @Override
    public String getOutput() {
        Collections.sort(getExpenses());
        for( Integer expense1 : getExpenses() ) {
            if( expense1 < TOTAL ) {
                for( Integer expense2 : getExpenses() ) {
                    if( expense1 + expense2 < TOTAL 
                        && getExpenses().contains(TOTAL - expense1 - expense2) 
                    ) {
                        return String.valueOf(expense1 * expense2 * (TOTAL - expense1 - expense2));
                    }
                }
            }
        }
        return "0";
    }

}
