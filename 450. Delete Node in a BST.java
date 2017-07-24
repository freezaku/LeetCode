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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)    return root;
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                int min = findMin(root.right);
                root.val = min;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
    
    private int findMin(TreeNode root) {
        int min = root.val;
        while(root.left != null) {
            root = root.left;
            min = root.val;
        }
        return min;
    }
}

/*
在bst内删去一个元素，就用大于该元素的最小值来代替这个元素即可。
所以这题根据当前root的大小，判断是进入left还是right继续寻找进行删除，
如果当前node就是key的话，根据他是否有left和right来返回，
若left和right均不为null，那么就用min替代当前root的val，然后将该min所在的node从root.right中寻找删去
*/