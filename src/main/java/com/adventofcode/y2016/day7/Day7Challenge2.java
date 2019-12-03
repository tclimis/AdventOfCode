package com.adventofcode.y2016.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day7Challenge2 extends Day7Challenge1 {
	
	public void processLine(String input) {
		if( supportsSSL(input) ) {
			count++;
		}
	}

	private boolean supportsSSL(String ipAddress) {
		List<String> babs = new ArrayList<String>();
		String[] ipSegments = ipAddress.split("[\\[\\]]");
		for( String hyperNet : getHyperNets(ipAddress) ) {
			babs.addAll(findBABs(hyperNet));
		}
		for( String bab : babs ) {
			for( int i = 0; i < ipSegments.length; i += 2 ) {
				if( containsABA(ipSegments[i], bab) ) {
					return true;
				}
			}
		}
		return false;
	}

	private List<String> findBABs(String str) {
		List<String> babs = new ArrayList<String>();
		Pattern pattern = Pattern.compile("([a-z])(?!\\1)[a-z]\\1");
		Matcher matcher = pattern.matcher(str);
		int i = 0;
		while( matcher.find(i) ) {
			i = matcher.start() + 1;
			babs.add(matcher.group());
		}
		return babs;
	}

	private boolean containsABA(String supernet, String bab) {
		String aba = bab.substring(1) + bab.substring(1, 2);
		return supernet.contains(aba);
	}

}
