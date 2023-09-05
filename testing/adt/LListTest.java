package adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bag.Box;
import bag.Item;
import bag.Jar;
/**
 * Test file for linked list implementation
 * 
 * @author bcatron
 * October, 2020
 */
class LListTest {

	@Test
	void testBasics() {
		List<Integer> myList = new LList<Integer>();
		assertTrue (myList.isEmpty());
		assertTrue (myList.size() == 0);

		String ts = myList.toString();
		assertTrue (ts.equals("LList:"), "Non-standard toString() - follow notes precisely!"+ts);
	}

	@Test
	void testAddFront() {
		List<Integer> myList = new LList<Integer>();

		myList.add(0,5);    //put value
		assertFalse (myList.isEmpty());
		assertTrue (myList.size() == 1);

		myList.add(-1,1);    //put at start 
		//list should be 1,5 now
		assertTrue (myList.size() == 2);

		myList.add(0,15);    //put value at start again
		String ts = myList.toString();
		assertTrue (ts.equals("LList:15;1;5;"), "List erroneously is:"+ts);
	}

	@Test
	void testAddAtPosition () {
		List<Integer> myList = new LList<Integer>();

		myList.add(0,1);    //put value
		myList.add(15,10);  //put at end 		
		myList.add(1,5);    //insert in the middle

		String ts = myList.toString();
		assertTrue (ts.equals("LList:1;5;10;"),"List erroneously is:"+ts);
	}

	@Test
	void testRemoveBasic() {
		List<Integer> myList = new LList<Integer>();
		assertTrue (myList.remove(0)==null,"Empty remove failed");
		assertTrue (myList.remove(-2)==null,"Empty remove failed");
		assertTrue (myList.remove(2)==null,"Empty remove failed");

		myList.add(0,1);    
		myList.add(1,5);  		
		myList.add(2,10);   
		myList.add(3,15);   

		assertTrue (myList.remove(0) == 1, "(1) Wrong value returned");
		assertTrue (myList.remove(0) == 5,"(5) Wrong value returned");
		assertTrue (myList.remove(-1) == 10,"(10) Wrong value returned");

		String ts = myList.toString();
		assertTrue (ts.equals("LList:15;"),"List erroneously is:"+ts);

		assertTrue (myList.remove(0) == 15);

		assertTrue (myList.isEmpty());
		assertTrue (myList.size() == 0);
	}

	@Test
	void testAddRemoveExpanded() {
		List<Integer> myList = new LList<Integer>();

		for (int i=0; i<10000; i++) {
			int pos = (int)(Math.random()*10000 - 11000);
			myList.add(pos,i);
		}
		assertTrue (myList.size() == 10000);

		assertTrue (myList.remove(-100) != null, "Null value removed");
		assertTrue (myList.remove(0) != null, "Null value removed");
		assertTrue (myList.remove(100) != null, "Null value removed");
		assertTrue (myList.remove(100) != null, "Null value removed");
		assertTrue (myList.remove(10000) != null, "Null value removed");
		assertTrue (myList.size() == 9995);
	}

	@Test
	void testClear() {
		List<String> myList = new LList<String>();
		assertTrue (myList.size() == 0);
		myList.clear();
		assertTrue (myList.size() == 0);

		for (int i=0; i<10; i++) {
			myList.add(" "+i);
		}

		String ts = myList.toString();
		assertTrue (ts.equals("LList: 0; 1; 2; 3; 4; 5; 6; 7; 8; 9;"),"List erroneously is:"+ts);

		assertTrue (myList.size() == 10);
		myList.clear();
		assertTrue (myList.size() == 0);
	}


	@Test   //taken almost entirely from my old "BagTest" since the API is the same!
	void testAddingItem() {
		List<Item> b = new LList<Item>();
		Item item = b.get(10);	  //check first item
		assertTrue (item == null); //nothing to find

		Jar glassJar = new Jar(true);
		Box box = new Box(400,5);

		b.add(glassJar);
		assertFalse (b.isEmpty());

		assertTrue (b.size() == 1);
		item = b.get(0);	  //check first item
		assertTrue (item.equals(glassJar),"Get item on list");		 		
		item = b.get(10);	  //check first item
		assertTrue (item.equals(glassJar),"Get item on list");		 		
		item = b.get(-10);	  //check first item
		assertTrue (item.equals(glassJar),"Get item on list");		 		


		b.add(box);
		assertTrue (b.size() == 2,"value was "+b.size());

		//after implementing, remove the comments from the lines below
		assertTrue (b.contains(glassJar));
		assertTrue (b.contains(box));    //contains exact match
		Box box1 = new Box(400,5);         //duplicate, but separate object
		assertTrue (b.contains(box1));

		Box box2 = new Box(600,12);        //different box attributes
		assertFalse (b.contains(box2)); 

		//add null item - does this cause issues?
		assertTrue (b.size() == 2);
		b.add(null);    //unspecified action, but shouldn't do anything
		assertTrue (b.size() == 2);
		assertTrue (b.contains(box));

		b.add(box2);
		System.out.println (b);
		item = b.get(0);	  //check first item
		assertTrue (item.equals(glassJar),"Get item on list");		 		
		item = b.get(1);	  //check second item
		assertTrue (item.equals(box),"Get middle item on list");		 		
		item = b.get(2);	  //check third item
		assertTrue (item.equals(box2),"Get last item on list");		 		
		item = b.get(-10);	  //check first item
		assertTrue (item.equals(glassJar),"Get first item on list");		 		
		item = b.get(10);	  //check last item
		assertTrue (item.equals(box2),"Get last item on list");		 		
	}

	@Test
	/**
	 * test remove items for consistency
	 */
	void testGetRemoveItem() {
		Jar glassJar = new Jar(true);
		Box box = new Box(400,5);

		List<Item> b = new LList<Item>();
		Item temp = b.remove(0);
		assertTrue (temp == null);

		b.add(glassJar);
		Item item = b.get(-1);	
		assertTrue (item.equals(glassJar),"Get item on list");		 

		item = b.remove(-1);
		assertTrue (item.equals(glassJar),"Removed only item");
		assertFalse (b.contains(glassJar),"Still contains removed item");

		//repeat the test several times
		for (int i=0; i<50; i++) {
			b.add(box);
			item = b.remove(10);
			assertTrue(item.equals(box));
			assertFalse(b.contains(box));
		}
	}

}