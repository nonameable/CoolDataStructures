package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NQueensv1 {

	public int boardSize;

	public int[] placeQueens(int boardSize) {

		this.boardSize = boardSize;
		// we use just an array in order to save space
		int[] answer = new int[boardSize];
		Arrays.fill(answer, -1);
		solve(answer, 0);

		return answer;
	}

	public boolean solve(int[] answer, int column) {
		boolean correct = false;
		for (int j = 0; j < boardSize && !correct; j++) {
			
			boolean good = good(answer, column, j);
			if (good) {
				answer[column] = j;
				if (column + 1 < boardSize) {
					correct = solve(answer, column + 1);
					if (correct) {
						answer[column] = j;
					}
				}
				else {
					correct = true;
					break;
				}
			} else {
				continue;
			}
			
		}
		return correct;
	}

	public boolean good(int[] answer, int i, int j) {
		return goodRow(answer, i, j) && goodUpDiagonal(answer, i, j)
				&& goodDownDiagonal(answer, i, j);
	}

	private boolean goodDownDiagonal(int[] answer, int i, int j) {
		boolean good = true;
		while ((i - 1 >= 0 && j + 1 >= 0 && i - 1 < boardSize && j - 1 < boardSize)
				&& good) {
			if (answer[i - 1] == j + 1)
				good = false;
			i = i - 1;
			j = j + 1;
		}
		return good;
	}

	private boolean goodUpDiagonal(int[] answer, int i, int j) {
		boolean good = true;
		while ((i - 1 >= 0 && j - 1 >= 0 && i - 1 < boardSize && j - 1 < boardSize)
				&& good) {
			if (answer[i - 1] == j - 1)
				good = false;
			i = i - 1;
			j = j - 1;
		}
		return good;
	}

	private boolean goodRow(int[] answer, int i, int j) {
		for (int c = 0; c < i; c++) {
			if (answer[c] == j)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int boardSize = Integer.parseInt(line); //
		NQueensv1 nQueens = new NQueensv1();
		int[] result = nQueens.placeQueens(boardSize);
		for (int i = 0; i < boardSize; i++) {
			System.out.print(result[i] + ",");
		}

	}

}
