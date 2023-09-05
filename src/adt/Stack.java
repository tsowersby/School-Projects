package adt;

/**
 * Stack class creates a stack of strings for educational purposes
 * @author wil sowersby
 * Date: 9/23/2020
 */

public class Stack {
	private String[] stack;
	private int top;

	/**
	 * creates default stack of strings with length 10
	 */
	public Stack() {
		stack = new String[10];
		top = 0;
	}

	/**
	 * creates a stack of strings of length n
	 * @param n is the intended length of the stack
	 */
	public Stack(int n) {
		if (n < 1) {
			stack = new String[10];
		}
		stack = new String[n];
		top = 0;
	}

	/**
	 * 
	 * @param s string to be added to the top of the stack
	 * @throws StackOperationException if stack is full
	 */
	public void push(String s) throws StackOperationException {
		if (top >= stack.length - 1) {
			throw new StackOperationException();
		}
		if (isEmpty()) {
			stack[top] = s;
		} else {
			top++;
			stack[top] = s;
		}
	}

	/**
	 * @return string on top of stack
	 * @throws StackOperationException if stack is empty
	 */
	public String peek() throws StackOperationException {
		if (isEmpty()) {
			throw new StackOperationException();
		}

		return stack[top];
	}

	/**
	 * removes and returns the string on top of the stack
	 * @return string on top of stack
	 * @throws StackOperationException is stack is empty
	 */
	public String pop() throws StackOperationException {
		if (isEmpty()) {
			throw new StackOperationException();
		}

		String temp = stack[top];
		stack[top] = null;
		
		if (top != 0) {
			top--;
		}

		return temp;
	}

	/**
	 * @return integer number of elements on the stack
	 */
	public int getSize() {
		if (top == 0 && stack[top] == null) {
			return top;
		}
		
		return top + 1;
	}

	/**
	 * @return true if stack is empty false if otherwise
	 */
	public boolean isEmpty() {
		return getSize() == 0;
	}

	@Override
	public String toString() {
		String s = "";

		for (int i = 0; i < stack.length; i++) {
			s = s + stack[i] + ", ";
		}
		return s;
	}
}
