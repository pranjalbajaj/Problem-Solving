/**
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  
 * (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 * We may rotate the ith domino, so that A[i] and B[i] swap values.
 * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
 * If it cannot be done, return -1.
 */

package misc;

public class MinimumDominoRotation {

	public static void main(String[] args) {
		
		int[] A = {2,1,2,4,2,2};
		
		int[] B = {5,2,6,2,3,2};
		
		System.out.println(minDominoRotations(A, B));

	}

	public static int minDominoRotations(int[] A, int[] B) {

		int c1 = rotate(A[0], A, B);

		int c2 = rotate(A[0], B, A);

		int c3 = rotate(B[0], A, B);

		int c4 = rotate(B[0], B, A);

		int r = Math.min(Math.min(c1, c2), Math.min(c3, c4));

		return r == Integer.MAX_VALUE ? -1 : r;

	}

	private static int rotate(int target, int[] A, int[] B) {

		int n = A.length;

		int rCount = 0;

		for (int i = 0; i < n; i++) {

			if (target == A[i]) {

				continue;
			} else if (target == B[i]) {

				rCount++;
			} else {

				return Integer.MAX_VALUE;
			}
		}

		return rCount;
	}

}
