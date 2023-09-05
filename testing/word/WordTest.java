package word;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test suite for Word syllable count program
 * and debugging lab
 * @author bcatron
 * Fall 2019
 */
public class WordTest {

	@Test
	public void testOneSyllable() {
		Word w = new Word("Cat");
		int count = w.countSyllables();
		assertTrue ("Cat :"+count, count == 1 );
		
		w = new Word("Ape");
		count = w.countSyllables();
		assertTrue ("Ape :"+count, count == 1 );
	}
	
	@Test
	public void testTwoSyllable() {
		Word w = new Word("human");
		int count = w.countSyllables();
		assertTrue ("human :"+count, count == 2 );
	}
	
	@Test
	public void testEmptyString() {
		Word w = new Word("");
		int count = w.countSyllables();
		assertTrue (" :"+count, count == 0);
	}
	
	@Test
	public void testDoubleVowels() {
		Word w = new Word("cooked");
		int count = w.countSyllables();
		assertTrue ("cooked :"+count, count == 2);
	}
	
	@Test
	public void testEndingE() {
		Word w = new Word("antagonise");
		int count = w.countSyllables();
		assertTrue ("antagonise :"+count, count == 4);
	}
	
	@Test
	public void testDoubleVowelEnding() {
		Word w1 = new Word("boa");
		int count = w1.countSyllables();
		assertTrue ("boa :"+count, count == 2);
		
		Word w2 = new Word("mia");
		count = w2.countSyllables();
		assertTrue ("mia :"+count, count == 2);
		
		Word w3 = new Word("trachea");
		count = w3.countSyllables();
		assertTrue ("trachea :"+count, count == 3);
		
		Word w4 = new Word("aqua");
		count = w4.countSyllables();
		assertTrue ("aqua :"+count, count == 2);
	}

	public void testChallenges() {
		Word w1 = new Word("onomatopoeia");
		int count = w1.countSyllables();
		assertTrue ("onomatopoeia :"+count, count == 6);
		
		Word w2 = new Word("beneficiary");
		count = w2.countSyllables();
		assertTrue ("beneficiary :"+count, count == 6);
		
		Word w3 = new Word("quinoa");
		count = w3.countSyllables();
		assertTrue ("quinoa :"+count, count == 2);
		
		Word w4 = new Word("cocoa");
		count = w4.countSyllables();
		assertTrue ("cocoa :"+count, count == 2);
	}
}