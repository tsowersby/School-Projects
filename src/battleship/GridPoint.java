package battleship;

public class GridPoint {
	private Coordinate coordinate;
	private GridType type;
	private double cost;
	private boolean visited;
	
	public GridPoint(Coordinate c, GridType t) {
		coordinate = c;
		type = t;
		cost = 1.0;
		visited = false;
	}
	
	public GridPoint(Coordinate c, GridType t, double price) {
		coordinate = c;
		type = t;
		cost = price;
		visited = false;
	}
	
	public boolean hasBeenVisited() {
		return visited;
	}
	
	public void visit() {
		visited = true;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public String toString() {
		return getType().displayChar;
	}

	public GridType getType() {
		return type;
	}
}
