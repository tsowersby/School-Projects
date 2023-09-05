package battleship;

public enum CompassDir {
	North(-1,0), South(1,0), East(0,1), West(0,-1);
	
	public final int offsetX;
	public final int offsetY;
	
	CompassDir(int x, int y) {
		offsetX = x;
		offsetY = y;
	}
}