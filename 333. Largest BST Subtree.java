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
    class subTree {
        int size;
        int lower;
        int upper;
        public subTree(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    
    int max = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        if(root == null)    return 0;
        helper(root);
        return max;
    }
    
    private subTree helper(TreeNode root) {
        if(root == null) {
            return new subTree(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        subTree left = helper(root.left);
        subTree right = helper(root.right);
        
        if(left.size == - 1|| root.val <= left.upper || right.size == -1 || root.val >= right.lower) {
            return new subTree(-1, 0, 0);
        } else {
            max = Math.max(max, left.size + right.size + 1);
            return new subTree(left.size + right.size + 1, Math.min(root.val, left.lower), Math.max(root.val, right.upper));
        }
    
    }
}

/*
已经有了基本的思路，就是限定范围进行判断，但是还是差了那么一点。
利用自己构造的class来限定每个node的size和应该在的lower和upper，
对于null节点，返回size为0，而且需要使得其始终合适parent节点，因此lower为max_value, upper为min_value,
否则，继续处理left和right，
当left或right的size为-1的时候，说明在left和right中已经不符合BST条件了，直接返回subtree的size为-1.
同时，若当前root.val不在限定范围之内，也将其size置为-1，
若满足各种条件，则需要更新max，同时返回的subtree也对范围进行更新。
*/