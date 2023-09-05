package bag;
/**
 * Inventory item of a basic box of food
 * @author bcatron
 * 9/17/20
 */
public class Box extends Item {
	private final int calories; 		//FDA calories per serving
	private final int numberServings;	//FDA servings per box
	
	public Box (int calories, int numberServings) {
		super ();
		this.calories = calories;
		this.numberServings = numberServings;
	}
	
	/**
	 * @return the calories
	 */
	public int getCalories() {
		return calories;
	}

	/**
	 * @return the numberServings
	 */
	public int getNumberServings() {
		return numberServings;
	}

	/**
	 * @return cost of product per serving
	 */
	public double costPerServing () {
		return 0; //TODO: we might need this
	}
	
	
	@Override
	public boolean equals (Object o) {
		if (!(o instanceof Box))
			return false;
		
		Box box = (Box)o;
		return super.equals(o) 
				&& this.numberServings == box.numberServings ;
	}
	
	
	@Override
	public String toString () {
		return "Box with cost $" + getCost() + " and servings:" + numberServings;
	}
}