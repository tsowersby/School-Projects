package bag;

/**
 * Inventory item of a cylindrical can
 * @author bcatron
 * 9/17/20
 */
public class Can extends Item {
	private final int canRadius;  //radius in millimeters
	private final int canHeight;	//height in millimeters
	
	public Can (int radius, int height) {
		super ();
		canRadius = radius;
		canHeight = height;
	}
	
	
	/**
	 * @return the canRadius
	 */
	public int getCanRadius() {
		return canRadius;
	}


	/**
	 * @return the canHeight
	 */
	public int getCanHeight() {
		return canHeight;
	}

	/**
	 * @return cost per cubic centimeter
	 */
	public double costPerCubicCentimeter () {
		return 0; //TODO: we might need this
	}
	
	
	@Override
	public boolean equals (Object o) {
		if (!(o instanceof Can))
			return false;
		
		Can can = (Can)o;
		return super.equals(o) 
				&& this.canRadius == can.canRadius 
				&& this.canHeight == can.canHeight;
	}
	
	
	@Override
	public String toString () {
		return "Can with cost $" + getCost() + " and height:" + canHeight;
	}
}