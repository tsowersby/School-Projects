package lab01;
/**
 * Dice simulator - makes a system to roll a die once
 * @author wil sowersby
 * Date: August 26, 2020
 */
public class Die {
	private final int numberOfSides; //total number of sides on the die
	private int faceValue; //value of the top face when rolled

	public Die () {
		this (6);
	}

	public Die (int sides) {
		faceValue = 1;

		if(2 <= sides && sides  <= 32) {
			numberOfSides = sides;
		}
		else {
			numberOfSides = 6;
		}
	}
	/*
	 * Gets the top face value of the die
	 */
	public int getFaceValue() {
		return faceValue;
	}
	
	/*
	 * 
	 */
	public int getNumberOfSides() {
		return numberOfSides;
	}
	/*
	 * Rolls die by calculating a random number from 1 to n
	 * n being the total number of faces of the die
	 */
	public int roll() {
		faceValue =  (int)(Math.random() * numberOfSides) + 1;
		return faceValue;
	}
	/*
	 * Describes die object by outputting number of faces and top value when rolled	
	 */
	@Override
	public String toString() {
		return "A die with " + numberOfSides + " sides rolled a " + faceValue + ".";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Die)) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		Die other = (Die) obj;

		return (this.numberOfSides == other.numberOfSides) && (this.faceValue == other.faceValue);
	}
	
	@Override 
	public int hashCode() {
		return faceValue * numberOfSides;
	}
}