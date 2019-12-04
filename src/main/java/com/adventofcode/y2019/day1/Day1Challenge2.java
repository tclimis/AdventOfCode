package com.adventofcode.y2019.day1;

public class Day1Challenge2 extends Day1Challenge1 {

    protected Integer getModuleFuelRequirement(final Integer moduleMass) {
        final Integer fuelMass = moduleMass / 3 - 2;
        return fuelMass < 0 ? 0 : fuelMass + getModuleFuelRequirement(fuelMass);
    }
    
}
