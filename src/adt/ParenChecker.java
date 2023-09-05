package adt;
/**
* Parenthesis checker class that checks if open and closed parenthesis are balanced
* @author wil sowersby
* Date: 9/30/2020
*/
public class ParenChecker {
	/**
	 * 
	 * @param s string whose parenthesizes will be checked
	 * @return true if parenthesis are balanced false if otherwise
	 * @throws StackOperationException when trying to pop or peek on an empty stack or push onto a full stack
	 */
	public static boolean isBalanced (String s)  throws StackOperationException{
		Stack stack = new Stack(s.length());
		boolean balanced = true;
		char ch;
		String chAsString = "";

		int i = 0;

		while (i < s.length() && balanced) {
			ch = s.charAt(i);
			chAsString = Character.toString(ch);

			if (ch == '(') {
				stack.push(chAsString);
			}

			else if (ch == ')') {
				if (stack.isEmpty()) {
					balanced = false;
					stack.push(chAsString);
				} else {
					stack.pop();
				}
			}
			i++;
		}
		if (!(stack.isEmpty())) {
			balanced = false;
		}
		return balanced;
	}
	
	public static void main (String[] arg) throws StackOperationException {
		boolean tester;

		tester = isBalanced("(()())");

		System.out.println(tester);
	}
}
