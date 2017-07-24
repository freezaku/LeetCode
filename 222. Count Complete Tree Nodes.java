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
    public int countNodes(TreeNode root) {
        if(root == null)    return 0;
        
        TreeNode left = root;
        TreeNode right = root;
        int leftCount = 1;
        int rightCount = 1;
        
        while(left.left != null) {
            left = left.left;
            leftCount ++;
        }
        while(right.right != null) {
            right = right.right;
            rightCount ++;
        }
        
        if(leftCount == rightCount) {
            return (1 << leftCount) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}

/*
看似复杂的做法其实可能实施起来很简答。
对于当前的root，确定其代表的tree是不是一个perfect tree，
用left和right两个treenode一直向下并且计数，直到为null为止，
若left和right得到的count相等，说明为perfect tree，直接可以求解，
否则分为左右两个子树，继续运行求解
*/