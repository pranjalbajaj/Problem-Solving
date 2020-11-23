package bst;

import java.util.Stack;

public class ValidateBST {

	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(5);
		
		node.left = new TreeNode(1);
		
		node.right = new TreeNode(4, new TreeNode(3), new TreeNode(6));
		
		System.out.println(isValidBST(node));

	}
	
	
	//driver method
	public static boolean isValidBST(TreeNode root) {
        
        //return validateRecursive(root, null, null);
		
		return validateIterative(root);
        
    }
    /**
     * Recursive approach
     * 
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @param left
     * @param right
     * @return
     */
    private static boolean validateRecursive(TreeNode root, Integer left, Integer right) {
        
        if (root == null) {
            
            return true;
        }
        else if (left != null && root.val <= left || right != null && root.val >= right) {
            
            return false;
        }
        else {
            
            return validateRecursive(root.left, left, root.val) && validateRecursive(root.right, root.val, right);
        }
    }
    
    /**
     * Iterative approach
     * 
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @param left
     * @param right
     * @return
     */
    private static boolean validateIterative(TreeNode root) {
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	
    	Integer prev = null;
    	
    	TreeNode curr = root;
    	
    	while (curr != null || !stack.isEmpty()) {
    		
    		if (curr != null) {
    			
    			stack.push(curr);
    			
    			curr = curr.left;
    		}
    		else {
    			
    			curr = stack.pop();
    			
    			if (prev != null && prev > curr.val)
    				return false;
    			
    			prev = curr.val;
    			
    			curr = curr.right;
    		}
    	}
    	
    	return true;
    }
}
