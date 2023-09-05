package exceptions;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.net.MalformedURLException;
/**
 * Use this file example to refactor the main method so that
 * main does not throw the exceptions (i.e. make it HANDLE the exceptions)
 * "handle" in this case is just acknowledging the problem with a printed statement
 * @author bcatron
 * date: Sept 2020
 */
public class ExerciseURLExceptions {
	public static void main(String[] args) {
		int total = 0;

		try {
			URL url = new URL("http://cs.furman.edu/~bcatron/");
			Scanner input = new Scanner(url.openStream());

			while (input.hasNext()) {
				String line = input.nextLine();
				total += getNumberOfWords(line);
			}
		} catch (MalformedURLException e1) {
			System.out.println("Malformed Url Exception");
		} catch (IOException e2) {
			System.out.println("IO Exception");
		} 
		System.out.println("The total number of words is " + total);
	}
	/**
	 * getNumberofWords
	 * @param string from input
	 * @return counted separate words
	 */
	public static int getNumberOfWords(String s) {
		// Split s by punctuations
		String[] tokens = s.split("[\\s\\p{P}]"); 
		int count = 0;

		for (String token: tokens) {
			if (token.trim().length() > 0) {
				count++;
			}
		}
		return count;
	}
}