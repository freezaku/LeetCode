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
    TreeNode pre = null;
    int count = 1;
    int max = 0;
    
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> list) {
        if(root == null)    return;
        
        traverse(root.left, list);
        if(pre != null) {
            if(pre.val == root.val) {
                count ++;
            } else {
                count = 1;
            }
        }
        
        if(count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max){
            list.add(root.val);
        }
        
        pre = root;
        
        traverse(root.right, list);
    }
}

/*
利用O(1)的space解决，主要是利用了inorder-traverse.
全局变量count用来计数，max用来track出现次数最多的数，放入list中，
通过pre和当前root的比较来判断值是否已经改变更新，是否需要重置，
然后就是利用inorder的方法来遍历，
先左后右，由大到小
*/