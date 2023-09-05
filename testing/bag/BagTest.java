package bag;

import bag.Item;
import bag.Box;
import bag.Can;
import bag.Jar;
import card.Card;
import card.Card.CardSuit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BagTest {

	/*
	 * Simplest test of an empty bag
	 */
	@Test
	void testBasic() {
		Bag b = new Bag();
		assertTrue (b.isEmpty());
		assertTrue (b.getCurrentSize() == 0);
	}
	
	/*
	 * adding to one bag should not impact any other bag objects
	 * This would fail if the instance variables were wrongly made 'static'
	 *  ( if static, these values are shared by all objects of type Bag  )
	 */
	@Test
	void testDoubleBagStatic() {
		Bag b = new Bag();
		assertTrue (b.isEmpty());
		assertTrue (b.getCurrentSize() == 0);
		assertTrue (b.equals(b));
		
		Bag another = new Bag();
		assertTrue (another.isEmpty());
		assertTrue (another.getCurrentSize() == 0);
		
		another.add(new Box(440,5));   
		another.add(new Jar(true));
		
		assertTrue (b.isEmpty());
		assertTrue (b.getCurrentSize() == 0);
		
	}
	
	/*
	 * Adding items should change isEmpty, getCurrentSize, and contains
	 */
	@Test
	void testAddingItem() {
		Bag b = new Bag();
		Jar glassJar = new Jar(true);
		Box box = new Box(400,5);
		
		b.add(glassJar);
		assertFalse (b.isEmpty());

		assertTrue (b.getCurrentSize() == 1);
		b.add(box);
		assertTrue (b.getCurrentSize() == 2);
		
		//after implementing, remove the comments from the lines below
		assertTrue (b.contains(glassJar));
		assertTrue (b.contains(box));    //contains exact match
		Box box1 = new Box(400,5);         //duplicate, but separate object
		assertTrue (b.contains(box1));
		
		Box box2 = new Box(600,12);        //different box attributes
		assertFalse (b.contains(box2)); 
		
		//add null item - does this cause issues?
		assertTrue (b.getCurrentSize() == 2);
		b.add(null);    //unspecified action, but shouldn't do anything
		assertTrue (b.getCurrentSize() == 2);
		assertTrue (b.contains(box));
		
		System.out.println (b);  //non binding toString check
	}
	
	/*
	 * adding lots of items will test auto-resizing, getFrequencyOf and getCurrentSize
	 */
	@Test
	void testAddingMany() {
		Bag b = new Bag();
		//add too many items - to force multiple resize conditions
		for (int i=0; i<200; i++) {
			b.add(new Box(100,22));
		}
		assertTrue (b.getCurrentSize() == 200);
		
		Box box = new Box(100,22);
		assertTrue (b.getFrequencyOf(box)==200);
		
	}

	@Test
	/*
	 * test remove items to determine if they match what was put in
	 * Note: each Item, Jar, Box, and Can has its own equals method
	 */
	void testRemoveAnyItem() {
		Jar glassJar = new Jar(true);
		Box box = new Box(400,5);
		
		Bag<Item> b = new Bag<Item>();
		Item temp = b.remove();
		assertTrue (temp == null);
		
		b.add(glassJar);
		Item removed = b.remove();
		assertTrue (removed.equals(glassJar));
		assertFalse (b.contains(glassJar));
		
		//repeat the test several times
		for (int i=0; i<50; i++) {
			b.add(box);
			removed = b.remove();
			assertTrue(removed.equals(box));
			assertFalse(b.contains(box));
		}
	}

	
	@Test
	/*
	 * test remove specific items and confirm they match what was put in
	 */
	void testRemoveItem() throws Exception {
		Jar glassJar = new Jar(true);
		Box box = new Box(400,5);
		Box box2 = new Box(600,10);
		
		Bag<Item> b = new Bag<Item>();
		Item temp = b.remove();
		assertTrue (temp == null);
		
		b.add(glassJar);
		b.add(box);
		b.add(box2);
		assertTrue  (b.remove(box));  //box should exist, so remove it
		assertFalse (b.remove(box)); //box NOW should NOT exist
		
		assertTrue (b.remove(glassJar)); // should exist, so remove it
		assertTrue (b.remove(box2));  // should exist, so remove it
		
		assertTrue (b.isEmpty());
		
		assertFalse (b.remove(null));   //this removal should return false
	}
	
	@Test
	/*
	 * test many adds, followed by the same number of removes
	 */
	void testManyItem() {
		Box box1 = new Box(400,5);
		
		Bag b = new Bag();
		for (int i=0; i<50; i++) {
			b.add(box1);
		}
		assertFalse (b.isEmpty());
		
		int maxSize = b.getCurrentSize();
		int count = b.getFrequencyOf (box1);
		assertTrue (count == maxSize);
		
		for (int i=0; i<maxSize; i++) {
			b.remove();
		}
		assertTrue (b.isEmpty());
	}

	@Test
	void xtraNullTesting () {
		Bag b = new Bag();
		b.contains(null);
		b.getFrequencyOf(null);
		b.add(null);
		assertTrue(b.getCurrentSize()==0);
		b.add(new Box(300,2));
		b.remove(null);
		assertTrue(b.getCurrentSize()==1);
	}
	
	@Test
	void testBagOfStrings() {
		Bag<String> b = new Bag<String>();
		String s1 = "s1";
		String s2 = "s2";
		
		b.add(s1);
		assertTrue(b.contains("s1"));
		assertTrue(b.getCurrentSize() == 1);
		
		b.add(s1);
		b.add(s2);
		assertTrue(b.getFrequencyOf(s1) == 2);
		assertFalse(b.isEmpty());
		assertTrue(b.remove(s2));
		
		b.remove(s1);
		b.remove(s1);
		assertTrue(b.isEmpty());
	}
	
	@Test
	void testBagOfIntegers() {
		Bag<Integer> b = new Bag<Integer>();
		Integer i1 = 1;
		Integer i2 = 2;
		
		b.add(i1);
		assertTrue(b.contains(1));
		assertTrue(b.getCurrentSize() == 1);
		
		b.add(i1);
		b.add(i2);
		assertTrue(b.getFrequencyOf(i1) == 2);
		assertFalse(b.isEmpty());
		assertTrue(b.remove(i2));
		
		b.remove(i1);
		b.remove();
		assertTrue(b.isEmpty());
	}
	
	@Test
	void testBagOfCards() {
		Bag<Card> b = new Bag<Card>();
		Card c1 = new Card(CardSuit.Spades, 2);
		Card c2 = new Card(CardSuit.Spades, 3);
		
		b.add(c1);
		assertTrue(b.contains(c1));
		assertTrue(b.getCurrentSize() == 1);
		
		b.add(c1);
		b.add(c2);
		assertTrue(b.getFrequencyOf(c1) == 2);
		assertFalse(b.isEmpty());
		assertTrue(b.remove(c2));
		
		b.remove(c1);
		b.remove(c1);
		assertTrue(b.isEmpty());
	}
}