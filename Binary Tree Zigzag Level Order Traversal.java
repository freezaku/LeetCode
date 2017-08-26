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
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return res;
        
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)   queue.add(node.left);
                if(node.right != null)  queue.add(node.right);
            }
            if(!flag) {
                Collections.reverse(list);
            }
            res.add(list);
            flag = !flag;
        }
        
        return res;
    }
}

/*
简单题，利用flag表明应该从左往右还是从右往左，利用Collections.reverse()进行翻转
*/