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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null)    return res;
        deque.push(root);
        TreeNode cur = root;
        TreeNode pre = null;
        while(!deque.isEmpty()) {
            cur = deque.peek();
            if(pre == null || pre.left == cur || pre.right == cur) {
                if(cur.left != null) {
                    deque.push(cur.left);
                } else if(cur.right != null) {
                    deque.push(cur.right);
                } 
            } else if(cur.left == pre) {
                if(cur.right != null)   deque.push(cur.right);
            } else {
                res.add(cur.val);
                deque.pop();
            }
            pre = cur;
        }
        return res;
    }
}

/*
利用pre，cur和stack共同处理得到postorder。

当cur为pre下方的node时，继续检查cur的left和right，按顺序加入，若cur没有left或right，则说明cur为叶子节点，直接pop，并加入res

当pre为cur的左子树left时，说明左子树已经全部处理结束，判断cur是否含有右子树right，若有则push，若没有，说明该cur没有右子树，该cur已经遍历结束，pop并加入res

当pre为cur的右子树rihgt时，说明该cur已经全部遍历，pop并加入res

将pre置为cur。

还有一种方法，就是将preorder的顺序进行改变，先push left，再push right，再将得到的list进行reverse得到postorder
*/