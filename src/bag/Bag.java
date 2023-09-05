package bag;
/**
 * Unordered collection of inventory items
 * @author wil sowersby
 * 9/17/20
 */
public class Bag<E> {
	private E[] items;
	private int itemCount; //tracks number of objects in items array
	private final int DEFAULT_SIZE = 20;

	/**
	 * Creates a bag which is an unordered collection of items
	 */
	@SuppressWarnings("unchecked")
	public Bag() {
		items = (E[]) (new Object[DEFAULT_SIZE]);
		itemCount = 0;
	}

	/**
	 * @return an integer denoting the number of items in the bag
	 */
	public int getCurrentSize() {
		return itemCount;
	}

	/**
	 * @return true if there are no items in the bag
	 */
	public boolean isEmpty() {
		return itemCount == 0;
	}

	/**
	 * adds an item to the bag in the first null position
	 * @param item the item to be added to the bag
	 */
	public void add(E item) {
		if (itemCount == items.length) {
			@SuppressWarnings("unchecked")
			E[] temp = (E[]) (new Object[items.length * 2]);

			for (int i = 0; i < items.length; i++) {
				temp[i] = items[i];
			}
			items = temp;
		}
		int i = 0;

		while (items[i] != null) {
			i++;
		}
		if (item != null) {
			items[i] = item;
			itemCount++;
		}
	}

	/**
	 * @param anEntry the item who's frequency in the bag is counted
	 * @return the integer frequency of an item
	 */
	public int getFrequencyOf(E anEntry) {
		int count = 0; //counts number of anEntry items

		for (int i = 0; i < items.length; i++) {
			if (items[i] != null && items[i].equals(anEntry)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 
	 * @param anEntry the item that the bag could contain
	 * @return true if the item anEntry is in the bag
	 */
	public boolean contains(E anEntry) {
		return getFrequencyOf(anEntry) > 0;
	}

	/**
	 * removes any item from the bag
	 * @return the item removed and null if no item is removed
	 */
	public E remove() {
		if (isEmpty()) {
			return null;
		} else {
			int i = 0;

			while ( items[i] == null && i < items.length) {
				i++;
			}
			
			E temp = (E) items[i];
			items[i] = null;
			itemCount--;
			return temp;
		}
	}

	/**
	 * removes a specific item from the bag
	 * @param anEntry the item to be removed
	 * @return true if the item was removed false if not
	 */
	public boolean remove(E anEntry) {
		boolean found = false;
		int i = 0;
		
		while (i < items.length && !found) {
			if (items[i] != null && items[i].equals(anEntry))
				found = true;
			else
				i++;
		}
		if (i < items.length) {
			items[i] = null;
			itemCount--;

			found = true;
		}
		return found;
	}

	@Override
	public String toString() {
		String s = "";   //return output of toString method

		int itemNumber = 0;   //item number in array items assuming there are no empty spaces
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				itemNumber++;
				s = s + "Item " + (itemNumber) + ": " + items[i].toString() + "\n";
			}
		}
		return s;
	}

	/**
	 * completely empties the bag
	 */
	public void clear() {
		@SuppressWarnings("unchecked")
		E[] temp = (E[]) (new Object[DEFAULT_SIZE]);
		items = temp;
	}

	/**
	 * @return the percent of the bag that contains an item
	 */
	public double percentFull() {
		double percent;
		int count = 0; //counter for number of items in items array

		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				count++;
			}
		}
		percent = ((double) count) / items.length;
		
		return percent;
	}
}
