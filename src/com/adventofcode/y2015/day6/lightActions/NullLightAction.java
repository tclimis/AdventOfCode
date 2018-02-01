package com.adventofcode.y2015.day6.lightActions;


public class NullLightAction extends AbstractLightAction implements LightAction {

	@Override
	public void execute(int[][] lightField) {
		return;
	}

}
