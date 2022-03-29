package application;

import java.util.Scanner;

public class Main {
	
	public static final int BOARD_SIZE = 3;
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("\nWelcome to the game Tic Tac Toe! \n");
		char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

		boolean player1 = true;
		boolean player2 = false;

		drawLabel(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = ' ';
			}
		}

		while (true) {

			int row = 0;
			int col = 0;
			char xo = ' ';
			if (player1) {
				xo = 'X';
			} else if (player2) {
				xo = 'O';
			}

			if (player1) {
				System.out.println("Player one choose a row and a column!");
			} else if (player2) {
				System.out.println("Player two choose a row and a column!");
			}

			while (true) {

				System.out.print("Please type in your row 1,2,3: ");
				row = scan.nextInt() - 1;
				System.out.print("Please type in your col 1,2,3: ");
				col = scan.nextInt() - 1;

				if (board[row][col] != ' ') {
					System.out.println("This place is not free, try again");
				} else if (row < 0 || row > 2 || col < 0 || col > 2) {
					System.out.println("Out of bounds, please try again");
				} else {
					break;
				}

			}

			board[row][col] = xo;
			drawLabel(board);

			if (checkWin(board) == 'X') {
				System.out.println("Player one wins");
				break;
			} else if (checkWin(board) == 'O') {
				System.out.println("Player two wins");
				break;
			} else if (checkFull(board)) {
				System.out.println("Nobody wins");
				break;
			} else {

			}

			if (player1) {
				player1 = false;
				player2 = true;
			} else if (player2) {
				player2 = false;
				player1 = true;
			}

		}

	}

	public static void drawLabel(char[][] board) {
		System.out.println("---------");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print("|" + board[i][j] + "|");
			}
			System.out.println();

		}
		System.out.println("---------");
		System.out.println("\n");
	}

	public static char checkWin(char[][] board) {

		for (int i = 0; i < board.length; i++) { // check row
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
				return board[i][0];
			}
		}

		for (int j = 0; j < board.length; j++) { // check column
			if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
				return board[0][j];
			}
		}

		for (int i = 0; i < board.length; i++) { // check diagonal
			for (int j = 0; j < board.length; j++) {
				if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
					return board[0][0];
				}
			}

		}

		for (int i = 0; i < board.length; i++) { // check diagonal reverse
			for (int j = 0; j < board.length; j++) {
				if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
					return board[0][2];
				}
			}
		}

		return ' ';
	}

	public static boolean checkFull(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}

			}
		}
		return true;
	}

}
