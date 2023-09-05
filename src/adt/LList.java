package adt;

/**
 * Generic Linked List that uses the List interface
 * @author wil sowersby
 * Date: 10/31/2020
 */

public class LList<T> implements List<T> {
	/**
	 * Creates and stores data called nodes for the Linked List
	 * @author wil sowersby
	 * Date: 10/31/2020
	 */
	private class Node {
		T data;     //stored data element
		Node next;  //reference to next node in LList

		/**
		 * Creates a single node
		 * @param data - data to be stored in the node
		 * @param next - next node in LList
		 */
		Node (T data, Node next){
			this.data = data;
			this.next = next;
		}
	}

	private int numberOfEntries;  //total number of nodes in LList
	private Node head;            //start of LList

	/**
	 * Creates an empty LList
	 */
	public LList() {
		head = null;
		numberOfEntries = 0;
	}


	@Override
	/**
	 * Adds a data value to end of the LList
	 * @param item - data to be added to LList
	 */
	public void add(T item) {
		add(numberOfEntries + 10, item);
	}

	@Override
	/**
	 * Adds a data value at a index
	 * @param pos - index position to add data
	 * @param item - data to be added to LList
	 */
	public void add(int pos, T item) {
		if (item == null)
			return;
		else if (head == null || pos <= 0) {
			head = new Node (item, head);
			numberOfEntries++;
		} else {
			Node nxt = head;
			int i = 1;
			while (nxt.next != null && i < pos) {
				nxt = nxt.next;
				i++;
			}
			nxt.next = new Node(item, nxt.next);
			numberOfEntries++;
		}
	}

	/**
	 * Searches for the last instance on an item in LList
	 * @param item - item to be searched for
	 * @return returns the last index of the item if found and -1 otherwise
	 */
	public int findLastIndexOf(T item) {
		int indexOf = -1;

		Node ptr = head;

		int i = 0;
		while(ptr != null) {
			if (ptr.data.equals(item))
				indexOf = i;
			i++;
			ptr = ptr.next;
		}
		return indexOf;
	}

	@Override
	/**
	 * Checks whether or not LList is empty
	 * @return returns true if the LList has zero data entries and false otherwise
	 */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	/**
	 * Pulls a data value from the LList
	 * @param pos - index position of data to be "gotten"
	 * @return returns data "gotten" from LList
	 */
	public T get(int pos) {
		Node ptr = head;

		if (isEmpty())
			return null;
		if (pos >= numberOfEntries)
			pos = numberOfEntries - 1;

		while(pos > 0) {
			ptr = ptr.next;
			pos--;
		}
		return (T) ptr.data;
	}

	@Override
	/**
	 * Checks if LList has a specific data value stored
	 * @param item - data value to be searched for
	 * @return returns true if data value is found in LList and false otherwise
	 */
	public boolean contains(T item) {
		boolean found = false;
		Node ptr = head;

		while (ptr != null && !found) {
			if (ptr.data.equals(item))
				found = true;
			ptr = ptr.next;
		}
		return found;
	}

	@Override
	/**
	 * Removes an item from the LList
	 * @param pos = index position of data to be removed; if pos < 0, removes from beggining; if pos > length, removes from end
	 * @return returns data value removed
	 */
	/*public T remove(int pos) {
		Node ptr = head;
		Node removedNode = head;

		if (pos > numberOfEntries)
			pos = numberOfEntries;

		if (isEmpty())
			return null;
		else if (pos <= 0 || numberOfEntries == 1)
			head = head.next;
		else {
			while (ptr.next != null && pos > 0) {
				ptr = ptr.next;
				pos--;
			}

			removedNode = ptr;
			Node nxt = ptr.next;
			ptr = new Node(nxt.data, nxt.next);
		}
		numberOfEntries--;
		return removedNode.data;
	}*/
	
	public T remove(int pos) {
		T removed = null;

		if (head == null)
			return null;
		else if (pos <= 0 || numberOfEntries == 1) {
			removed = head.data;
			head = head.next;
		} else {
			removed = rRemove(pos, head);
		}
		numberOfEntries--;
		return removed;
	}

	public T rRemove(int pos, Node ptr) {
		T removed = null;
		
		if (ptr.next == null || pos <= 0) {
			removed = ptr.data;
			ptr = ptr.next;
			return removed;
		} else {
			return rRemove(pos - 1, ptr.next);
		}
	}

	@Override
	/**
	 * empties LList
	 */
	public void clear() {
		head = null;
		numberOfEntries = 0;
	}

	@Override
	/**
	 * Determines length of list
	 * @return returns the number of stored data values in LList
	 */
	public int size() {
		return numberOfEntries;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("LList:");

		Node ptr = head;
		while(ptr != null) {
			s.append(ptr.data + ";");
			ptr = ptr.next;
		}
		return s.toString();
	}

	public int find(T item) {
		return rFind(item, head, 0);
	}


	private int rFind(T item, Node ptr, int pos) {

		if (ptr == null) 
			return -1;
		if (ptr.data.equals(item))
			return pos;
		return rFind (item, ptr.next, pos + 1);
	}

	/*@SuppressWarnings("unchecked")
	private T[] arr = (T[]) new Object[10];
	public boolean contains (T item) {
		for (int i = 0; i < arr.length; i++) { //while loop here
			if (arr[i].equals(item))
				return true;
		}
		return false;
	}*/
}
