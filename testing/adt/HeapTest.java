package adt;

import static org.junit.Assert.*;

import org.junit.Test;

import card.Card;

public class HeapTest {

	@Test
	public void test() {
		Heap<String> h = new Heap<String>();
		assertTrue("Empty size",h.size()==0);
		h.add("apple");
		String s = h.remove();
		assertTrue("recover",s.equals("apple"));
	}
	
	@Test
	public void testToString() {
		Heap<Integer> h = new Heap<Integer>();
		h.add(50);
		h.add(40);
		h.add(70);
		h.add(20);
		String s = h.toString();
		System.out.println(s);
		assertTrue("tostring =",s.equals(":20 40 70 50 "));
	}
	
	@Test
	public void testDeeperAdds() {
		Heap<String> h = new Heap<String>();
		
		h.add("apple");
		h.add("banana");
		h.add("coconut");
		h.add("dog");
		assertTrue("with several size",h.size()==4);
		String s = h.remove();
		assertTrue("remove a",s.equals("apple"));
		s = h.remove();
		assertTrue("remove b",s.equals("banana"));
		s = h.remove();
		assertTrue("remove c",s.equals("coconut"));
		s = h.remove();
		assertTrue("remove d",s.equals("dog"));
		assertTrue("Empty size",h.size()==0);
	}
	
	@Test
	public void testMixedAdds() {
		Heap<String> h = new Heap<String>();
		
		h.add("coconut");
		h.add("dog");
		h.add("apple");
		h.add("banana");
		assertTrue("with several size",h.size()==4);
		String s = h.remove();
		
		assertTrue("remove A",s.equals("apple"));
		s = h.remove();
		assertTrue("remove B",s.equals("banana"));
		s = h.remove();
		assertTrue("remove C",s.equals("coconut"));
		s = h.remove();
		assertTrue("remove D",s.equals("dog"));
		assertTrue("Empty size",h.size()==0);
	}
	
	@Test
	public void testLargeRandom() {
		Heap<Integer> h = new Heap<Integer>();	
		//add 100 random integer values
		for (int i=0; i< 100; i++) {
			h.add((int)(Math.random()*100));
		}
		//pull out each and confirm constantly increasing values
		int lastVal = -1;
		for (int i=0; i< 100; i++) {
			int top = h.remove();
			assertTrue ("Not less than "+top , top >= lastVal);
			lastVal = top;
		}
	}
}