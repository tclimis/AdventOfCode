package com.adventofcode.y2016.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Robot implements Recipient {

	private int id;
	private List<Integer> contents;

	private Recipient recipLow;
	private Recipient recipHigh;

	public Robot(int id, Integer chip) {
		this(id);
		give(chip);
	}

	public Robot(int id) {
		this(id, null, null);
	}

	public Robot(int id, Recipient recipLow, Recipient recipHigh) {
		setID(id);
		setRecipientLow(recipLow);
		setRecipientHigh(recipHigh);
		this.contents = new ArrayList<>();
	}

	private void setID(int id) {
		this.id = id;
	}

	public void setRecipientLow(Recipient recipient) {
		this.recipLow = recipient;
	}

	public void setRecipientHigh(Recipient recipient) {
		this.recipHigh = recipient;
	}

	
	public void give(Integer chip) {
		if( !areHandsFull() ) {
			getContents().add(chip);
			Collections.sort(getContents());
		}
	}

	public boolean areHandsFull() {
		return getContents().size() >= 2;
	}

	public List<Integer> getContents() {
		return this.contents;
	}

	public void giveHandContents() {
		if( getRecipientLow() instanceof Recipient && getRecipientHigh() instanceof Recipient ) {
			getRecipientLow().give(getLowHand());
			getRecipientHigh().give(getHighHand());
			getContents().clear();
		}
	}

	private Recipient getRecipientLow() {
		return this.recipLow;
	}

	private Recipient getRecipientHigh() {
		return this.recipHigh;
	}

	private Integer getLowHand() {
		return getContents().get(0);
	}

	private Integer getHighHand() {
		return getContents().get(getContents().size() - 1);
	}

	
	public int getID() {
		return this.id;
	}
}
