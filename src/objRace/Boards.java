package objRace;

import java.util.Random;

import adt.ContainerEmptyException;
import adt.Queue;
import battleship.CompassDir;
import battleship.Coordinate;
import battleship.Holder;

public class Boards {
	private final static int BOARDSIZE = 5;

	private char ships[][];
	private char strikes[][];
	private char user[][];

	static Holder<Coordinate> searchPath = new Queue<Coordinate>();
	static Holder<Coordinate> options = new Queue<Coordinate>();

	public Boards() {
		ships = new char[BOARDSIZE][BOARDSIZE];
		strikes = new char[BOARDSIZE][BOARDSIZE];
		user = new char[BOARDSIZE][BOARDSIZE];

		for(int i = 0; i < BOARDSIZE; i++) {
			for(int j = 0; j < BOARDSIZE; j++) {
				ships[i][j] = '#';
				strikes[i][j] = '?';
				user[i][j] = '#';
			}
		}
	}




	/**
	 * Prints board
	 * @param board
	 */
	private void printBoard(char board[][]) {
		System.out.print(" ");
		for(int i = 0; i < BOARDSIZE; i++) {
			System.out.print(i + " ");
		}

		System.out.println();

		for(int j = 0; j < BOARDSIZE; j++) {
			System.out.print(j);
			for(int i = 0; i< BOARDSIZE; i++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printStrikes() {
		printBoard(strikes);
	}
	public void printShips() {
		printBoard(ships);
	}
	public void printUser() {
		printBoard(user);
	}


	public void placeShips(int count) {
		int row = 0;
		int col = 0;
		Random random = new Random();
		for (int i = 0; i < count; i++) {
			row = random.nextInt(BOARDSIZE);
			col = random.nextInt(BOARDSIZE);
			if (ships[row][col] == 'O')
				count++;
			else {
				placeShip(row, col);
				System.out.println("CPU placed ship at " + row + " " + col);
			}
		}

	}

	public boolean selectStrike(int row, int col) {
		boolean hit = false;

		if(ships[row][col] == 'O') {
			ships[row][col] = 'X';
			strikes[row][col] = 'X';
			hit = true;
		}else {
			strikes[row][col] = '-';
		}

		return hit;
	}

	public void placeShip(int row, int col) {
		ships[row][col] = 'O';
	}

	public void placeMine(int row, int col) {
		user[row][col] = 'M';
	}

	public void placeFlag(int row, int col) {
		user[row][col] = 'F';
	}


	public int search() throws IllegalAccessException, ContainerEmptyException {
		int count = 1;
		Random random = new Random();
		int startingCol = random.nextInt(BOARDSIZE);


		Coordinate currentPosition = new Coordinate(0, startingCol);
		if (user[0][startingCol] == 'M')
			user[0][startingCol] = 'E';
		else if (user[0][startingCol] == 'F')
			user[0][startingCol] = 'G';
		else
			user[0][startingCol] = 'V';
		searchPath.add(currentPosition);
		addNeighborsTo(user, currentPosition);

		while (!options.isEmpty() && !atEnd(currentPosition)) {
			currentPosition = options.remove();
			addNeighborsTo(user, currentPosition);
			searchPath.add(currentPosition);
			count++;
		}

		return count;
	}

	private void addNeighborsTo(char[][] board, Coordinate currentPosition) {
		for (CompassDir dir: CompassDir.values()) {
			Coordinate coord = visitableNeighborTo (currentPosition, dir);
			if (coord != null && (user[coord.row][coord.column] != 'V' && user[coord.row][coord.column] != 'E' && user[coord.row][coord.column] != 'G')) {
				options.add(coord);
				if (user[coord.row][coord.column] == 'M')
					user[coord.row][coord.column] = 'E';
				else if (user[coord.row][coord.column] == 'F')
					user[coord.row][coord.column] = 'G';
				else
					user[coord.row][coord.column] = 'V';
			}			
		}
	}

	private Coordinate visitableNeighborTo(Coordinate currentPosition, CompassDir dir) {
		int neighborX = currentPosition.row + dir.offsetX;
		int neighborY = currentPosition.column + dir.offsetY;
		Coordinate n = null;;

		if ((neighborX >= 0 && neighborX < user.length) && 
				(neighborY >= 0 && neighborY < user[0].length))
			n = new Coordinate(neighborX, neighborY);

		return n;
	}

	public boolean atEnd(Coordinate coord) {
		if (user[coord.row][coord.column] == 'F' || user[coord.row][coord.column] == 'G')
			return true;
		return false;
	}

	public boolean isMine(int row, int col) {
		return user[row][col] == 'E';
	}
}
