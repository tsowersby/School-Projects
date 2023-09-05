package bag;
/**
 * Inventory item of a jar
 * @author bcatron
 * 9/17/20
 */
public class Jar extends Item {
	private final boolean glassMaterial;  //glass jar - or not
	
	public Jar (boolean glass) {
		super ();
		this.glassMaterial = glass;
	}
	
	
	/**
	 * @return true if made of glass
	 */
	public boolean isGlass() {
		return glassMaterial;
	}


	@Override
	public boolean equals (Object o) {
		if (!(o instanceof Jar))
			return false;
		
		Jar jar = (Jar)o;
		return super.equals(o) 
				&& this.glassMaterial == jar.glassMaterial;
	}
	
	
	@Override
	public String toString () {
		if ( isGlass() ) {
			return "Glass Jar with cost $" + getCost();
		} else {
			return "Non-glass Jar with cost $" + getCost();
		}
	}
}