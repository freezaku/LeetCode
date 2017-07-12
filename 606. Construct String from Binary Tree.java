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
    public String tree2str(TreeNode t) {
        if(t == null)   return "";
        if(t.left == null && t.right == null)   return String.valueOf(t.val);
        return t.val + helper(t.left, true) + helper(t.right, false);
    }
    
    private String helper(TreeNode node, boolean flag) {
        if(node == null) {
            if(flag) {
                return "()";
            } else {
                return "";
            }
        } else if(node.left == null && node.right == null) {
            return "(" + node.val + ")";
        } else {
            return "(" + node.val + helper(node.left, true) + helper(node.right, false) + ")";
        }
    }
}

/*
很简单的题目，很直观的迭代做法，但是还是试了很长时间，
多带入例子进行检验，将'('和')'放到对应的node外面
*/