package adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

	@Test
	void testEmpty () {
		Stack st = new Stack();
		assertThrows (StackOperationException.class, () ->st.pop());
		assertThrows (StackOperationException.class, () ->st.peek());
		assertTrue (st.isEmpty());
		assertTrue (st.getSize()==0);
	}
}
