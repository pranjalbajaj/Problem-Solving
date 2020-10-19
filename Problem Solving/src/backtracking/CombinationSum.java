/**
 * Given an array of distinct integers candidates and a target integer target, 
 * return a list of all unique combinations of candidates where the chosen numbers 
 * sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times. 
 * Two combinations are unique if the frequency of at least one of the chosen 
 * numbers is different.
 * 
 */

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		
		int[] candidates = {2,3,6,7};
		
		int target = 7;
		
		System.out.println(combinationSum(candidates, target));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		backtrack(candidates, target, 0, result, new ArrayList<Integer>());

		return result;
	}

	private static void backtrack(int[] candidates, int target, int start, List<List<Integer>> res,
			ArrayList<Integer> tmpList) {

		if (target < 0) {

			return;
		}

		if (target == 0) {

			res.add(new ArrayList<Integer>(tmpList));

			return;
		}

		for (int i = start; i < candidates.length; i++) {

			tmpList.add(candidates[i]);

			backtrack(candidates, target - candidates[i], i, res, tmpList);

			tmpList.remove(tmpList.size() - 1);

		}
	}

}
