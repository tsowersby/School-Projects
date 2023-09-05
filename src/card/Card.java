package card;

/**
 * Basic playing card class for demonstration purposes
 * @author wil sowersby
 * Date: 8/1/2020
 */

public class Card implements Comparable<Card>{
	
	public enum CardSuit { 
		Hearts (100), Spades (200), Clubs (300), Diamonds (400);
		
		final int value;

		CardSuit(int v) {
			value = v;
		}
	}

	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;

	private final CardSuit suit;
	private final int rank;

	/**
	 * Create a single valid Card.
	 * Improper valued parameters will be forced to valid
	 * @param suit use constants to set suit 
	 * @param rank use 1-13 or constants ACE-KING to set face value
	 */

	public Card(CardSuit suit, int rank) {
		//Invalid values are corrected
		if (suit == CardSuit.Hearts || suit == CardSuit.Spades 
				|| suit == CardSuit.Diamonds || suit == CardSuit.Clubs) {
			this.suit = suit;
		}
		else {
			this.suit = CardSuit.Hearts;

		}
		if (rank < ACE || rank > KING) {
			rank = ACE;  
		}
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	/**
	 * @return the Card's suit
	 */
	public CardSuit getSuit() {
		if (suit == CardSuit.Clubs) {
			return CardSuit.Clubs;
		}
		else if (suit == CardSuit.Diamonds) {
			return CardSuit.Diamonds;
		}
		else if (suit == CardSuit.Spades) {
			return CardSuit.Spades;  
		}
		else {
			return CardSuit.Hearts;
		}
	}

	/**
	 * @return returns the face value
	 */
	public int getFaceValue() {
		return getRank();
	}

	/**
	 * Suit value as a string
	 * @return a String representation of the suit
	 */
	public String suitAsString() {
		switch ( suit ) {
		case Spades:   return "\u2660";
		case Hearts:   return "\u2665";
		case Diamonds: return "\u2666";
		case Clubs:    return "\u2663";
		}
		return null;  //should never get here
	}

	/**
	 * @return a String representation of the face value
	 */
	public String valueAsString() {
		if (rank == 1) {
			return "ACE";
		}

		else if (rank == 11) {
			return "JACK";
		}

		else if (rank == 12) {
			return "QUEEN";
		}

		else if(rank == 13) {
			return "KING";
		}
		else {
			return Integer.toString(rank);  //return integer as string
		}
	}

	/**
	 * @return a string representation
	 */
	public String toString() {
		String faceValue = valueAsString();
		String suitValue = suitAsString();
		return faceValue + " of " + suitValue;
	}

	/**
	 * Checks for object equality between two cards
	 * @return true if suit and rank are identical; false otherwise
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Card)) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		Card other = (Card) obj;

		return (this.suit == other.suit) && (this.rank == other.rank);
	}

	/**
	 * Hashcode necessary (details later in term)
	 * @return a hashcode value
	 */
	@Override
	public int hashCode() {
		return rank + suit.value;
	}

	@Override
	public int compareTo(Card card) {
		int h1 = hashCode();
		int h2 = card.hashCode();
		
		if (h1 < h2)
			return -1;
		else if (h1 > h2)
			return 1;
		else
			return 0;
	}
}