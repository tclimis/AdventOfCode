package com.adventofcode.y2020.day2;

public class Day2Challenge2 extends Day2Challenge1 {

    @Override
    protected PasswordRule getPasswordRule(String input) {
        return new PositionPasswordRule(input.split(":")[0]);
    }
    
}
