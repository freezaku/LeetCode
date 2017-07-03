Given an integer array in the construct method, implement two methods query(start, end) and modify(index, value):

For query(start, end), return the sum from index start to index end in the given array.
For modify(index, value), modify the number in the given index to value
 Notice

We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.

Have you met this question in a real interview? Yes
Example
Given array A = [1,2,7,8,5].

query(0, 2), return 10.
modify(0, 4), change A[0] from 1 to 4.
query(0, 1), return 6.
modify(2, 1), change A[2] from 7 to 1.
query(2, 4), return 14.

public class Solution {
    /* you may need to use some attributes here */
    class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            left = null;
            right = null;
        }
    }
    
    public SegmentTreeNode build(int start, int end, int[] A) {
        if(start > end) {
            return null;
        }
        SegmentTreeNode newRoot = new SegmentTreeNode(start, end, 0);
        if(start != end) {
            int mid = (start + end) / 2;
            newRoot.left = build(start, mid, A);
            newRoot.right = build(mid + 1, end, A);
            newRoot.sum = newRoot.left.sum + newRoot.right.sum;
        } else {
            newRoot.sum = A[start];
        }
        return newRoot;
    }
    
    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        if(start == root.start && end == root.end) { // 相等 
             return root.sum;
        }
        
        int mid = (root.start + root.end) / 2;
        int leftsum = 0;
        int rightsum = 0;
        if(start <= mid) {
            if(end > mid) {
                leftsum = querySegmentTree(root.left, start, mid);
            } else {
                leftsum = querySegmentTree(root.left, start, end);
            }
        }
        
        if(end > mid) {
            if(start <= mid) {
                rightsum = querySegmentTree(root.right, mid + 1, end);
            } else {
                rightsum = querySegmentTree(root.right, start, end);
            }
        }
        
        return leftsum + rightsum;

    }
    
    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        if(root.start == index && root.end == index) {
            root.sum = value;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if(index >= root.start && index <= mid) {
            modifySegmentTree(root.left, index, value);
        }
        if(index <= root.end && index > mid) {
            modifySegmentTree(root.right, index, value);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    /**
     * @param A: An integer array
     */
     
    SegmentTreeNode root;
    
    public Solution(int[] A) {
        // write your code here
        root = build(0, A.length - 1, A);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return querySegmentTree(root, start, end);
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        // write your code here
        modifySegmentTree(root, index, value);
    }
}

/*
利用segmenttree解决，标准模式。
*/
