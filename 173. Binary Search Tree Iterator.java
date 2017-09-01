/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Deque<TreeNode> deque;
    public BSTIterator(TreeNode root) {
        deque = new LinkedList<>();
        addAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = deque.pop();
        TreeNode right = cur.right;
        addAll(right);
        return cur.val;
    }
    
    private void addAll(TreeNode root) {
        while(root != null) {
            deque.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

/*
对于这种题，一般需要利用一个helper函数解决。
每次调用next的时候，先存储结果，然后利用addAll进行操作，一般都是这种套路。
*/