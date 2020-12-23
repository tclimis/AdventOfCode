package com.adventofcode.y2020.day2;

import com.adventofcode.AbstractChallenge;

public class Day2Challenge1 extends AbstractChallenge {

    private Integer passwordCount;

    @Override
    public void initialize() {
        setPasswordCount(0);
    }

    private void setPasswordCount(Integer passwordCount) {
        this.passwordCount = passwordCount;
    }

    @Override
    public void processLine(String input) {
        if( getPasswordRule(input).matches(getPassword(input)) ) {
            incrementPasswordCount();
        }
    }

    private String getPassword(String input) {
        String[] pieces = input.split(":");
        if( pieces.length == 2 ) {
            return pieces[1].trim();
        }

        return "";
    }

    protected PasswordRule getPasswordRule(String input) {
        return new CountPasswordRule(input.split(":")[0]);
    }

    private void incrementPasswordCount() {
        this.passwordCount++;
    }

    @Override
    public String getOutput() {
        return String.valueOf(passwordCount);
    }
    
}
