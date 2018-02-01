package com.adventofcode.y2016.day10;

import java.util.List;

public interface Recipient {

	public int getID();

	public List<Integer> getContents();

	public void give(Integer chip);

}
