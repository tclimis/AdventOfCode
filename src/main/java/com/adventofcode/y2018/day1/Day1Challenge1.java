package com.adventofcode.y2018.day1;

import com.adventofcode.AbstractChallenge;

public class Day1Challenge1 extends AbstractChallenge {
	
	protected Integer sum;
	
	public void initialize() {
		setSum(Integer.valueOf(0));
	}
	
	protected void setSum(Integer sum) {
		this.sum = sum;
	}

	public void processLine(String input) {
		setSum(getSum() + Integer.valueOf(input));
	}
	
	protected Integer getSum() {
		return this.sum;
	}
	
	public String getOutput() {
		return getSum().toString();
	}

}
