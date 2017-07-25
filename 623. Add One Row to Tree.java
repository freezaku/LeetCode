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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        return helper(root, v, d, true);
    }
    
    private TreeNode helper(TreeNode root, int v, int d, boolean dir) {
        if(d == 1) {
            TreeNode node = new TreeNode(v);
            if(dir) {
                node.left = root;
            } else {
                node.right = root;
            }
            return node;
        }

        if(root == null)    return root;
        root.left = helper(root.left, v, d - 1, true);
        root.right = helper(root.right, v, d - 1, false);

        return root;
    }
}

/*
自己的做法，比较粗糙，
需要一个变量来track当前的root是其parent的left还是right，
这是选择在便利到d行的时候，才进行处理
*/

pubilc class Solution {
    private void dfs(TreeNode root, int depth, int v, int d) {
        if (root == null) return;
        if (depth < d-1) {
            dfs(root.left, depth+1, v, d);
            dfs(root.right, depth+1,v, d);
        } else {
            TreeNode tmp = root.left;
            root.left = new TreeNode(v);
            root.left.left = tmp;
            tmp = root.right;
            root.right = new TreeNode(v);
            root.right.right = tmp;
        }
    }
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newroot = new TreeNode(v);
            newroot.left = root;
            return newroot;
        }
        dfs(root, 1, v, d);
        return root;
    }
}

/*
discussion中的做法，在d - 1行就进行处理，
将原有的left和right加到新建的node的左右，不需要track左右
*/