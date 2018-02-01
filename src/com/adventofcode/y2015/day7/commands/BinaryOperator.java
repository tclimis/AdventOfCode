package com.adventofcode.y2015.day7.commands;

import com.adventofcode.y2015.day7.Computer;

public abstract class BinaryOperator implements Command {

	private Integer value1;
	private Integer value2;
	private String sourceVariable1;
	private String sourceVariable2;
	private String destinationVariable;

	public BinaryOperator(String param1, String param2, String var) {
		try {
			Integer val1 = new Integer(param1);
			setValue1(val1);
		} catch (NumberFormatException e) {
			setSourceVariable1(param1);
		}

		try {
			Integer val2 = new Integer(param2);
			setValue2(val2);
		} catch (NumberFormatException e) {
			setSourceVariable2(param2);
		}

		setDestinationVariable(var);
	}

	protected void setValue1(Integer value) {
		this.value1 = value;
	}

	protected void setSourceVariable1(String variable) {
		this.sourceVariable1 = variable;
	}

	protected void setValue2(Integer value) {
		this.value2 = value;
	}

	protected void setSourceVariable2(String variable) {
		this.sourceVariable2 = variable;
	}

	protected void setDestinationVariable(String variable) {
		this.destinationVariable = variable;
	}

	protected Integer getValue1() {
		if (this.value1 != null)
			return this.value1;
		return Computer.getInstance().get(sourceVariable1);
	}

	protected Integer getValue2() {
		if (this.value2 != null)
			return this.value2;
		return Computer.getInstance().get(sourceVariable2);
	}

	protected String getDestinationVariable() {
		return this.destinationVariable;
	}
}
