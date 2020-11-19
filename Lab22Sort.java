package com;

public class Lab22Sort {

	public static void main(String[] args) {
//		int[][] arr = {{4, 3, 6}, {4, 3, 9}, {4, 3, 5}, {4, 2, 3}, {3, 4, 3}, 
//						{3, 4, 7}, {2, 1, 9}, {2, 5, 2}, {2, 9, 3},
//						{3, 9, 1}, {3, 5, 3}, {3, 6, 2}};
		int[][] arr = {{4, 3, 6, 3}, {4, 3, 5, 4}, {4, 2, 3, 2}, {3, 4, 3, 3}, 
				{3, 4, 7, 7}, {2, 1, 9, 2}, {2, 5, 2, 2}, {2, 9, 3, 7},
				{3, 9, 1, 1}, {3, 5, 3, 9}, {3, 6, 2, 4}};
		System.out.println("Original Array:");
		printArr(arr);
		sort(arr);
		System.out.println("Sorted Array:");
		printArr(arr);
	}
	
	public static void sort(int[][] m) {
		for (int c = 0; c < m[0].length; c++) {
			for (int r = 0, r_start = 0, r_end = m.length;
					r < m.length;
					r = r_end, r_start = r) {
				
				if (c > 0) {
					// Check the same value in the previous column
					int pre_col_value = m[r_start][c - 1];
					r_end = r_start;
					while (r_end < m.length && m[r_end][c - 1] == pre_col_value) {
						r_end++;
					}
				}
				bubbleSortRow(m, c, r_start, r_end);
			}
		}
		

	}
	
	public static void bubbleSortRow(int[][] m, int c, int r_start, int r_end) {
		for (int r = r_start; r < r_end; r++) {
			for (int r2 = r + 1; r2 < r_end; r2++) {
				if (m[r][c] > m[r2][c]) {
					// swapping
					int [] temp_row = new int[m[0].length]; // for swapping
					temp_row = m[r];
					m[r] = m[r2];
					m[r2] = temp_row;
				}
				
			}
		}
	}
	
	public static void printArr(int[][] m) {
		System.out.print('{');
		for (int i = 0; i < m.length; i++) {
			System.out.print('{');
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j]);
				if (j < m[0].length - 1)
					System.out.print(',');
			}
			System.out.print('}');
			if (i < m.length - 1)
				System.out.print(',');
			System.out.println();
		}
		System.out.print('}');
	}
}
