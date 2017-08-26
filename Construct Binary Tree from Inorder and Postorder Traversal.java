/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 
 
public class Solution {
    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if(inorder == null || inorder.length == 0)  return null;
        
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd)  return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = -1;
        for(int i = inStart; i <= inEnd; i ++) {
            if(inorder[i] == postorder[postEnd]) {
                index = i;
                break;
            }
        }
        
        int size = inEnd - index;
        
        root.left = helper(inorder, inStart, index - 1, postorder, postStart, postEnd - size - 1);
        root.right = helper(inorder, index + 1, inEnd, postorder, postStart, postEnd - 1);
        
        return root;
    }
}

/*
使用一个例子能够更方便理解inorder和postorder在recursion中的index的变化，避免出错。
*/