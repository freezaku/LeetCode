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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)    return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            cur = node.right;
        }
        
        return res;
    }
}

/*
preorder 直接用 stack;
inorder 用 stack + cur;
postorder 用 stack + cur + prev;

cur不为null时，将其加入到stack，并不断获取left的node，直到cur为null，说明此node为最left的一个node。
此时，将stack最上面的值pop出来作为node，其为当前cur的parent，加入到res中，cur=node.right，再次检查此node的right。
*/