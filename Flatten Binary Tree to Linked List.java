Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.

 Notice

Dont forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

Have you met this question in a real interview? Yes
Example
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6

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
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null) {
            if(cur.left == null) {
                cur = cur.right;
            } else {
                prev = cur.left;
                while(prev.right != null) {
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
        }
    }
}
/*
最为直观的方法，画图找出规律，
当cur.left不为null的时候，将其存储为prev，
然后此时cur.right需要变成该prev沿right向下的最right元素，
然后将此prev安装到cur的right下面，将cur的left置为null
*/


public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if(root == null)    return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur.right != null)   stack.push(cur.right);
            if(cur.left != null)    stack.push(cur.left);
            if(!stack.isEmpty())    cur.right = stack.peek();
            cur.left = null;
        }
    }
}

/*
遇到这种tree相关且有关位置的问题，容易想到利用stack来解决，
按照preorder的方法，遍历数组，
但是注意检查在while循环中stack是否为empty，不为empty的时候，将cur.right进行重新构造，置为stack.peek，
需要注意的是，要将该cur的left置为null
*/

public class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}