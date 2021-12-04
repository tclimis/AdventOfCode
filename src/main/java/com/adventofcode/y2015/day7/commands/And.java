package com.adventofcode.y2015.day7.commands;

import com.adventofcode.y2015.day7.Computer;

public class And extends BinaryOperator {

	public And(String param1, String param2, String variable) {
		super(param1, param2, variable);
	}

	
	public void execute() {
		if (getValue1() != null && getValue2() != null) {
			Integer computedValue = Computer.getInstance().and(getValue1(),
					getValue2());
			Computer.getInstance().put(getDestinationVariable(), computedValue);
		}
	}

}
