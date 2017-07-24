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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    
    private void helper(TreeNode root) {
        if(root == null)    return;
        helper(root.right);
        root.val = root.val + sum;
        sum = root.val;
        helper(root.left);
    }
}

/*
简直是傻了，只要设置一个全局变量就行了。
先处理right节点，因为这些都是比当前节点要大的，需要加上，
在处理完right节点之后，改变当前节点，并且将sum更新，再去处理left节点
*/