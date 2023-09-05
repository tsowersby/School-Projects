package bigOh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Big Oh empirical testing using String append versus StringBuilder class
 * This test builds strings of increasing length and times each size
 * Differences in file access times units will affect exact times, but trends should be clear
 * @author bcatron
 *
 */
public class StringTest {
	static final int SCALE_FACTOR = 25000; //time units are scaled down arbitrarily
	static final int MAX_BUILD = 500; //Max number of strings to build


	public static void main (String[] args) throws FileNotFoundException {
		System.out.println("N,   Time 'units'");

		//Build strings with various lengths as controlled by  buildLength
		for(int length = 2; length < MAX_BUILD; length = length*2) {
			readFileConcatenate (length);		
		}

		///#2    Build strings with various lengths as controlled by  buildLength
		for(int length = 2; length < MAX_BUILD; length = length*2) {
			readFileStringBuilder (length);		
		}

		System.out.println ("Done"); //don't change this line
	}

	public static void readFileConcatenate (int buildLength) throws FileNotFoundException {
		Scanner sc = new Scanner (new File("wordList.txt"));

		sc.next();  //read and throw away first token (makes times more consistent)
		String full = "";

		//Start timing the Build loop
		long start = System.nanoTime();
		for (int i=0; i< buildLength; i++) {   //append many strings
			String s = sc.next();
			full += s;
		}
		long end = System.nanoTime();

		System.out.println(buildLength+" , "+(end-start)/SCALE_FACTOR);
		sc.close();
	}

	public static void readFileStringBuilder (int buildLength) throws FileNotFoundException {
		Scanner sc = new Scanner (new File("wordList.txt"));

		sc.next();  //read and throw away first token (makes times more consistent)
		StringBuilder full = new StringBuilder();

		//Start timing the Build loop
		long start = System.nanoTime();
		for (int i=0; i< buildLength; i++) {   //append many strings
			String s = sc.next();
			full.append(s);
		}
		long end = System.nanoTime();

		System.out.println(buildLength+" , "+(end-start)/SCALE_FACTOR);
		sc.close();
	}

	@Override
	public String toString() {
		return "";
	}

}