package org.example;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GameOfLifeSolution {

	public void printBoard(int[][] board) {
		throw new NotImplementedException();
	}


	public int countLivingNeighbours(int[][] board, int rowIndex, int columnIndex) {
		int maxRow = board.length;
		int maxColumn = board[0].length;
		int liveCellCounter = 0;

		int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1},
		                      {0, -1},/*The current cell*/{0, 1},
		                      {1, -1}, {1, 0}, {1, 1}};

		for (int[] direction : directions) {
			int newRowIndex = rowIndex + direction[0];
			int newColumnIndex = columnIndex +  direction[1];

			if (newRowIndex >= 0 && newRowIndex < maxRow && newColumnIndex >= 0
				&& newColumnIndex < maxColumn &&
				  (board[newRowIndex][newColumnIndex] == 1 || board[newRowIndex][newColumnIndex] == -1)) {
				   liveCellCounter++;
			}
		}

		return liveCellCounter;
	}

	public void applyGameOfLife(int[][] board) {
		int maxRow = board.length;
		int maxColumn = board[0].length;
		for (int row = 0; row < maxRow; row++) {
			for (int column = 0; column < maxColumn; column++) {
				int liveNeighbours = countLivingNeighbours(board, row, column);

				if (liveNeighbours < 2 || liveNeighbours > 3 && board[row][column] == 1) {
					board[row][column] = -1; // marking it as a cell than needs to die
				}

				if (liveNeighbours == 3 && board[row][column] == 0) {
					board[row][column] = 2; // marking as a cell that needs to have a life
				}
			}
		}

		for (int row = 0; row < maxRow; row++) {
			for (int column = 0; column < maxColumn; column++) {
					if (board[row][column] == -1){
						board[row][column] = 0;
					}
					if (board[row][column] == 2){
						board[row][column] = 1;
					}
			}
		}

	}

}
