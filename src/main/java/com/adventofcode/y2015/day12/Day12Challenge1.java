package com.adventofcode.y2015.day12;

import com.adventofcode.AbstractChallenge;

public class Day12Challenge1 extends AbstractChallenge {
	
	private Integer total;

	public void initialize() {
		setTotal(Integer.valueOf(0));
	}
	
	private void setTotal(final Integer total) {
		this.total = total;
	}
	
	public void processLine(final String input) {
		final String[] jsonArray = input.split("[\\[\\]\\{\\}:,=]");
		for( final String element : jsonArray ) {
			try {
				final Integer intVal = Integer.valueOf(element);
				setTotal(getTotal() + intVal);
			}
			catch( final NumberFormatException e ) {}
		}
	}
	
	public String getOutput() {
		return getTotal().toString();
	}
	
	private Integer getTotal() {
		return this.total;
	}
}
