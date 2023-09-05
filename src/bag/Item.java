package bag;	
/**
 * Sample (simple) inventory class for things you might sell
 * Illustrates inheritance and polymorphism concepts
 * @author bcatron
 * 9/17/20
 */
public class Item {
	private static final double PENNY_THRESHOLD = 0.01; //less than a penny
	private double cost;
	private int weightInOunces;


	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * @return the weightInOunces
	 */
	public int getWeightInOunces() {
		return weightInOunces;
	}
	/**
	 * @param weightInOunces the weightInOunces to set
	 */
	public void setWeightInOunces(int weightInOunces) {
		this.weightInOunces = weightInOunces;
	}

	@Override
	public boolean equals (Object o) {
		if (! (o instanceof Item)) {
			return false;
		}

		Item i = (Item)o;
		return (Math.abs(this.cost - i.cost) < PENNY_THRESHOLD) 
				&& (this.weightInOunces == i.weightInOunces);
	}

	@Override
	public String toString () {
		return "Item with cost $" + cost;
	}
}