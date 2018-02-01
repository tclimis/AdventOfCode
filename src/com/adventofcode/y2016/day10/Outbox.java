package com.adventofcode.y2016.day10;

import java.util.ArrayList;
import java.util.List;

public class Outbox implements Recipient {

	private int id;
	private List<Integer> contents;

	public Outbox(int id) {
		setID(id);
		this.contents = new ArrayList<Integer>();
	}

	private void setID(int id) {
		this.id = id;
	}

	@Override
	public void give(Integer chip) {
		getContents().add(chip);
	}

	@Override
	public List<Integer> getContents() {
		return this.contents;
	}

	@Override
	public int getID() {
		return this.id;
	}
}
