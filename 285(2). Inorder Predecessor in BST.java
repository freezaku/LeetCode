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
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode pre = null;

        while(cur != null) {
            if(cur.val >= p.val) {
                cur = cur.left;
            } else {
                pre = cur;
                cur = cur.right;
            }
        }

        return pre
    }
}

/*
不带parent指针的写法。
对于cur.val >, =, < 的情况，分别进行分析，
判断何时需要存储pre节点，何时向左寻找，何时向右寻找
*/

class TreeNode {
    TreeNode parent;
    TreeNode left;
    TreeNode right;
}
public class Solution {
    // with parent
    public TreeNode nextSuccessor(TreeNode node) {
        if(node == null)    return node;

        if(node.left == null) {
            node = node.left;
            while(node.right != null) {
                node = node.right;
            }
            return node;
        }

        while(node.parent != null && node = node.parent.left) {
            node = node.parent;
        }
        if(node.parent == null) return null;
        node = node.parent;

        return node;
    }
}