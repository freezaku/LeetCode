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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root) {
        if(root == null)    return 0;
        
        int leftLen = helper(root.left);
        int rightLen = helper(root.right);
        max = Math.max(max, leftLen + rightLen);
        
        return Math.max(leftLen, rightLen) + 1;
    }
}

/*
忘了和leetcode中哪一题相似。
用max来track最大值，
在helper函数中，返回的是包含当前节点且不拐弯的single path的长度。
*/