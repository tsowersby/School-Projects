package battleship;

import adt.ContainerEmptyException;
import adt.Queue;

public class Seeker {
	static Holder<GridPoint> options = new Queue<GridPoint>();

	private static void addNeighborsTo (Ocean grid, GridPoint currentPosition) {
		for (CompassDir dir: CompassDir.values()) {
			GridPoint gp = grid.visitableNeighborTo (currentPosition, dir);
			if (gp != null)
				options.add(gp);
		}
	}

	public static void main(String[] args) throws IllegalAccessException, ContainerEmptyException {
		Ocean ocean = new Ocean("ocean.txt");
		GridPoint currentPosition = ocean.getStartingPosition();
		currentPosition.visit();
		addNeighborsTo(ocean, currentPosition);
		
		while (!options.isEmpty() && !ocean.atEnd(currentPosition)) {
			currentPosition = options.remove();
			currentPosition.visit();
			System.out.println("Visiting coordinate:"+currentPosition);
			
			addNeighborsTo(ocean, currentPosition);
		}
		
		if (ocean.atEnd(currentPosition))
			System.out.println ("BOOM");
		else
			System.out.println ("No luck");
	}
}
