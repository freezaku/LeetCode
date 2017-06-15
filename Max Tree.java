Question

Given an integer array with no duplicates. A max tree building on this array is defined as follow:
The root is the maximum number in the array The left subtree and right subtree are the max trees of the subarray divided by the root number. Construct the max tree by the given array.
Example Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:
    6
   / \
  5   3
 /   / \
2   0   1
Challenge O(n) time and memory.

public class Solution {
    public TreeNode maxTree(int[] A) {
    	if(A == null || A.length == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0; i < A.length; i ++) {
            TreeNode node = new TreeNode(A[i]);
            while(!stack.isEmpty() && stack.peek().val < node.val) {
                node.left = stack.peek();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = node;
            }
            stack.push(node);
        }
        TreeNode res = stack.pop();
        while(!stack.isEmpty()) {
            res = stack.pop();
        }
        return res;
    }
}

/*
利用单调栈的思想来解决，保持一个单调减的stack，
在stack中存储treenode，遍历数组，
当遇到的数大于stack.peek()的时候，
说明该数应当在该peek的上面，
不断pop，直到stack为空或者stack.peek更大为止，
因为我们maintain的是一个单调递减的stack，
因此最后一个pop出来的treenode的root，就是最接近当前当前node的，
将该root作为当前node的left加入到node中，
若此时stack不为空，则此时的stack.peek大于node且最接近node的值，
所以将当前的node加入到peek的root的right上面去。

需要注意两个技巧：
1. 将最后pop出的root作为当前node的left，
我们可以不断将node.left置为pop出来的root，直到不能pop为止，
这样就能保证node.left是最后pop出来root；

2. 最后的答案，是stack的最底层的node，因为我们从未将其pop，
而是不断将新的node加到他上面去，所以将res不断置为stack中pop出来的值，
直到stack为空为止。
*/