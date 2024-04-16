package org.example;

import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {

	@Test
	public void testGameOfLifeLogic(){
		GameOfLifeSolution solution = new GameOfLifeSolution();
		int[][] testBoard = {{0, 1, 0},
		                     {0, 1, 0 },
		                     {0, 1, 0 }};
		int [][] expectedResult = {{0, 0, 0},
		                           {1, 1, 1 },
		                           {0, 0, 0 }};

		solution.applyGameOfLife(testBoard);
		Assert.assertArrayEquals( expectedResult, testBoard);
	}
}



