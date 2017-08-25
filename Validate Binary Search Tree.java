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
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null)    return true;
        
        if(min != null && root.val <= min)   return false;
        if(max != null && root.val >= max)   return false;
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}

/*
用min和max限制范围，
需要注意的是初始化min和max为null，这样能够防止MAX_VALUE和MIN_VALUE的corner case
*/

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
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null)    return true;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(pre != null && pre.val >= cur.val)   return false;
            pre = cur;
            cur = cur.right;
        }
        
        return true;
    }
}

/*
利用inorder方法做，但是这次需要加上pre方便验证，
按照正常的inorder步骤，但是每次从stack中pop出cur的时候，将cur与pre进行比较，
同时注意pre的更新，更新为当前pop出来的cur
*/