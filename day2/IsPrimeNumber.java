package week1.day2;

import java.util.Scanner;

public class IsPrimeNumber {

	private static Scanner myNum;

	public int primeCheck(int i) {
		int count = 0;
		if (i <= 1) {
			count = 2;
		} else if (i == 2) {
			count = 0;
		} else {
			for (int k = 2; k < i; k++) {
				if (i % k == 0) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {

		myNum = new Scanner(System.in);
		System.out.println("Enter valid number to check for Prime (less than 1000:");
		int gvnNum = myNum.nextInt();
		IsPrimeNumber obbj = new IsPrimeNumber();
		if (gvnNum <= 1000) {
			if (obbj.primeCheck(gvnNum) == 0) {
				System.out.println("The Inputted number is Prime");
			} else {
				System.out.println("The Inputted number is Non Prime");
			}
		} else {
			System.out.println("The Inputted number should be less than 1000");
		}
	}
}