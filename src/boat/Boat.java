package boat;
/**
 * Boat simulator - Models a boat class for the game battleship
 * @author wil sowersby
 * Date: September 4, 2020
 */
public class Boat {
	
	public final String NAME;
	
	private final int health;
	private final int xPosition;
	private final int yPosition;
	private final char orientation;
	
	/**
	 * Creates a single boat battleship at position 1,1
	 */
	public Boat() {
		this ("Battleship", 1, 1, 'N');
	}
	
	/**
	 * Creates a single boat for the game Battleships
	 * @param name use same name as boats in Battleships game
	 * @param x use a positive integer
	 * @param y use a positive integer
	 */
	public Boat(String name, int x, int y, char orient) {
		if (name.equalsIgnoreCase("Carrier")) {
			health = 5;
		}
		else if (name.equalsIgnoreCase("Cruiser") || name.equalsIgnoreCase("Submarine")) {
			health = 3;
		}
		else if(name.equalsIgnoreCase("Destroyer")) {
			health = 2;
		} 
		else {
			name = "Battleship";
			health = 4;
		}
		
		NAME = name;
		xPosition = x;
		yPosition = y;
	    orientation = orient;
	}
	
	/**
	 * @return returns whether or not the boat has sunk meaning its health is 0 or lower
	 */
	public boolean isSunk() {
		return health <= 0;
	}
	
	/**
	 * @param x use positive integer
	 * @param y use positive integer
	 * @return returns whether or not a boat has been hit
	 */
	//TODO: this method currently only checks to see if the bow of the boat has been hit, check orientation and rest of the boat
	public boolean strike(int x, int y) {
		if (x == xPosition && y == yPosition) {
			return true;
		}
		return false;
	}
}
