package com.adventofcode.y2015.day6.light_actions;

public class LightsDownAction extends AbstractLightAction {
	
	public void execute(int[][] lightField) {
		for (int i = getNWCorner().x; i <= getSECorner().x; i++) {
			for (int j = getNWCorner().y; j <= getSECorner().y; j++) {
				if(lightField[i][j] > 0)
					lightField[i][j]--;
			}
		}
	}

}
