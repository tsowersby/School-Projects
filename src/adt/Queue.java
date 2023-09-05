package adt;

import battleship.Holder;

/**
 * Generic queue class creates and abstract data type, queue, with FIFO ordering
 * @author wil sowersby
 * Date: 10/7/2020
 */

public class Queue<T> implements Holder<T>{
	private T[] queue;
	private int tail;
	private int head;
	private int itemCount;
	private final int DEFAULT_SIZE = 10;

	/**
	 * Constructs an empty queue of length ten
	 * head and tail are set to their staring positions
	 */
	@SuppressWarnings("unchecked")
	public Queue() {
		queue = (T[]) (new Object[DEFAULT_SIZE]);
		head = 0;
		tail = -1;

		itemCount = 0;
	}

	/**
	 * Adds item to the end of the queue, and expands if full
	 * @param item to be added to the queue
	 * @throws ContainerEmptyException should never happen, but dequeue is used when expanding queue
	 */
	@SuppressWarnings("unchecked")
	public void enqueue(T item) {
		if (itemCount == queue.length - 1) {
			T[] temp = (T[]) (new Object[queue.length * 2]);

			int pos = (tail + 1) % queue.length;
			for (int i = 0; i < itemCount; i++) {
				temp[i] = queue[pos];
				pos = (pos + 1) % queue.length;
			}

			tail = -1;
			head = itemCount - 1;
			queue = temp;
		}

		if(!isEmpty()) {
			head = (head + 1) % queue.length;
		}
		itemCount++;
		queue[head] = item;
	}

	/**
	 * Removes the first item in the queue following FIFO ordering
	 * @return the item removed from the queue
	 * @throws ContainerEmptyException if trying to dequeue from an empty queue
	 */
	public T dequeue() throws ContainerEmptyException{
		if (isEmpty()) {
			throw new ContainerEmptyException();
		}
		tail = (tail + 1) % queue.length;
		itemCount--;

		T item = queue[tail];
		queue[tail] = null;

		return item;
	}

	/**
	 * @return the number of items in the queue
	 */
	public int getSize() {
		return itemCount;
	}

	/**
	 * @return the first item in the queue
	 * @throws ContainerEmptyException if trying to peek on an empty queue
	 */
	public T peek() throws ContainerEmptyException {
		if (isEmpty()) {
			throw new ContainerEmptyException();
		}

		return queue[tail + 1];
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("Queue: ");

		for (int i = 1; i <= itemCount; i++) {
			s.append(queue[(tail + i) % queue.length] + ",");
		}

		return s.toString();
	}

	@Override
	public void add(T item) {
		enqueue(item);
	}

	@Override
	public T remove() throws IllegalAccessException, ContainerEmptyException {
		return dequeue();
	}

	/**
	 * @return true if the queue is empty false of otherwise
	 */
	@Override
	public boolean isEmpty() {
		return itemCount == 0;
	}

	@Override
	public boolean contains(T item) {
		for (int i = 0; i < queue.length; i++) {
			if (item != null && queue[i] != null) {
				if (queue[i].equals(item))
					return true;
			}
		}
		return false;
	}
}
