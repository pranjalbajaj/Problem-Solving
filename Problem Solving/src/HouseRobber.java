import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

	public static void main(String[] args) {
		
		int[] nums = {2,3,2};
		
		System.out.println(rob1(nums));
		
		System.out.println(rob2(nums));
		
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(2, null, new TreeNode(3));
		
		root.right = new TreeNode(3, null, new TreeNode(1));
		
		long start = System.currentTimeMillis();
		
		System.out.println(rob3(root));
		
		System.out.println("Time for rob3 -> " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		
		System.out.println(rob3Memoized(root));
		
		System.out.println("Time for rob3Memoized -> " + (System.currentTimeMillis() - start));
		
	}
	
	/**
	 * House Robber 1
	 * 
	 * Houses are arranged in linear fashion and you cannot
	 * rob to adjacent houses.
	 * @param nums
	 * @return
	 */
	
	private static int rob1(int[] nums) {
		
		if (nums.length == 0) {
			
			return 0;
		}
		
		if (nums.length == 1) {
			
			return nums[0];
		}
		
		if (nums.length == 2) {
			
			return Math.max(nums[0], nums[1]);
		}
		
		int[] dp = new int[nums.length];
		
		dp[0] = nums[0];
		
		dp[1] = Math.max(nums[0], nums[1]);
		
		for (int i = 2; i < nums.length; i++) {
			
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		}
		
		return dp[nums.length - 1];
	}
	
	/**
	 *  House Robber 2
	 *  
	 *  Houses are arranged in a circular fashion, first house is the
	 *  neighbor of last house, you cannot rob two adjacent houses.
	 * @param nums
	 * @return
	 */
	
	private static int rob2(int[] nums) {
		
		if (nums.length == 0) {
			
			return 0;
		}
		
		if (nums.length == 1) {
			
			return nums[0];
		}
		
		if (nums.length == 2) {
			
			return Math.max(nums[0], nums[1]);
		}
		
		return Math.max(maxValue(nums, 0, nums.length - 2), maxValue(nums, 1, nums.length - 1));
	}
	
	private static int maxValue(int[] nums, int start, int end) {
		
		int[] dp = new int[end - start + 1];
		
		dp[0] = nums[start];
		
		dp[1] = Math.max(nums[start], nums[start + 1]);
		
		for (int i = start + 2; i <= end; i++) {
			
			dp[i - start] = Math.max(nums[i] + dp[i - start - 2], dp[i - start - 1]);
		}
		
		return dp[dp.length - 1];
	}
	
	/**
	 *  House Robber 3
	 *  
	 *  Houses are arranged in binary tree fashion, you cannot rob two
	 *  directly connected houses.
	 */
	
	private static int rob3(TreeNode root) {
		
		if (root == null)
			return 0;
		
		int result = 0;
		
		if (root.left != null)
			result+=rob3(root.left.left) + rob3(root.left.right);
		
		if (root.right != null)
			result+=rob3(root.right.left) + rob3(root.right.right);
		
		return Math.max(root.val + result, rob3(root.left) + rob3(root.right));
	}
	
	private static int rob3Memoized(TreeNode root) {
		
		Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

		if (root == null)
			return 0;
		
		if (map.containsKey(root))
			return map.get(root);

		int result = 0;

		if (root.left != null)
			result += rob3(root.left.left) + rob3(root.left.right);

		if (root.right != null)
			result += rob3(root.right.left) + rob3(root.right.right);

		map.put(root ,Math.max(root.val + result, rob3(root.left) + rob3(root.right)));
		
		return map.get(root);
	}
	
	static class TreeNode {
		
		int val;
		
		TreeNode left;
		
		TreeNode right;
		
		public TreeNode() {
			
		}
		
		public TreeNode(int val) {
			
			this.val = val;
		}
		
		public TreeNode(int val, TreeNode left, TreeNode right) {
			
			this.val = val;
			
			this.left = left;
			
			this.right = right;
		}
	}

}
