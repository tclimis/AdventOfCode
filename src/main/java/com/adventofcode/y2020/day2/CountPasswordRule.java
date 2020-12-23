package com.adventofcode.y2020.day2;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;

public class CountPasswordRule implements PasswordRule {

    private Character pattern;
    private Range<Integer> range;

	public CountPasswordRule(String rule) {
        this.pattern = getPattern(rule);
        this.range = Range.between(getMin(rule), getMax(rule));
    }

    private Character getPattern(String rule) {
        return Parser.getCharacter(rule);
    }

    private Integer getMin(String rule) {
        return Parser.getFirstNumber(rule);
    }

    private Integer getMax(String rule) {
        return Parser.getSecondNumber(rule);
    }

    public boolean matches(String password) {
        return range.contains(StringUtils.countMatches(password, getPattern()));
    }

    private Character getPattern() {
        return pattern;
    }

}
