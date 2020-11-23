package bst;

import java.util.ArrayList;
import java.util.List;

public class ZigzagTraversalBinaryTree {

	static ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(7);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		zigzagTraversal(root);
		
		System.out.println(result);
	}

	private static void zigzagTraversal(TreeNode root) {
		
		levelOrderTraversal(root, 0);
	}
	
	private static void levelOrderTraversal(TreeNode root, int level) {
		
		if (root == null) {
			
			return;
		}
		
		try {
			
			result.get(level);
		}
		catch(Exception e) {
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			result.add(level, list);
			
		}
		
		result.get(level).add(root.val);
		
		levelOrderTraversal(root.left, level + 1);
		
		levelOrderTraversal(root.right, level + 1);
	}
}
