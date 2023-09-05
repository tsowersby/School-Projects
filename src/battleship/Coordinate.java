package battleship;

import adt.Queue;

public class Coordinate {
	public final int row;
	public final int column;
	private boolean visited;
	
	//private Holder<Coordinate> visitedArr = new Queue<Coordinate>();
	
	public Coordinate(int r, int c) {
		row = r;
		column = c;
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Coordinate)) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		Coordinate other = (Coordinate) obj;
		
		return (this.row == other.row) && (this.column == other.column);
	}
	
	public boolean hasBeenVisited() {
		return visited;
		//return visitedArr.contains(new Coordinate(row, column));
	}
	
	public void visit() {
		visited = true;
		//visitedArr.add(new Coordinate(row, column));
	}
	
	public String toString() {
		String s = "";
		s = s + row + ", " + column;
		return s;
	}
}
