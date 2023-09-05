package lab01;

public class Craps {
	public static void main(String[] args) {
		Die d1 = new Die();
		Die d2 = new Die(6);

		//Roll twice and see the results
		d1.roll();
		System.out.println ("Dice 1 is:" + d1.getFaceValue());

		d2.roll();
		System.out.println ("Dice 2 is:" + d2.getFaceValue());

		if (d1.getFaceValue() + d2.getFaceValue() == 7) {
			System.out.println ("Craps! You win");
		}

		System.out.println (d1);

	}
}
