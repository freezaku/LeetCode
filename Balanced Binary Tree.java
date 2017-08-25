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
    /*
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return (getDepth(root) != -1);
    }
    
    private int getDepth(TreeNode root) {
        if(root == null)    return 0;
        
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        
        if(left == -1 || right == -1)   return -1;
        if(Math.abs(left - right) > 1)  return -1;
        
        return Math.max(left, right) + 1;
    }
}

/*
利用-1作为错误条件来进行判断，免去了很多计算。
bottom-up提高运算效率
*/