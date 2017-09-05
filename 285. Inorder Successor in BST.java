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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)    return null;
        
        TreeNode pre = null;
        TreeNode cur = root;
        while(cur != null) {
            if(cur.val > p.val) {
                pre = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        
        return pre;
    }
}

/*
不带parent指针的写法。
画图分析：
当root.val > p.val的时候，向左拐，但是此时要用pre记录下当时的root；
当root.val < p.val的时候，向右拐，不必更新pre
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

        if(node.right != null) {
            node = node.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        }

        while(node.parent != null && node = node.parent.right) {
            node = node.parent;
        }
        if(node.parent == null)    return null;
        node = node.parent;

        return node;
    }
}

/*
带parent指针的做法。
若该node有right节点，说明可以直接找到结果并返回，
否则需要一直寻找其parent节点，直到parent节点为null，或者该node为parent的left节点为止
*/
