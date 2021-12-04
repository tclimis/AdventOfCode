package com.adventofcode.y2015.day7;

import java.util.HashMap;
import java.util.Map;

public class Computer {

	private Map<String, Integer> memory;

	private static final Computer instance = new Computer();
	// used to convert int to unsigned short.
	private static final int UNSIGNED_MASK = (int) (Math.pow(2, 16) - 1);

	private Computer() {
		initializeMemory();
	}

	private void initializeMemory() {
		this.memory = new HashMap<>();
	}

	public static Computer getInstance() {
		return instance;
	}
	
	public void put(String variable, Integer value) {
		this.memory.put(variable, value);
	}
	
	public Map<String, Integer> getMemory() {
		return memory;
	}

	public Integer get(String variable) {
		return this.memory.get(variable);
	}

	public Integer and(Integer val1, Integer val2) {
		return val1 & val2 & UNSIGNED_MASK;
	}

	public Integer or(Integer val1, Integer val2) {
		return (val1 | val2) & UNSIGNED_MASK;
	}

	public Integer not(Integer val1) {
		return (~val1) & UNSIGNED_MASK;
	}

	public Integer lshift(Integer val1, int shift) {
		return (val1 << shift) & UNSIGNED_MASK;
	}

	public Integer rshift(Integer val1, int shift) {
		return (val1 >> shift) & UNSIGNED_MASK;
	}

}
