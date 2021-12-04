package com.adventofcode.y2015.day7.commands;

import com.adventofcode.y2015.day7.Computer;

public class LShift extends BinaryOperator {

	public LShift(String param1, String param2, String variable) {
		super(param1, param2, variable);
		try {
			Integer.valueOf(param2);
			// don't need to set value - it was set correctly in super
		} catch (NumberFormatException e) {
			setValue2(Integer.valueOf(0));
		}
	}

	
	public void execute() {
		if (getValue1() != null) {
			Integer computedValue = Computer.getInstance().lshift(getValue1(),
					getValue2().intValue());
			Computer.getInstance().put(getDestinationVariable(), computedValue);
		}
	}

}
