package objRace;

import java.util.Scanner;

import adt.ContainerEmptyException;

/**
 * Simple Battleship
 * @author Jack Barton & Wil Sowersby
 */
public class Game {
	private static int shipCount = 3;
	private static int mineCount = 3;
	private static boolean win;
	private static Scanner scanner;
	public static Boards boards;


	private static void playRound() {
		displayGame();

		System.out.println("Select a strike (# #)");
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		boolean hit = boards.selectStrike(row, col);

		if(hit) {
			shipCount--;
			System.out.println("HIT!");
		}
		if (shipCount <= 0)
			win = true;
	}

	private static void displayGame() {
		System.out.println("Battleship");
		boards.printStrikes();
		System.out.println("User Board");
		boards.printUser();
	}


	public static void main(String args[]) throws IllegalAccessException, ContainerEmptyException {
		scanner = new Scanner(System.in);
		win = false;
		boards = new Boards();
		displayGame();
		
		System.out.println("Place a flag (# #)");
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		boards.placeFlag(row, col);

		for (int i = 0; i < mineCount; i++) {
			System.out.println("Place a mine (# #)");
			row = scanner.nextInt();
			col = scanner.nextInt();
			boards.placeMine(row, col);
		}

		//Computer places ships
		boards.placeShips(shipCount);

		int turns = boards.search();

		//Gameplay
		while (!win && turns > 0) {
			System.out.println("Turns: " + turns);
			playRound();
			turns--;
		}

		if(win) {
			System.out.println("User has successfully eliminated the ships! You Win!");
		}
	}
}
