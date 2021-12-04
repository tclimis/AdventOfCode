package com.adventofcode.y2015.day7.commands;

import com.adventofcode.y2015.day7.Computer;

public class Not extends UnaryOperator {
	
	public Not(String param, String variable) {
		super(param, variable);
	}

	
	public void execute() {
		if( getValue() != null ) {
			Integer computedValue = Computer.getInstance().not(getValue());
			Computer.getInstance().put(getDestinationVariable(), computedValue);
		}
	}

}
