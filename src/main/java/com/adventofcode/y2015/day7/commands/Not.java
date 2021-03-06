package com.adventofcode.y2015.day7.commands;

import com.adventofcode.y2015.day7.Computer;

public class Not extends UnaryOperator {
	
	public Not(String param, String var) {
		super(param, var);
	}

	
	public void execute() {
		if( getValue() != null ) {
			Integer computedValue = Computer.getInstance().not(getValue());
			Computer.getInstance().put(getDestinationVariable(), computedValue);
		}
	}

}
