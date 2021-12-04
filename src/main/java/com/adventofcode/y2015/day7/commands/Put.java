package com.adventofcode.y2015.day7.commands;

import com.adventofcode.y2015.day7.Computer;

public class Put extends UnaryOperator {
	
	public Put(String param, String variable) {
		super(param, variable);
	}

	
	public void execute() {
		if( getValue() != null) {
			Computer.getInstance().put(getDestinationVariable(), getValue());
		}
	}

}
