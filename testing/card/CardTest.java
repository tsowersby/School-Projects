package card;

import static org.junit.jupiter.api.Assertions.*;
import card.Card.*;

import org.junit.jupiter.api.Test;

class CardTest {
	
	/**
	 * Tests if the constructor is properly initializing card objects
	 */
	@Test
	public void testDefaultConstructor() {
		Card c = new Card(CardSuit.Hearts, Card.ACE);
		assertTrue (c.getSuit() == CardSuit.Hearts, "Suit");
		assertTrue (c.getFaceValue() == 1, "Face Value");
	}
	
	/**
	 * Test if getFaceValue is able to return the current face value
	 */
	@Test
	public void testGetFaceValue() {
		Card c = new Card(CardSuit.Hearts, Card.ACE);
		assertTrue (c.getFaceValue() == Card.ACE, "Face Value");
	}
	
	/**
	 * Test if getSuit is able to return the current suit value
	 */
	@Test
	public void testGetSuit() {
		Card c = new Card(CardSuit.Hearts, Card.ACE);
		assertTrue (c.getSuit() == CardSuit.Hearts, "Suit");
	}
	
	/**
	 * Test that the suit is being initialized properly
	 */
	@Test
	public void testSuit() {
		Card c1 = new Card(CardSuit.Hearts, Card.ACE);
		assertTrue (c1.getSuit() == CardSuit.Hearts, "Valid Suit in range");
		Card c2 = new Card(0, Card.ACE);
		assertTrue (c2.getSuit() == CardSuit.Hearts, "Invalid Suit below range");
		Card c3 = new Card(777, Card.ACE);
		assertTrue (c3.getSuit() == CardSuit.Hearts, "Invalid Suit above range");
	}
	
	/**
	 * Test that the face value is being initialized properly
	 */
	@Test
	public void testFaceValue() {
		Card c1 = new Card(CardSuit.Hearts, 2);
		assertTrue (c1.getFaceValue() == 2, "Valid Face Value in range");
		Card c2 = new Card(CardSuit.Hearts, 0);
		assertTrue (c2.getFaceValue() == Card.ACE, "Invalid Face Value below range");
		Card c3 = new Card(CardSuit.Hearts, 777);
		assertTrue (c3.getFaceValue() == Card.ACE, "Invalid Face Value above range");
	}
	
	/**
	 * Tests if face values are being correctly returned as strings
	 */
	@Test
	public void testValueAsString() {
		Card c1 = new Card(CardSuit.Hearts, Card.ACE);
		assertTrue (c1.valueAsString().equals("ACE"), "ACE value as string");
		Card c2 = new Card(CardSuit.Hearts, Card.JACK);
		assertTrue (c2.valueAsString().equals("JACK"), "JACK value as string");
		Card c3 = new Card(CardSuit.Hearts, Card.QUEEN);
		assertTrue (c3.valueAsString().equals("QUEEN"), "QUEEN value as string");
		Card c4 = new Card(CardSuit.Hearts, Card.KING);
		assertTrue (c4.valueAsString().equals("KING"), "KING suit as string");
	}
	
	/**
	 * Tests if suits are being correctly returned as strings
	 */
	@Test
	public void testSuitAsString() {
		Card c1 = new Card(CardSuit.HEARTS, Card.ACE);
		assertTrue (c1.suitAsString().equals("\u2665"), "HEART suit as string");
		Card c2 = new Card(Card.CLUBS, Card.ACE);
		assertTrue (c2.suitAsString().equals("\u2663"), "CLUB suit as string");
		Card c3 = new Card(Card.DIAMONDS, Card.ACE);
		assertTrue (c3.suitAsString().equals("\u2666"), "DIAMOND suit as string");
		Card c4 = new Card(Card.SPADES, Card.ACE);
		assertTrue (c4.suitAsString().equals("\u2660"), "SPADE suit as string");
	}
	
	/**
	 * Tests whether the equals method properly compares two card objects
	 */
	@Test
	public void testEquals() {
		Card c1 = new Card(Card.HEARTS, Card.ACE);
		assertTrue (c1.equals(c1), "A card is equal to itself");
		Card c2 = new Card(Card.HEARTS, Card.ACE);
		assertTrue (c1.equals(c2), "Two of the same card are equal");
		Card c3 = new Card(Card.HEARTS, 2);
		assertFalse (c2.equals(c3), "Two different cards are not equal");
	}
	
	/**
	 * Tests if hashcode is returning the proper values
	 */
	@Test 
	public void testHashcode() {
		Card c1 = new Card(Card.HEARTS, Card.ACE);
		Card c2 = new Card(Card.HEARTS, Card.ACE);
		assertTrue (c1.hashcode() == c2.hashcode(), "Two of the same card have the same hashcode");
		Card c3 = new Card(Card.HEARTS, 2);
		assertFalse (c2.hashcode() == c3.hashcode(), "Two different cards have different hashcodes");
	}
	
	/**
	 * Tests whether toString is properly decribing card objects
	 */
	@Test
	public void testToString() {
		Card c1 = new Card(Card.HEARTS, Card.ACE);
		assertTrue (c1.toString().equals("ACE of \u2665"), "ACE of Hearts");
	}
}
