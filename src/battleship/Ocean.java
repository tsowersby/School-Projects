package battleship;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import bag.Set;

/**
 * Ocean class that creates the grid game-board
 * @author wil sowersby
 * Date: October 7, 2020
 */

public class Ocean {
	private GridPoint[][] grid;

	public Ocean(String filename) {
		Scanner sc = null;

		try {
			sc = new Scanner(new File("ocean.txt"));

			int numRows = sc.nextInt();
			int numColumns = sc.nextInt();
			sc.nextLine();
			grid = new GridPoint[numRows][numColumns];

			for (int r = 0; r < numRows; r++) {
				for (int c = 0; c < numColumns; c++) {
					Coordinate cor = new Coordinate(r, c);
					grid[r][c] = new GridPoint(cor, GridType.Open);
				}
			}

			while (sc.hasNextLine()) {
				//String line = sc.nextLine();
				//System.out.println("Line: " + line);

				int row = sc.nextInt();
				int col = sc.nextInt();
				char gt = sc.next().charAt(0);
				double  price = 1.0;
				if (gt == '.') {
					price = sc.nextDouble();
				}
				Coordinate cor = new Coordinate(row, col);

				grid[row][col] = new GridPoint(cor, GridType.typeForChar(gt), price);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IndexOutOfBoundsException e1){
			System.out.println("Index out of Bounds");
		} finally {
			if (sc != null)
				sc.close();
		}
	}

	public String toString() {
		String s = "";
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				s = s + grid[r][c].toString();
			}
			s = s + "\n";
		}
		return s;
	}

	public static void main (String[]args) {
		Ocean o = new Ocean("ocean.txt");
		System.out.println(o);
	}

	public GridPoint visitableNeighborTo(GridPoint gp, CompassDir dir) {
		int neighborX = gp.getCoordinate().row + dir.offsetX;
		int neighborY = gp.getCoordinate().column + dir.offsetY;
		GridPoint n = null;

		if ((neighborX >= 0 && neighborX < grid.length) && 
				(neighborY >= 0 && neighborY < grid[0].length))
			n = grid[neighborX][neighborY];

		return n;
	}

	public GridPoint getStartingPosition() {
		int r = 0;
		int c = 0;
		while (grid[r][c].getType().fileChar != '.'){
			if (r == grid.length)
				r = 0;
			c++;
		}
		return grid[r][c];
	}

	public boolean atEnd(GridPoint currentPosition) {
		
		if (currentPosition.getType().fileChar == 'M')
			return true;
		return false;
	}
}
