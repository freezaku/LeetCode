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
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if(root == null)	return 0;

        int left = Math.max(0, root.left);
        int right = Math.max(0, root.right);

        return Math.max(left, right) + root.val;
    }
}

/*
在Binary Tree Maximum Path Sum的基础上的简化，
因为不存在拐点和在tree中间截取路径的情况，
因此只需要利用function本身求出left和right分别对应的最大值即可，

但是需要注意的是left，right都需要跟0进行比较，
因为若left和right小于0的时候，root.val加上他们只会更小
*/