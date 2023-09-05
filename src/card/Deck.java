package card;

import card.Card.*;

public class Deck {
	private int top; // Card on top of the deck
	private Card[] deck; // Deck of 52 cards

	// Constructor that creates a deck of cards
	public Deck() {
		deck = new Card[52];
		top = 52;
		for (int i = 0; i < 13; i++) {
			deck[i] = new Card(CardSuit.Hearts, i + 1);
			deck[i + 13] = new Card(CardSuit.Diamonds, i + 1);
			deck[i + 26] = new Card(CardSuit.Clubs, i + 1);
			deck[i + 39] = new Card(CardSuit.Spades, i + 1);
		}
	}

	// Put all the used cards back into the deck, and shuffle it into a random order
	public void shuffle() {
		for (int i = 51; i > 0; i--) {
			int rand = (int)(Math.random() * (i + 1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
		top = 52;
	}

	public Card dealTop() {
		if (top == 0)
			shuffle();
		top--;
		return deck[top];
	}

	public int remaining() {
		return top;
	}

	// Returns a string of the deck
	public String toString() {
		if (top == 0)
			return "Empty";
		String deckString = deck[0].toString() + ' ';
		for (int i = 1; i < top; i++) {
			if (i % 13 == 0)
				deckString += '\n';
			deckString += deck[i].toString() + ' ';
		}
		return deckString;
	}
}
