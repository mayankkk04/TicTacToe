import java.util.*;
public class Main
{
	public static void main(String[] args) {
		char[][] board = new char[3][3];
		for(int row = 0 ; row < board.length ; row++) {
			for(int clm = 0 ; clm < board[0].length ; clm++) {
				board[row][clm] = ' ';
			}
		}
		char player = 'X';
		boolean gameOver = false;
		Scanner sc = new Scanner(System.in);
		while(!gameOver) {
			printBoard(board);
			System.out.println("Player "+ player + " enter:");
			int row = sc.nextInt();
			int clm = sc.nextInt();

			if(board[row][clm] == ' ') {
				board[row][clm] = player;
				gameOver = haveWon(board,player);
				if(gameOver) System.out.println("Player "+player+" has won!");
				else player = (player == 'X') ? 'O' : 'X';
			}
			else {
				System.out.println("Place already filled");
			}
		}
		printBoard(board);
	}
	public static void printBoard(char[][] board) {
		for(int row = 0 ; row < board.length ; row++) {
			for(int clm = 0 ; clm < board[0].length ; clm++) {
				System.out.print(" "+board[row][clm]+" | ");
			}
			System.out.println();
		}
	}
	public static boolean haveWon(char[][] board, char player) {
		for(int row = 0 ; row < board.length ; row++) {
			if(board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				return true;
			}
		}
		for(int clm = 0 ; clm < board[0].length ; clm++) {
			if(board[0][clm] == player && board[1][clm] == player && board[2][clm] == player ) {
				return true;
			}
		}
		if(board[0][0] == player &&  board[1][1] == player && board[2][2] == player) {
		    return true;
		}
		if(board[0][2] == player &&  board[1][1] == player && board[2][0] == player) {
		    return true;
		}
		return false;
	}
}
