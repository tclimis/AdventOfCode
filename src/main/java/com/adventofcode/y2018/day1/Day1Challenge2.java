package com.adventofcode.y2018.day1;

import java.util.ArrayList;
import java.util.List;

public class Day1Challenge2 extends Day1Challenge1 {
	
	private List<Integer> visitedNumbers;
	private boolean end;

	@Override
	public void initialize() {
		this.visitedNumbers = new ArrayList<>();
		this.end = false;
	}
	
	@Override
	public void processLine(String input) {
		setSum(getSum() + Integer.valueOf(input));
		if( getVisitedNumbers().contains(getSum()) ) {
			this.end = true;
		}
		getVisitedNumbers().add(sum);
	}
	
	private List<Integer> getVisitedNumbers() {
		return this.visitedNumbers;
	}
	
	@Override
	public String getOutput() {
		return getSum().toString();
	}
	
	@Override
	public boolean runAgain() {
		return !end;
	}

}
