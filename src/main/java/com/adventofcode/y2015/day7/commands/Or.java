package com.adventofcode.y2015.day7.commands;

import com.adventofcode.y2015.day7.Computer;

public class Or extends BinaryOperator {
	
	public Or(String param1, String param2, String var) {
		super(param1, param2, var);
	}

	
	public void execute() {
		if( getValue1() != null && getValue2() != null ) {
			Integer computerValue = Computer.getInstance().or(getValue1(), getValue2());
			Computer.getInstance().put(getDestinationVariable(), computerValue);
		}
	}

}
