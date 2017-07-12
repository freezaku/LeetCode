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
    public TreeNode str2tree(String s) {
        if(s == null || s.length() == 0)    return null;
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++) {
            char chr = s.charAt(i);
            if(chr == ')') {
                stack.pop();
            } else if(Character.isDigit(chr) || chr == '-') {
                int start = i;
                i ++;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    i ++;
                } 
                TreeNode cur = new TreeNode(Integer.valueOf(s.substring(start, i)));
                i --;
                if(!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if(parent.left != null) {
                        parent.right = cur;
                    } else {
                        parent.left = cur;
                    }
                }
                stack.push(cur);
            }
        }
        return stack.peek();
    }
}

/*
很容易想到利用stack解决问题，但是对于stack的存储和记录方式需要多次尝试，
同时需要注意，我们同时将cur加到parent的children中 和 将cur加入到stack，
之后对于cur的操作，也会影响到parent中的cur，因此遇到 ')'直接pop就好，因为对于他的操作已经完成了
*/