package adt;

public class Heap<T extends Comparable<T>> {
	private T [] myheap;
	private int size;
	public static final int HEAP_SIZE = 110;

	/**
	 * Basic constructor
	 */
	@SuppressWarnings("unchecked")
	public Heap () {
		size = 0;
		myheap = (T[])(new Comparable[HEAP_SIZE]);
	}

	public void add(T item) {
		size++;
		//add to end of heap
		myheap[size] = item;
		int perc = size;
		//"percolate up" while not at root and thisNode < parentNode
		while (perc > 1
				&& myheap[perc].compareTo(myheap[perc/2]) < 0){
			T temp = myheap[perc];
			myheap[perc] = myheap[perc/2];
			myheap[perc/2] = temp;
			perc = perc/2;
		}
	}

	private void percolateDown(int n) {
		int right = 2 * n + 1;
		int left = 2 * n;

		if (myheap[left] != null && myheap[right] != null) { //myheap[n] != null && 
			int perc = 2 * n + 1;

			if (myheap[left].compareTo(myheap[right]) < 0)
				perc = 2 * n;
			if (myheap[n].compareTo(myheap[perc]) != 0) {
				T temp = myheap[n];
				myheap[n] = myheap[perc];
				myheap[perc] = temp;
			}
			percolateDown(perc);
		}

		if (myheap[left] != null && myheap[right] == null && myheap[left].compareTo(myheap[n]) < 0) {
			T temp = myheap[n];
			myheap[n] = myheap[left];
			myheap[left] = temp;
		}

	}

	public T remove() {
		//remove root, swap last item, percolate down
		T minItem = myheap[1];
		myheap[1] = myheap[size];
		myheap[size] = null; //for debugging
		size--;
		//percolate root down to bottom
		percolateDown(1);
		return minItem;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(":");
		
		int n = 1;
		
		int left = 2;
		int right = 3;
		
		s.append(myheap[n] + " ");
		
		while (n < size) {
		
		for (int i = left; i <= right; i++) {
			if (myheap[i] != null)
				s.append(myheap[i] + " ");
			n++;
		}
		left = left * 2;
		right = right * 2 + 1;
		}

		return s.toString();
	}
}
