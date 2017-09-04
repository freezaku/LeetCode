/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)    return res;
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        helper(res, sb, root);
        
        return res;
    }
    
    private void helper(List<String> res, StringBuilder sb, TreeNode root) {
       if(root.left == null && root.right == null) {
            res.add(new String(sb.toString()));
            return;
        }
        
        int len = sb.length();
        if(root.left != null) {
            sb.append("->").append(root.left.val);
            helper(res, sb, root.left);
            sb.setLength(len);
        }
        
        if(root.right != null) {
            sb.append("->").append(root.right.val);
            helper(res, sb, root.right);
            sb.setLength(len);
        }
    }
}

/*
注意针对root的left和right的各种情况进行判断。
*/