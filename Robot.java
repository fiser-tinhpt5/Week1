/*
 * Exercise 5. Find the shortestWay for Robot from (1,1) to (n,m)
 */
package exerciseSS1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * author Pham Trung Tinh
 */

public class Robot {

	private int row;
	private int cell;
	private int matrix[][];
	private int shortestWay[][];

	public void setRow(int row) {
		this.row = row;
	}

	public void setCell(int cell) {
		this.cell = cell;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public Robot(int row, int cell, int[][] matrix) {
		super();
		this.row = row;
		this.cell = cell;
		this.matrix = matrix;
	}

	private void initializeShortestWay() {
		shortestWay = new int[row + 2][cell + 2];
		for (int i = 1; i < row + 1; i++) {
			for (int j = 1; j < cell + 1; j++) {
				if (matrix[i - 1][j - 1] != 1) {
					shortestWay[i][j] = matrix[i - 1][j - 1];
				} else {
					shortestWay[i][j] = -1;
				}
			}
		}
	}

	// Method find shortest distance for robot
	private int findShortestDistance() {

		initializeShortestWay();
		int distance = 1;
		shortestWay[1][1] = distance;
		do {
			if (shortestWay[row][cell] != 0) {
				break;
			} else {
				int[][] near = new int[2][4];
				boolean flag = false;
				for (int i = 1; i < row + 1; i++) {
					for (int j = 1; j < cell + 1; j++) {
						if (shortestWay[i][j] == distance) {
							near[0][0] = i - 1;
							near[1][0] = j;
							near[0][1] = i + 1;
							near[1][1] = j;
							near[0][2] = i;
							near[1][2] = j + 1;
							near[0][3] = i;
							near[1][3] = j - 1;
							for (int z = 0; z < 4; z++) {
								if (shortestWay[near[0][z]][near[1][z]] == 0) {
									flag = true;
									shortestWay[near[0][z]][near[1][z]] = distance + 1;
								}
							}
						}
					}
				}
				if (flag)
					distance++;
			}
		} while (shortestWay[row][cell] == 0);

		return distance;
	}

	// Method prints shortest distance and the way that robot go through.
	public void printWay() {

		int distance = findShortestDistance();
		int[][] point = new int[2][distance];
		int z = distance;
		int x = row;
		int y = cell;
		do {
			point[0][distance - z] = x - 1;
			point[1][distance - z] = y - 1;
			z--;
			if (z < 1) {
				break;
			} else if (shortestWay[x - 1][y] == z) {
				x--;
			} else if (shortestWay[x + 1][y] == z) {
				x++;
			} else if (shortestWay[x][y - 1] == z) {
				y--;
			} else if (shortestWay[x][y + 1] == z) {
				y++;
			}
		} while (z > 1);
		System.out.println(distance);
		for (int j = distance - 1; j > -1; j--) {
			System.out.println((point[0][j] + 1) + " " + (point[1][j] + 1));
		}

	}

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("Robot.txt");
		Scanner sc = new Scanner(file);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] array = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		sc.close();
		Robot robot = new Robot(n, m, array);
		robot.printWay();
	}

}
