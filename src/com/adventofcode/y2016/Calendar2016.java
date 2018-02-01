package com.adventofcode.y2016;

import com.adventofcode.ChallengeFactory;
import com.adventofcode.DayFactory;
import com.adventofcode.NullChallengeFactory;
import com.adventofcode.y2016.day1.Day1ChallengeFactory;
import com.adventofcode.y2016.day10.Day10ChallengeFactory;
import com.adventofcode.y2016.day11.Day11ChallengeFactory;
import com.adventofcode.y2016.day12.Day12ChallengeFactory;
import com.adventofcode.y2016.day13.Day13ChallengeFactory;
import com.adventofcode.y2016.day14.Day14ChallengeFactory;
import com.adventofcode.y2016.day15.Day15ChallengeFactory;
import com.adventofcode.y2016.day16.Day16ChallengeFactory;
import com.adventofcode.y2016.day17.Day17ChallengeFactory;
import com.adventofcode.y2016.day18.Day18ChallengeFactory;
import com.adventofcode.y2016.day19.Day19ChallengeFactory;
import com.adventofcode.y2016.day2.Day2ChallengeFactory;
import com.adventofcode.y2016.day20.Day20ChallengeFactory;
import com.adventofcode.y2016.day21.Day21ChallengeFactory;
import com.adventofcode.y2016.day22.Day22ChallengeFactory;
import com.adventofcode.y2016.day23.Day23ChallengeFactory;
import com.adventofcode.y2016.day24.Day24ChallengeFactory;
import com.adventofcode.y2016.day25.Day25ChallengeFactory;
import com.adventofcode.y2016.day3.Day3ChallengeFactory;
import com.adventofcode.y2016.day4.Day4ChallengeFactory;
import com.adventofcode.y2016.day5.Day5ChallengeFactory;
import com.adventofcode.y2016.day6.Day6ChallengeFactory;
import com.adventofcode.y2016.day7.Day7ChallengeFactory;
import com.adventofcode.y2016.day8.Day8ChallengeFactory;
import com.adventofcode.y2016.day9.Day9ChallengeFactory;

public class Calendar2016 implements DayFactory {

	@Override
	public ChallengeFactory createChallengeFactory(int day) {
		switch( day ) {
			case 1:
				return new Day1ChallengeFactory();
			case 2:
				return new Day2ChallengeFactory();
			case 3:
				return new Day3ChallengeFactory();
			case 4:
				return new Day4ChallengeFactory();
			case 5:
				return new Day5ChallengeFactory();
			case 6:
				return new Day6ChallengeFactory();
			case 7:
				return new Day7ChallengeFactory();
			case 8:
				return new Day8ChallengeFactory();
			case 9:
				return new Day9ChallengeFactory();
			case 10:
				return new Day10ChallengeFactory();
			case 11:
				return new Day11ChallengeFactory();
			case 12:
				return new Day12ChallengeFactory();
			case 13:
				return new Day13ChallengeFactory();
			case 14:
				return new Day14ChallengeFactory();
			case 15:
				return new Day15ChallengeFactory();
			case 16:
				return new Day16ChallengeFactory();
			case 17:
				return new Day17ChallengeFactory();
			case 18:
				return new Day18ChallengeFactory();
			case 19:
				return new Day19ChallengeFactory();
			case 20:
				return new Day20ChallengeFactory();
			case 21:
				return new Day21ChallengeFactory();
			case 22:
				return new Day22ChallengeFactory();
			case 23:
				return new Day23ChallengeFactory();
			case 24:
				return new Day24ChallengeFactory();
			case 25:
				return new Day25ChallengeFactory();
			default:
				return new NullChallengeFactory();
		}
	}
}
