/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        
        for(int i = 0; i < nums.length; i ++) {
            TreeNode node = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < node.val) {
                node.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = node;
            }
            stack.push(node);
        }
        
        TreeNode res = stack.pop();
        while(!stack.isEmpty()) {
            res = stack.pop();
        }
        
        return res;
    }
}

/*
和Lintcode的 Max Tree一样，使用stack单调栈解决。
*/