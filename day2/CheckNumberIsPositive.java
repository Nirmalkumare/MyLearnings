package week1.day2;

public class CheckNumberIsPositive {

	public static void main(String[] args) {
		double num = 10.55;
		if (num > 0) {
			System.out.println("The given number " + num + " is a positive ");
		} else if (num <0) {
			System.out.println("The given number " + num + " is a negative ");
		}else {
			System.out.println("The given number zero");
		}
	}
}