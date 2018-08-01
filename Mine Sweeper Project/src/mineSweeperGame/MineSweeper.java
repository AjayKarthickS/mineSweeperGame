package mineSweeperGame;

import java.util.Scanner;

public class MineSweeper {
	public static void main(String[] args) {
		System.out.println("******************");
		System.out.println("Mine Sweeper Game");
		System.out.println("******************");
		playMineSweeper();
	}
	private static void playMineSweeper(){
		Scanner in = new Scanner(System.in);
		System.out.println("Choose the Difficulty Level");
		System.out.println("1. Easy (4 * 4 matrix with 5 mines) (Enter 1");
		System.out.println("2. Medium (8 * 8 matrix with 12 mines) (Enter 2)");
		System.out.println("3. Hard  (12 * 12 matrix with 24 mines) (Enter 3)");
		int ch = in.nextInt();
		SweeperBoard board = new SweeperBoard();
		switch(ch){
		case 1:
			board = new SweeperBoard(4, 4, 5);
			break;
		case 2:
			board = new SweeperBoard(8, 8, 12);
			break;
		case 3:
			board = new SweeperBoard(12, 12, 24);
			break;
		default:
			System.out.println("Enter a valid option");
			break;
		}
		board.initialize();
		board.printBoard();
		boolean gameOver = false;
		while(!gameOver){
			System.out.print("Enter the input(x and y) =====> ");
			int x = in.nextInt();
			int y = in.nextInt();
			int result = board.playMineSweeperUtil(x, y);
			if(result < 0)
				System.out.println("Invalid Input");
			else if(result == 0){
				System.out.println("*#$% Game Over %$#*");
				gameOver = true;
			}
			else
				board.printBoard();
			if(board.getMovesLeft() == 0 && gameOver == false){
				System.out.println("You won !!!!");
				gameOver= true;
			}
		}
		in.close();
	}
}
