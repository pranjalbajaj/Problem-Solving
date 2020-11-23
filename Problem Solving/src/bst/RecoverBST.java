package bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class RecoverBST {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(1);
		
		root.right = new TreeNode(4);
		
		root.right.left = new TreeNode(2);
		
		recoverTreeOpt(root);

	}
	
	/**
	 * Get the inorder traversal list and then recontruct the BST
	 * @param root
	 */
	public static void recoverTree(TreeNode root) {
        
        ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
        
        ArrayList<Integer> valueList = new ArrayList<Integer>();
        
        inorderTraversal(root, nodeList, valueList);
        
        Collections.sort(valueList);
        
        for (int i = 0; i < nodeList.size(); i++) {
            
            if (nodeList.get(i).val != valueList.get(i)) {
                
                nodeList.get(i).val = valueList.get(i);
            }
        }
        
    }
    
    private static void inorderTraversal(TreeNode root, ArrayList<TreeNode> nodeList, ArrayList<Integer> valueList) {
        
        if (root != null) {
            
            inorderTraversal(root.left, nodeList, valueList);
            
            valueList.add(root.val);
            
            nodeList.add(root);
            
            inorderTraversal(root.right, nodeList, valueList);
        }
    }
    
    private static void recoverTreeOpt(TreeNode root) {
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	
    	TreeNode first = null;
    	
    	TreeNode middle = null;
    	
    	TreeNode last = null;
    	
    	TreeNode prev = null;
    	
    	TreeNode curr = root;
    	
    	while (curr != null || !stack.isEmpty()) {
    		
    		if (curr != null) {
    			
    			stack.push(curr);
    			
    			curr = curr.left;
    		}
    		else {
    			
    			curr = stack.pop();
    			
    			if (prev != null && prev.val > curr.val) {
    				
    				if (first == null) {
    					
    					first = prev;
    					
    					middle = curr;
    				}
    				else {
    					
    					last = curr;
    				}
    			}
    			
    			prev = curr;
    			
    			curr = curr.right;
    		}
    	}
    	
    	if (first != null && last != null) {
    		
    		int temp = first.val;
    		
    		first.val = last.val;
    		
    		last.val = temp;
    	}
    	else if (first != null && middle != null) {
    		
    		int temp = first.val;
    		
    		first.val = middle.val;
    		
    		middle.val = temp;
    	}
    }

}
