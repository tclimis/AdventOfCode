package com.adventofcode.y2015.day6.lightActions;


public class ToggleLightsAction extends AbstractLightAction implements
		LightAction {

	
	public void execute(int[][] lightField) {
		for (int i = getNWCorner().x; i <= getSECorner().x; i++) {
			for (int j = getNWCorner().y; j <= getSECorner().y; j++) {
				lightField[i][j] = (lightField[i][j] == 1) ? 0 : 1;
			}
		}
		return;
	}

}