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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ||root == p || root == q)  return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null)   return root;
        if(left != null)    return left;
        if(right != null)   return right;
        return null;
    }
}

/*
1. 判断当前root是否为null或p或q，若满足一个，则说明无需继续寻找，返回当前root
2. left和right为迭代，分别将root.left和root.right设为新root，进行寻找
3. 根据left和right进行判断，若均不为null，说明p和q分别位于left和right，返回root；
	若有一个为null，另一个不为null，则说明p和q均位于不为null的那个中，返回该节点。
*/