package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		int n1 = 0, n2 = 1, n3, i, count = 11;
		System.out.print(n1 + " ");
		System.out.print(n2 + " ");
		for (i = 1; i < count; ++i) {
			n3 = n2 + n1;
			System.out.print(n3 + " ");
			n1 = n2;
			n2 = n3;
		}
	}
}