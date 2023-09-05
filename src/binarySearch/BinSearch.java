package binarySearch;

import card.Card;
import card.Card.CardSuit;

/**
 * Generic binary search class
 * @author wil sowersby
 * Date: 10/23/2020
 */

public class BinSearch<E extends Comparable<E>> {

	public static void main(String[] args) {
		//Integer[] arr = {1, 2, 5, 6, 8, 10, 11, 13, 14, 17, 24, 25, 33, 37, 38, 41, 54, 55, 69, 70};

		Card[] cards = new Card[10];

		cards[0] = new Card(CardSuit.Hearts, Card.ACE);
		cards[1] = new Card(CardSuit.Hearts, Card.QUEEN);
		cards[2] = new Card(CardSuit.Hearts, Card.KING);
		cards[3] = new Card(CardSuit.Spades, Card.ACE);
		cards[4] = new Card(CardSuit.Spades, 10);
		cards[5] = new Card(CardSuit.Clubs, 2);
		cards[6] = new Card(CardSuit.Clubs, 8);
		cards[7] = new Card(CardSuit.Clubs, Card.JACK);
		cards[8] = new Card(CardSuit.Diamonds, Card.ACE);
		cards[9] = new Card(CardSuit.Diamonds, 2);

		int index = binarySearch(cards, new Card(CardSuit.Clubs, 2), 0, cards.length - 1);

		if (index > -1) {
			System.out.println("Index: " + index);
		} else {
			System.out.println("Not found");
		}
	}

	/**
	 * a binary search starter method which calls a recursive binary search
	 * @param arr - a sorted generic array to be searched
	 * @param key - the generic value to be searched for
	 * @return returns -1 if the key is not found and the index if it is found
	 */
	public int binarySearch(E[] arr, E key) {
		return binarySearch(arr, key, 0, arr.length - 1);
	}

	/**
	 * Recursive binary search that finds the index of an object
	 * @param <E>
	 * @param arr - generic array containing objects to be searched through
	 * @param key - object that is being searched for in the array
	 * @param left - lowest or left-most index for the search algorithm
	 * @param right - highest or right-most index for the search algorithm
	 * @return returns the index of the key if found and -1 otherwise
	 */
	public static<E extends Comparable<E>> int binarySearch(E[] arr, E key, int left, int right) {
		if (left > right || key == null)
			return -1;
		
		int middle = (left + right) / 2;
		
		if (arr[middle].compareTo(key) == 0)
			return middle;
		else if (arr[middle].compareTo(key) < 0)
			return binarySearch(arr, key, middle + 1, right);
		else
			return binarySearch(arr, key, left, middle - 1);

	}
}
