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
    public int rob(TreeNode root) {
        if(root == null)    return 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }
    
    private int helper(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null)    return 0;
        if(map.containsKey(root))   return map.get(root);
        
        int val = root.val;
        
        if(root.left != null) {
            val += helper(root.left.left, map) + helper(root.left.right, map);
        }
        if(root.right != null) {
            val += helper(root.right.left, map) + helper(root.right.right, map);
        }
        
        int max = Math.max(helper(root.left, map) + helper(root.right, map), val);
        map.put(root, max);
        
        return max;
    }
}

/*
利用map存储已经处理过的节点，防止多次处理，
分为两种情况，选用当前节点，和不选用当前节点
*/

g++ -o Tweet Tweet.cpp -lsocket -lnsl–lresolv
g++ -Wall -o Tweet Tweet.cpp -lsocket -lnsl -lresolv