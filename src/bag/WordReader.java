package bag;


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordReader {

	public static void main (String[] args) {
		Scanner sc = null;
		Set<String> set = new Set<String>();
		
		try {
			sc = new Scanner(new File("wordReader.txt"));
			String s = 	"";

			while(sc.hasNext()) {
				s = sc.next();
				if (s.length() > 3)
					set.add(s);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} finally {
			if (sc != null)
				sc.close();
		}
		System.out.println(set.getCurrentSize());
		System.out.println("" + set.contains("“foreign") + set.contains("safety"));
		//System.out.println(set.getFrequencyOf("from"));
	}
}