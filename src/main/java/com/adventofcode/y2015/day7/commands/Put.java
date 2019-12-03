package com.adventofcode.y2015.day7.commands;

import com.adventofcode.y2015.day7.Computer;

public class Put extends UnaryOperator {
	
	public Put(String param, String var) {
		super(param, var);
	}

	
	public void execute() {
		if( getValue() != null) {
			Computer.getInstance().put(getDestinationVariable(), getValue());
		}
	}

}
