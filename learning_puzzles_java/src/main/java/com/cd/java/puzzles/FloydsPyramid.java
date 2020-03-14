package com.cd.java.puzzles;

public class FloydsPyramid {

	/**
	 *	Prints Floyd Pyramid 
	 */
	public void printPyramid(final int pyramidLength) {
	
		int i, j, rows = 1;
		for (i = 1; rows <= pyramidLength; i++) {
			for ( j = 1; j <= i; j++) {
				System.out.print(rows + " ");
				rows++;
			}
			System.out.println("\n");
		}
		
	}
	
	
	public void printPyramidStars(final int pyramidLength) {
		
		int k, p, stars = 1;
		for (k = 1; stars <= pyramidLength; k++) {
			for ( p = 1; p <= k; p++) {
				System.out.print("* ");
				stars++;
			}
			System.out.println("\n");
		
		}
	}
	
	/**
	 *	Prints Floyd Reverse Pyramid 
	 */
	public void reverseFloydTriangleNumbers(final int pyramidLength) {
		
		int numRows = calculateNumRows(pyramidLength);
		int tempPyramidValue = pyramidLength;
		
		int i,j = 1;
		for(i = numRows; i >= 0 ; i--) {
			 
			for(j = 1; j <= i; j++) {
				System.out.print(tempPyramidValue + " ");	
				tempPyramidValue--;
			}
			System.out.println("\n");
		}
		
	}
	
	public void reverseFloydTriangle(final int pyramidLength) {
		
		int numRows = calculateNumRows(pyramidLength);
		
		int i,j = 1;
		for(i = numRows; i >= 0 ; i--) {
			 
			for(j = 1; j <= i; j++) {
				System.out.print("* ");	
			}
			System.out.println("\n");
		}
		
	}
	
	
	
	/**
	 *	Calculate how many rows are required based on size of pyramid 
	 */
	private int calculateNumRows(final int pyramidPieces) {
	
		int count = 0, sumRows = 0, reduceByValue = 0;
		int tempPyramidPieces = pyramidPieces;
		
		while(sumRows < pyramidPieces) {
			
			reduceByValue = tempPyramidPieces - 1;
			int tempSumRow = pyramidPieces - reduceByValue;
			
			sumRows += tempSumRow;
			count++;
			tempPyramidPieces--;
		}
		return count;
	}
	
}
