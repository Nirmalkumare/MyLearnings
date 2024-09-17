package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		int input = 1235321;

		int output = 0;
		int num = input;
		for (int i = num; i > 0; i /= 10) {
			output = output * 10 + num % 10;
			num = num / 10;
		}
		if (input == output)
			System.out.println("Number is Palindrome: " + output);
		else
			System.out.println("Number is not a Palindrome: " + output);
	}
}