package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOfArray {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3 };

		List<List<Integer>> res = getAllPossiblePermutations(nums);

		System.out.println(res);
	}

	public static List<List<Integer>> getAllPossiblePermutations(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		boolean[] visited = new boolean[nums.length];

		permutate(nums, result, new ArrayList<Integer>(), visited);

		return result;
	}

	private static void permutate(int[] nums, List<List<Integer>> result, ArrayList<Integer> al, boolean[] visited) {

		if (al.size() == nums.length) {

			result.add(new ArrayList<Integer>(al));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (visited[i])
				continue;

			al.add(nums[i]);
			visited[i] = true;

			permutate(nums, result, al, visited);
			al.remove(al.size() - 1);
			visited[i] = false;
		}
	}

}
