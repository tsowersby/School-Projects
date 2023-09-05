package adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParenCheckerTest {

	@Test
	void testParenChecker() {
		assertTrue(ParenChecker.isBalanced("(()())"), "fsdfsd");
	}

}
