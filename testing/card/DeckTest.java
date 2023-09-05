package card;

/**
 * Test class for a basic deck class
 * @author wil sowersby
 * Date: 9/9/2020
 */
import static org.junit.jupiter.api.Assertions.*;
import card.Card.*;

import org.junit.jupiter.api.Test;

class DeckTest {
	/**
	 * Tests that a deck is created
	 */
	@Test
	public void testContructor() {
		Deck d1 = new Deck();
		assertFalse (d1 == null, "Create a Deck");
	}
	
	/**
	 * Tests that dealTop properly deals a card
	 */
	@Test
	public void testLegalDealTop() {
		Deck d1 = new Deck();
		Card c1 = new Card(CardSuit.Hearts, Card.ACE);
		assertTrue (d1.dealTop() instanceof Card, "Deal a card");
	}
	
	/**
	 * Tests that dealTop does not deal a card when there are no cards
	 */
	@Test
	public void testIllegalDealTop() {
		Deck d1 = new Deck();
		
		for (int i = 0; i < 100; i++) {
			d1.dealTop();
		}
		assertTrue (d1.remaining() > 0, "Deal 100 cards");
	}
	
	/**
	 * Smoke test to see if deck is shuffled
	 */
	@Test
	public void	testShuffle() {
		Deck d1 = new Deck();
		Card c1 = new Card(CardSuit.Hearts, 2);
		Card c2 = new Card(CardSuit.Hearts, 2);
		
		c1 = d1.dealTop();
		d1.shuffle();
		c2 = d1.dealTop();
		
		assertFalse (c1 == c2, "Shuffle and compare top cards.");
	}
	
	/**
	 * Tests if remaining method returns the proper value.
	 */
	@Test
	public void testRemaining() {
		Deck d1 = new Deck();
		for (int i = 0; i < 33; i++) {
			d1.dealTop();
		}
		assertTrue(d1.remaining() == 19, "Deal 33 cards");
	}
}