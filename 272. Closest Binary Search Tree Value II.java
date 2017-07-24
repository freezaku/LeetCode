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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        helper(res, root, target, k);
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode root, double target, int k) {
        if(root == null)    return;
        
        helper(res, root.left, target, k);
        
        if(res.size() < k) {
            res.add(root.val);
        } else {
            if(Math.abs(res.get(0) - target) > Math.abs(root.val - target)) {
                res.remove(0);
                res.add(root.val);
            } else {
                return;
            }
        }
        
        helper(res, root.right, target, k);
    }
}

/*
BST的灵魂是inorder遍历，因为其结果为sorted。
此题中，运行inorder traversal，先遍历左子树，将其结果加入res。
若res的size < k，说明还未达到要求，则将root也加入。
若  > k，则需要去除，
此时比较res的第一个，即最小的那个，若root比其更接近target，则将第一个删去，加入root.val，
若没有第一个接近，则说明已经找到了结果，因为root和其右子树只会离target更远，root和其右子树不需要，直接返回res。
若在这些工程中没有返回res，则继续遍历右子树
*/

/*
粗糙的原始想法，
inorder遍历整个tree放入list中，
从list中找到离target最近的数，
从该数的左右两边开始分别向两端扩展，直到找到满足条件的k个数为止
*/