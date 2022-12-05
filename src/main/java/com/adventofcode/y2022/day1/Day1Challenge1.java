package com.adventofcode.y2022.day1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.adventofcode.AbstractChallenge;

public class Day1Challenge1 extends AbstractChallenge {

	List<List<Integer>> elfPacks;

	@Override
	public void initialize() {
		// initialize the packs with a single empty pack.
		elfPacks = new ArrayList<>();
		elfPacks.add(new ArrayList<>());
	}

	@Override
	public void processLine(String input) {
		try {
			// if the line is a number, add the item to the last pack
			elfPacks.get(elfPacks.size() - 1).add(Integer.parseInt(input));
		}
		catch( NumberFormatException e ) {
			// if the line is not a number (empty) then create a new pack
			elfPacks.add(new ArrayList<>());
		}
	}

	@Override
	public String getOutput() {
		int biggestPack = getElfPackMaxElfPack(1);
		return String.valueOf(biggestPack);
	}

	protected Integer getElfPackMaxElfPack(long limit) {
		return elfPacks.stream().map(elfPack -> elfPack.stream().reduce(0, Integer::sum))
				.sorted(Comparator.reverseOrder()).limit(limit).reduce(0, Integer::sum);
	}

}
