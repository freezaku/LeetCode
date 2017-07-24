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
    public int closestValue(TreeNode root, double target) {
        if(root == null)    return root.val;
        
        double min = Math.abs(root.val - target);
        int res = root.val;
        
        while(root != null) {
            if(Math.abs(root.val - target) < min) {
                    min = Math.abs(root.val - target);
                    res = root.val;
            }
            if(root.val == target) {
                return root.val;
            } else if(root.val > target) {
                root = root.left;
            } else if(root.val < target) {
                root = root.right;
            }
        }
        
        return res;
    }
}

/*
iterative做法
*/

public int closestValue(TreeNode root, double target) {
    int a = root.val;
    TreeNode kid = target < a ? root.left : root.right;
    if (kid == null) return a;
    int b = closestValue(kid, target);
    return Math.abs(a - target) < Math.abs(b - target) ? a : b;
}

/*
discussion 中的recursive做法
*/