package com.adventofcode.y2016.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {

	private Integer label;

	private Double distanceToRoot;

	private static final short E_GEN = 28;
	private static final short E_CHIP = 26;
	private static final short D_GEN = 24;
	private static final short D_CHIP = 22;
	private static final short C_GEN = 20;
	private static final short C_CHIP = 18;
	private static final short P_GEN = 16;
	private static final short P_CHIP = 14;
	private static final short R_GEN = 12;
	private static final short R_CHIP = 10;
	private static final short S_GEN = 8;
	private static final short S_CHIP = 6;
	private static final short T_GEN = 4;
	private static final short T_CHIP = 2;
	private static final short ELEVATOR = 0;
	private static final short[] ITEM_LIST = { E_GEN, E_CHIP, D_GEN, D_CHIP, C_GEN, C_CHIP, P_GEN, P_CHIP, R_GEN,
			R_CHIP, S_GEN, S_CHIP, T_GEN, T_CHIP };

	private static final short MAX_FLOOR = 3;
	private static final short MIN_FLOOR = 0;

	public Node(Integer label) {
		this.label = label;
		this.label = getCanonicalLabel(label);
		this.distanceToRoot = Double.POSITIVE_INFINITY;
	}

	private int getItemFloor(short item) {
		return (getLabel() & (3 << item)) >> item;
	}

	public Integer getLabel() {
		return this.label;
	}

	private Integer getCanonicalLabel(Integer label) {
		int[] array = splitIntoArray(label);
		Arrays.sort(array);
		return reassembleLabel(array);
	}

	private int[] splitIntoArray(Integer label) {
		List<Integer> list = new ArrayList<Integer>();
		for( int i = T_CHIP; i <= E_GEN; i += 4 ) {
			list.add((label & (15 << i)) >> i);
		}
		int[] array = new int[list.size()];
		for( int i = 0; i < list.size(); i++ ) {
			array[i] = list.get(i).intValue();
		}
		return array;
	}

	private Integer reassembleLabel(int[] array) {
		Integer label = getItemFloor(ELEVATOR);
		for( int i = array.length - 1; i >= 0; i-- ) {
			label += (array[i] << ((array.length - 1 - i) * 4 + 2));
		}
		return label;
	}

	public List<Integer> getAdjacencyList() {
		List<Integer> adjacencyList = new ArrayList<Integer>();
		for( Integer possibleNode : listAdjacentCombinations() ) {
			Node node = new Node(possibleNode);
			if( node.isValid() ) {
				adjacencyList.add(node.getLabel());
			}
		}
		return adjacencyList;
	}

	private List<Integer> listAdjacentCombinations() {
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(findMoveUp());
		list.addAll(findMoveDown());
		return list;
	}

	// the case where item1 == item2 is the case of moving only 1 item
	private List<Integer> findMoveUp() {
		List<Integer> list = new ArrayList<Integer>();
		for( short item1 : ITEM_LIST ) {
			for( short item2 : ITEM_LIST ) {
				if( canMove(item1, item2, 1) ) {
					Integer node = moveTwo(item1, item2, 1);
					if( !list.contains(node) ) {
						list.add(node);
					}
				}
			}
		}
		return list;
	}

	private boolean canMove(short item1, short item2, int offset) {
		// can only move to a floor that exists
		// and can only move if on the same floor as elevator
		return MIN_FLOOR <= getItemFloor(ELEVATOR) + offset && getItemFloor(ELEVATOR) + offset <= MAX_FLOOR
				&& getItemFloor(item1) == getItemFloor(ELEVATOR) && getItemFloor(item2) == getItemFloor(ELEVATOR);
	}

	private Integer moveTwo(short item1, short item2, int offset) {
		int label = moveOne(ELEVATOR, offset, getLabel());
		label = moveOne(item1, offset, label);
		if( item1 != item2 ) {
			label = moveOne(item2, offset, label);
		}
		return label;
	}

	private Integer moveOne(short item, int offset, Integer label) {
		return label + offset * (1 << item);
	}

	private List<Integer> findMoveDown() {
		List<Integer> list = new ArrayList<Integer>();
		for( short item1 : ITEM_LIST ) {
			for( short item2 : ITEM_LIST ) {
				if( canMove(item1, item2, -1) ) {
					Integer node = moveTwo(item1, item2, -1);
					if( !list.contains(node) ) {
						list.add(node);
					}
				}
			}
		}
		return list;
	}

	public double getDistance() {
		return this.distanceToRoot;
	}

	public void setDistance(double distance) {
		if( Double.isInfinite(this.distanceToRoot) ) {
			this.distanceToRoot = distance;
		}
	}

	// elevator is not on an empty floor
	// chip is not on floor with other generator
	public boolean isValid() {

		if( isEmptyFloor(getItemFloor(ELEVATOR)) ) {
			return false;
		}

		short[] chips = { E_CHIP, D_CHIP, C_CHIP, P_CHIP, R_CHIP, S_CHIP, T_CHIP };
		for( short chip : chips ) {
			if( !hasMatchingGenerator(chip) ) {
				if( hasGenerator(getItemFloor(chip)) ) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isEmptyFloor(int floor) {
		for( short item : ITEM_LIST ) {
			if( getItemFloor(item) == floor ) {
				return false;
			}
		}
		return true;
	}

	private boolean hasMatchingGenerator(short chip) {
		return getItemFloor(chip) == getItemFloor((short) (chip + 2));
	}

	private boolean hasGenerator(int floor) {
		short[] generators = { E_GEN, D_GEN, C_GEN, P_GEN, R_GEN, S_GEN, T_GEN, };

		for( short item : generators ) {
			if( getItemFloor(item) == floor ) {
				return true;
			}
		}
		return false;
	}
}
