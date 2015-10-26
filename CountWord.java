/*
 * Exercise 4. Find the word appear in matrix.
 */
package exerciseSS1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * author Pham Trung Tinh
 */

public class CountWord {

	private int row;
	private int cell;
	private char[][] arrayLetter;
	private String word;
	private int length;
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCell() {
		return cell;
	}

	public void setCell(int cell) {
		this.cell = cell;
	}

	public char[][] getArrayLetter() {
		return arrayLetter;
	}

	public void setArrayLetter(char[][] arrayLetter) {
		this.arrayLetter = arrayLetter;
	}

	public CountWord(int row, int cell, char[][] arrayLetter, String word) {
		super();
		this.row = row;
		this.cell = cell;
		this.arrayLetter = arrayLetter;
		this.word = word;
		this.length = word.length();
	}

	//Count the word appear on Vertical
	public int countVertical() {
		int count = 0;
		for (int j = 0; j < cell; j++) {
			for (int i = 0; i < row - length + 1; i++) {
				String word1 = "";
				for (int k = i; k < i + length; k++) {
					word1 += arrayLetter[k][j];
				}
				if (word1.equals(word)) {
					count++;
				}
			}
			for (int i = row - 1 ; i > length - 2; i--) {
				String word1 = "";
				for (int k = i; k > i - length ; k--) {
					word1 += arrayLetter[k][j];
				}
				if (word1.equals(word)) {
					count++;
				}
			}
		}
		return count;
	}
	
	//Count the word appear on Horizontal
	public int countHorizontal() {
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cell - length + 1; j++) {
				String word1 = "";
				for (int k = j; k < j + length; k++) {
					word1 += arrayLetter[i][k];
				}
				if (word1.equals(word)) {
					count++;
				}
			}
			for (int j = cell - 1 ; j > length - 2; j--) {
				String word1 = "";
				for (int k = j; k > j - length ; k--) {
					word1 += arrayLetter[i][k];
				}
				if (word1.equals(word)) {
					count++;
				}
			}
		}
		return count;
	}
	
	//Count the word appear on Diagonal
	public int countDiagonal() {
		int count = 0;
		for (int i = length - 1; i < row; i++) {
			for (int j = 0; j < cell - length + 1; j++){
				int x = i;
				int y = j;
				String word1 = "";
				while ((x > -1) && (y < cell)) {
					word1 += arrayLetter[x][y];
					x--;
					y++;
				}
				if (word1.equals(word)) {
					count++;
				}
			}
		}
		
		for (int i = 0; i < row - length + 1; i++) {
			for (int j = 0; j < cell - length + 1; j++){
				int x = i;
				int y = j;
				String word1 = "";
				while ((x < row) && (y < cell)) {
					word1 += arrayLetter[x][y];
					x++;
					y++;
				}
				if (word1.equals(word)) {
					count++;
				}
			}
		}
		
		for (int i = 0; i < row - length + 1; i++) {
			for (int j = cell - 1; j > cell - length - 1; j--){
				int x = i;
				int y = j;
				String word1 = "";
				while ((x < row) && (y > -1)) {
					word1 += arrayLetter[x][y];
					x++;
					y--;
				}
				if (word1.equals(word)) {
					count++;
				}
			}
		}
		
		for (int i = length - 1; i < row; i++) {
			for (int j = cell - 1; j > cell - length - 1; j--){
				int x = i;
				int y = j;
				String word1 = "";
				while ((x > -1) && (y > -1)) {
					word1 += arrayLetter[x][y];
					x--;
					y--;
				}
				if (word1.equals(word)) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("CountWord.txt");
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] arrayLetter = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arrayLetter[i][j] = sc.next().charAt(0);
			}
		}
		sc.nextLine();
		String word = sc.nextLine();
		sc.close();
		CountWord countWord = new CountWord(n,m,arrayLetter,word);
		System.out.println(countWord.countVertical());
		System.out.println(countWord.countHorizontal());
		System.out.println(countWord.countDiagonal());
		
	}

}
