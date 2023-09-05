package lab01;

import static org.junit.jupiter.api.Assertions.*;
import card.Card.*;

import org.junit.jupiter.api.Test;

import card.Card;

class DieTest {
	/**
	 * tests if the constructor works properly with legal values
	 */
	@Test
	public void constructorNormalTest(){
		//Default constructor
		Die d1 = new Die();
		assertTrue (d1.getNumberOfSides() == 6, "Make default");
		//Other constructors
		Die d2 = new Die(6);
		assertTrue (d2.getNumberOfSides () == 6, "Make 6 sided");
		Die d3 = new Die(32);
		assertTrue (d3. getNumberOfSides () == 32, "Make 32 sided");
		Die d4 = new Die(2);
		assertTrue (d4.getNumberOfSides () == 2, "Make 2 sided");
	}
	
	/**
	 * Tests overridden equals method
	 */
	@Test
	public void testEquals() {
		Die d1 = new Die();
		assertTrue (d1.equals(d1), "A die is equal to itself");
		Die d2 = new Die(6);
		assertTrue (d1.equals(d2), "Two of the same die are equal");
		Die d3 = new Die(22);
		assertFalse (d2.equals(d3), "Two different die are not equal");
		Card c1 = new Card(CardSuit.Hearts, Card.ACE);
		assertFalse (d1.equals(c1), "A die is not equal to a card");
	}
	
	
	/**
	 * Tests constructor with illegal values
	 */
	@Test
	public void constructorIllegalTest() {
		Die d1 = new Die(33);
		assertTrue (d1.getNumberOfSides() == 6, "Make 33 sided");
		Die d2 = new Die(0);
		assertTrue (d2.getNumberOfSides() == 6, "Make 0 sided");
		Die d3 = new Die(-2);
		assertTrue (d3.getNumberOfSides() == 6, "Make -2 sided");
	}
	
	/**
	 * Tests roll methos by summing values
	 */
	@Test
	public void testRollWithSum() {
		Die d1 = new Die();
		double sum = 0.0;
		for(int i = 0; i < 100; i++) {
			sum += d1.roll();
		}
		assertEquals (350.0, sum, 500.0);
	}
	
	/**
	 * Tests roll methods by using an array
	 */
	@Test
	public void testRollWithArray() {
		int[] arr = new int[7];
		Die d1 = new Die();
		for(int i = 0; i < 100; i++) {
			arr[d1.roll()] += 1;
		}
		assertEquals (arr[1], arr[2], 16.66);
		assertEquals (arr[3], arr[4], 16.66);
		assertEquals (arr[5], arr[6], 16.66);
	}
}