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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root != null)    deque.push(root);
        while(!deque.isEmpty()) {
            TreeNode node = deque.pop();
            res.add(node.val);
            if(node.right != null)  deque.push(node.right);
            if(node.left != null)   deque.push(node.left);
        }
        return res;
    }
}

/*
preorder使用stack来解决
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode parent;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)    return res;
        TreeNode cur = root;
        while(cur != null) {
            res.add(cur);
            if(cur.left == null) {
                cur = cur.left;
            } else if(cur.right == null) {
                cur = cur.right;
            } else {
                while(cur.parent != null && (cur.parent.right == null || cur == cur.parent.right)) {
                    cur = cur.parent;
                }
                if(cur.parent == null)  return res;
                cur = cur.parent.right;
            }
        }
        return res;
    }
}

/*
带parent类型的preorder的解决方法
*/