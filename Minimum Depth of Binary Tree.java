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
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if(root == null)    return 0;
        
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        
        if(root.left == null) {
            return 1 + rightDepth;
        } else if(root.right == null) {
            return 1 + leftDepth;
        } else {
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }
}

/*
注意分析情况，当left或right有一边为null的时候，这边不做考虑，返回另一边的minDepth
*/