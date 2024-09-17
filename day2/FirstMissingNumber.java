package week1.day2;

import java.util.Arrays;

public class FirstMissingNumber {

	public static void main(String[] args) {

		int series[] = { 1, 4, 3, 2, 8, 6, 7 };
		Arrays.sort(series);
		int max = series.length - 1;

		for (int i = 1; i <= max; i++) {
			if (series[i - 1] + 1 != series[i]) {
				System.out.println(series[i] - 1);
			}
		}
	}
}