/*
 * Exercise 2. Count number of ways that calculate gave number.
 */
package exerciseSS1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * author Pham Trung Tinh
 */
public class Computation {

	private int number;
	private int[] array;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
		Arrays.sort(this.array);
	}

	//User combination to count
	public void calculate() {

		int countAdd = 0;
		int countMultiple = 0;
		int countSubtract = 0;
		int countDivide = 0;
		for (int i = 1; i <= array.length; i++) {
			int[] combination = new int[i];
			for (int j = 0; j < i; j++) {
				combination[j] = j;
			}
			int kt;
			do {
				int sum = 0;
				int multiple = 1;
				for (int j = 0; j < i; j++) {
					sum += array[combination[j]];
					multiple *= array[combination[j]];
				}
				if (sum == this.number) {
					countAdd++;
				}
				if (multiple == this.number) {
					countMultiple++;
				}
				
				for (int j = 0; j < i; j++) {
					int divide = combination[j];
					int subtract = combination[j];
					for (int z = 0; z < i; z++) {
						if (z != j) {
							divide /= array[combination[z]];
							subtract -= array[combination[z]];
						}
					}
					if (divide == number) {
						countDivide++;
					}
					if (subtract == number) {
						countSubtract++;
					}
				}
				
				int j = i - 1;
				while ((j > -1) && (combination[j] == array.length - i + j)) {
					j--;
				}
				if (j > -1) {
					combination[j]++;
					for (int z = j + 1; z < i; z++) {
						combination[z] = combination[z - 1] + 1;
					}
				}
				kt = j;
			} while (kt > -1);
		}
		System.out.println(countAdd);
		System.out.println(countSubtract);
		System.out.println(countMultiple);
		System.out.println(countDivide);
	}

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("Computation.txt");
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		sc.close();
		
		Computation computation = new Computation();
		computation.setNumber(m);
		computation.setArray(array);
		computation.calculate();
	}

}
