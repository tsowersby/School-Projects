package battleship;

import adt.ContainerEmptyException;

public interface Holder<T> {
	public void add(T item);
	public T remove() throws IllegalAccessException, ContainerEmptyException;
	public boolean isEmpty();
	public boolean contains(T item);
}
