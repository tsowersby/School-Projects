package battleship;

/*public enum GridType {
	Boat ('B','B'), Start ('S','S'), Mine ('M','M'), Open ('.','~');

	public final char displayChar;
	public final char fileChar;

	private GridType(char dc, char fc) {
		displayChar = dc;
		fileChar = fc;
	}
}*/

public enum GridType {
	//Boat ('B',"♣"), Start ('S',"."), Mine ('M',"💣"), Open ('.',"~");
	Boat ('B',"B"), Start ('S',"S"), Mine ('M',"M"), Open ('.',"~");
	
	public final String displayChar;
	public final char fileChar;
	
	//constructor for this enum type
	GridType(char fc, String c){
		this.fileChar = fc;
		this.displayChar = c;
	}
	
	//return the GridType value matching this character
	static GridType typeForChar (char c) {
		GridType gtype = GridType.Open;  //default to this
		for (GridType g : GridType.values()) {
			if (g.fileChar == c)
				return g;
		}
		return gtype;
	}
}
