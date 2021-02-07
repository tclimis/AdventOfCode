package com.adventofcode.y2020.day2;

public class PositionPasswordRule implements PasswordRule {

    private Character pattern;
    private Integer position1;
    private Integer position2;

	public PositionPasswordRule(String rule) {
        setPattern(rule);
        setPosition1(rule);
        setPosition2(rule);
    }

    private void setPattern(String rule) {
        pattern = Parser.getCharacter(rule);
    }

    private void setPosition1(String rule) {
        position1 =  Parser.getFirstNumber(rule) - 1;
    }

    private void setPosition2(String rule) {
        position2 = Parser.getSecondNumber(rule) - 1;
    }

    @Override
    public boolean matches(String password) {
        return password.charAt(position1) == pattern
            ^ password.charAt(position2) == pattern;
    }

}
