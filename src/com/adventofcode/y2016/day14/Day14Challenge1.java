package com.adventofcode.y2016.day14;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2016.AbstractChallenge;

public class Day14Challenge1 extends AbstractChallenge {

	private int index;
	Map<Integer, String> hashes;

	@Override
	public String execute(String inputFile) {
		List<String> pad = new ArrayList<String>();
		this.hashes = new HashMap<Integer, String>();
		setIndex(0);

		FileParser parser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : parser.getFileLines() ) {
			while( pad.size() < 64 ) {
				pad.add(generateKey(line));
			}
		}
		return Integer.toString(getIndex() - 1);
	}

	private void setIndex(int index) {
		this.index = index;
	}

	private String generateKey(String salt) {
		String needle = ".";
		String hash = "";
		while( needle.equals(".") || !has5In1000(salt, needle) ) {
			if( this.hashes.containsKey(getIndex()) ) {
				hash = this.hashes.get(getIndex());
			}
			else {
				String input = salt + Integer.toString(getIndex());
				hash = getHash(input);
				hash = stretch(hash, getTimes());
				this.hashes.putIfAbsent(getIndex(), hash);
			}
			needle = get3Char(hash);
			setIndex(getIndex() + 1);
		}
		return hash;
	}

	private boolean has5In1000(String salt, String needle) {
		int index = getIndex();
		for( int i = index; i < index + 1000; i++ ) {
			String hash = "";
			if( this.hashes.containsKey(i) ) {
				hash = this.hashes.get(i);
			}
			else {
				hash = getHash(salt + Integer.toString(i));
				hash = stretch(hash, getTimes());
				this.hashes.putIfAbsent(i, hash);
			}
			if( hash.contains(needle + needle + needle + needle + needle) ) {
				return true;
			}
		}
		return false;
	}

	int getIndex() {
		return this.index;
	}

	private String getHash(String string) {
		try {
			return DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8")))
					.toLowerCase();
		}
		catch( NoSuchAlgorithmException e ) {
			return e.getMessage();
		}
		catch( UnsupportedEncodingException e ) {
			return e.getMessage();
		}
	}

	private String stretch(String hash, int times) {
		for( int i = 0; i < times; i++ ) {
			hash = getHash(hash);
		}
		return hash;
	}

	private String get3Char(String haystack) {
		Pattern pattern = Pattern.compile("([0-9a-f])\\1\\1");
		Matcher matcher = pattern.matcher(haystack);
		return matcher.find() ? matcher.group().substring(0, 1) : ".";
	}

	protected int getTimes() {
		return 0;
	}

}
