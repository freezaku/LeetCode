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
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)   queue.offer(node.left);
                if(node.right != null)  queue.offer(node.right);
            }
            res.add(list);
        }
        
        return res;
    }
}

/*
容易操作想到的queue做法
*/

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        dfs(rst, root, 0);
        return rst;
    }
    private void dfs(List<List<Integer>> rst, TreeNode root, int level){
        if(root == null) return;

        if(level >= rst.size()){
            rst.add(new ArrayList<Integer>());
        }
        
        rst.get(level).add(root.val);
        dfs(rst, root.left, level + 1);
        dfs(rst, root.right, level + 1);
    }
}