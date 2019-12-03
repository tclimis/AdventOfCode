package com.adventofcode.y2016.day16;

import java.math.BigInteger;

import com.adventofcode.AbstractChallenge;

public class Day16Challenge1 extends AbstractChallenge {

	private static final BigInteger INITIAL_STATE = new BigInteger("10111011111001111", 2);
	
	public void initialize() { }
	
	public void processLine(String input) {	}
	
	public String getOutput() {
		return checksum();
	}

	protected int getDiskLength() {
		return 272;
		// 11101010111100010 -- right answer
		// 00000000000000000 -- current answer
	}

	private String checksum() {

		int numOfChunks = getDiskLength() >> Integer.numberOfTrailingZeros(getDiskLength());
		int chunkSize = 1 << Integer.numberOfTrailingZeros(getDiskLength());
		StringBuilder checksum = new StringBuilder();
		for( int i = 0; i < numOfChunks; i++ ) {
			checksum.append(getChecksumBit(chunkSize * i, chunkSize * (i + 1)));
		}
		return checksum.reverse().toString();
	}

	private int getChecksumBit(int start, int end) {
		int chunkSize = 1 << Integer.numberOfTrailingZeros(getDiskLength());
		int lengthA = INITIAL_STATE.bitLength();

		int nextDragonIndex = start + lengthA - start % (lengthA + 1);
		int abSuffix = nextDragonIndex - start;
		int abPrefix = (chunkSize - abSuffix) % ((lengthA + 1) * 2);
		int numOfABPairs = (chunkSize - (abPrefix + abSuffix)) / ((lengthA + 1) * 2);
		boolean numOfABPairsParity = lengthA % 2 == 1 && numOfABPairs % 2 == 1;
		boolean abPrefixParity = getABPrefixParity(abPrefix);

		boolean dragonParity = Integer.bitCount(dragonNumber(chunkSize - (numOfABPairs * lengthA + abPrefix))) % 2 == 1;
		return abPrefixParity ^ numOfABPairsParity ^ abPrefixParity ^ dragonParity ? 0 : 1;
	}

	private boolean getABPrefixParity(int abPrefixLength) {
		BigInteger ab = INITIAL_STATE.shiftLeft(INITIAL_STATE.bitLength()).add(reverse(INITIAL_STATE.not()));
		return ab.shiftRight(ab.bitLength() - abPrefixLength).bitCount() % 2 == 1;
	}

	private BigInteger reverse(BigInteger bigInt) {
		return new BigInteger(new StringBuilder(bigInt.toString(2)).reverse().toString(), 2);
	}

	private int dragonNumber(int index) {
		return 0;
	}
	/*
	 * a 0 b 0 a 0 b 0 a 0 b == chunkSize/2a
	 * 
	 * 
	 * 101 0 010 0 101 0 010 0 101 0 01 | 0
	 * 
	 * 10 | 1 0 | 01 | 0 0 | 10 | 1 0 | 01 | 0 0 | 10 | 1 0 | 01
	 */

}
