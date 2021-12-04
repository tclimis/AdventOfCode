package com.adventofcode.y2015.day7.commands;

import com.adventofcode.y2015.day7.Computer;

public abstract class UnaryOperator implements Command {

	private Integer value;
	private String sourceVariable;
	private String destinationVariable;
	
	protected UnaryOperator(String param, String variable) {
		try {
			Integer val = Integer.valueOf(param);
			setValue(val);
		}
		catch( NumberFormatException e ) {
			setSourceVariable(param);
		}
		setDestinationVariable(variable);
	}
	
	protected void setValue(Integer value) {
		this.value = value;
	}
	
	protected void setSourceVariable(String variableName) {
		this.sourceVariable = variableName;
	}
	
	protected void setDestinationVariable(String variableName) {
		this.destinationVariable = variableName;
	}
	
	protected Integer getValue() {
		if( this.value != null ) {
			return value;
		}
		return Computer.getInstance().get(sourceVariable);
	}
	
	protected String getDestinationVariable() {
		return destinationVariable;
	}

}
