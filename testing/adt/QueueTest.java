package adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {

	@Test
	void testBasic() {
		Queue<Integer> q = new Queue<Integer>();
		assertTrue (q.isEmpty());
		assertTrue (q.getSize() == 0);
	}

	@Test
	void testEnqueue() {
		Queue<Integer> q = new Queue<Integer>();

		for (int i = 0; i < 200; i++) {
			q.enqueue((Integer) i);
		}

		assertTrue (q.getSize() == 200);
	}

	@Test
	void testDequeue() throws ContainerEmptyException {
		Queue<Integer> q = new Queue<Integer>();

		for (int i = 0; i < 200; i++) {
			q.enqueue((Integer) i);
		}
		for (int i = 0; i < 200; i++) {
			assertTrue (q.dequeue() == i);
		}
		assertTrue (q.isEmpty());
		assertTrue (q.getSize() == 0);
		assertThrows (ContainerEmptyException.class, () -> q.dequeue());
	}
	
	//@Test
	void testRotation() throws ContainerEmptyException {
		Queue<Integer> q = new Queue<Integer>();
		
		Integer k = 0;
		Integer test = 0;
		
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 4; j++) {
				q.enqueue(k);
				k++;
			}
			assertTrue (q.dequeue() == test);
			test++;
		}
		assertTrue (q.getSize() == 75);
	}
}
