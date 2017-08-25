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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if(preorder == null || preorder.length == 0)    return null;
        
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd)   return null;
        
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        
        int index = -1;
        for(int i = inStart; i <= inEnd; i ++) {
            if(inorder[i] == val) {
                index = i;
                break;
            }
        }
        
        int size = index - inStart;
        
        root.left = helper(preorder, preStart + 1, preEnd, inorder, inStart, index - 1);
        root.right = helper(preorder, preStart + size + 1, preEnd, inorder, index + 1, inEnd);
        
        return root;
        
    }
}

/*
注意preorder和inorder之间的对应关系，preorder的第一个prestart即为root，
在inorder中找到与root对应的index，则将原来的preorder分为左右两部分，
再recursion解决左右子树的情况。
*/