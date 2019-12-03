package com.adventofcode.y2015.day4;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.adventofcode.AbstractChallenge;

public class Day4Challenge1 extends AbstractChallenge {
	
	private int count;

	public void initialize() {
		initializeCount(0);
	}
	
	protected void initializeCount(int count) {
		this.count = count;
	}
	
	public void processLine(String input) {
		while( !md5StartsWith00000(input, count) ) {
			count++;
		}
	}

	private boolean md5StartsWith00000(String line, int number) {
		String value = line + Integer.valueOf(number).toString();
		try {
			byte[] md5Bytes = MessageDigest.getInstance("MD5").digest(value.getBytes(StandardCharsets.UTF_8));
			return (md5Bytes[0] == 0 && md5Bytes[1] == 0 && md5Bytes[2] >= 0 && md5Bytes[2] < 16);

		}
		catch( NoSuchAlgorithmException e ) {
			return false;
		}
	}
	
	public String getOutput() {
		return String.valueOf(count);
	}
}
