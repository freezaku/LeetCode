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
    int row;
    int col;
    public List<List<String>> printTree(TreeNode root) {
        row = 0;
        col = findRowAndCol(root, 0);
        
        String[][] tree = new String[row][col];
        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j ++) {
                tree[i][j] = new String();
            }
        }
        
        helper(root, tree, 0, 0, col);
        
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < row; i ++) {
            List<String> list = new ArrayList<>();
            for(int j = 0; j < col; j ++) {
                list.add(tree[i][j]);
            }
            res.add(list);
        }
        
        return res;
    }
    
    private int findRowAndCol(TreeNode root, int depth) {
        if(depth >= row) {
            row = depth;
        }
        if(root == null)    return 0;
        
        int res = 1;
        int left = findRowAndCol(root.left, depth + 1);
        int right = findRowAndCol(root.right, depth + 1);
        res += Math.max(left, right) * 2;
        
        return res;
    }
    
    private void helper(TreeNode root, String[][] tree, int depth, int left, int right) {
        if(root == null)    return;
        
        int mid = (left + right) / 2;
        tree[depth][mid] = String.valueOf(root.val);
        
        helper(root.left, tree, depth + 1, left, mid);
        helper(root.right, tree, depth + 1, mid + 1, right);
    }
}

/*
思路很直接，先计算出需要多少行多少列构造string数组，
再利用divide and conquer来填充数组即可；
注意计算多少行多少列的时候使用一点技巧，获取的是max(left, right) * 2的值.
*/