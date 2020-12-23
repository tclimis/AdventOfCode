package com.adventofcode.y2020.day2;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;

public class PasswordRule {

    private Character pattern;
    private Range<Integer> range;

	public PasswordRule(String rule) {
        this.pattern = getPattern(rule);
        this.range = Range.between(getMin(rule), getMax(rule));
    }

    private Character getPattern(String rule) {
        String[] pieces = rule.split(" ");
        if( pieces.length == 2 && pieces[1].trim().length() == 1 ) {
            return pieces[1].charAt(0);
        }

        return '\0';
    }

    private Integer getMin(String rule) {
        String minString = rule.split(" ")[0].split("-")[0];
        return Integer.valueOf(minString);
    }

    private Integer getMax(String rule) {
        String[] pieces = rule.split(" ")[0].split("-");
        if( pieces.length == 2 ) {
            return Integer.valueOf(pieces[1]);
        }

        return 0;
    }

    public boolean matches(String password) {
        return range.contains(StringUtils.countMatches(password, getPattern()));
    }

    private Character getPattern() {
        return pattern;
    }

}
