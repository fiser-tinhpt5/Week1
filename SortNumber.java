/*
 * Exercise 1. Find max, min in matrix. Sort matrix increase, decrease.
 */
package exerciseSS1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * author Pham Trung Tinh
 */

public class SortNumber {

	private int array[];
	
	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public void findMaxMin(int[] array) {
		int max = array[0];
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) max = array[i];
			if (array[i] < min) min = array[i];
		}
		System.out.println(max + " " + min);
	}
	
	public void increaseSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[i]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public void decreaseSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[i]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("SortNumber.txt");
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		
		sc.close();

		SortNumber sortNumber = new SortNumber();
		sortNumber.setArray(array);
		
		sortNumber.findMaxMin(sortNumber.getArray());
		
		sortNumber.increaseSort(sortNumber.getArray());
		sortNumber.printArray(sortNumber.getArray());
		
		sortNumber.decreaseSort(sortNumber.getArray());
		sortNumber.printArray(sortNumber.getArray());
		
	}

}
