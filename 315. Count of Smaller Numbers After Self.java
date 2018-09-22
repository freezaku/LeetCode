1. binary search
本质和merge sort相同。从后往前排序，然后再看nums[i]插入的位置，就是有多少比他自己小的数字
https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76576/My-simple-AC-Java-Binary-Search-code?page=3

2. mergesort
利用了merge sort的特性
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];        // result collector
        int[][] pairs = new int[N][2]; // each pair is {num, originalIdx}
        for (int i = 0; i < N; i++) {
            pairs[i] = new int[]{nums[i], i};
        }
        mergeSort(pairs, res, 0, N - 1);
        // Arrays.asList could only apply on Integer[], not on int[]
        // Integer[] default to {null, null, null} not {0, 0, 0}
        return Arrays.stream(res).boxed().collect(Collectors.toList());  // int[] to List
    }
    
    private void mergeSort(int[][] pairs, int[] res, int lo, int hi) {
        // base case: make sure there are at least 2 elements
        if (lo >= hi) {
            return;
        }
        // general case:
        // 1. divide & conqure
        int mid = lo + (hi - lo) / 2;
        mergeSort(pairs, res, lo, mid);
        mergeSort(pairs, res, mid + 1, hi);
        // 2. combine
        int[][] left = Arrays.copyOfRange(pairs, lo, mid + 1);      // start=inclusive, end=exclusive
        int[][] right = Arrays.copyOfRange(pairs, mid + 1, hi + 1); // start=inclusive, end=exclusive
        for (int k = lo, i = 0, j = 0; k <= hi; k++) {
            if (j >= right.length || (i < left.length && left[i][0] <= right[j][0])) { // if equal, always pick left first
                res[left[i][1]] += j;
                pairs[k] = left[i++];
            } else {
                pairs[k] = right[j++];
            }
        }
    }
}

3. BST solution
https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76580/9ms-short-Java-BST-solution-get-answer-when-building-BST

    1) property: have **dup** and **left children node count**
    2) query: the result for nums[i] is the sum(dup+left children node count) of every turn right nodes (including start and end)
    -> 因为右 > 左，所以每次算每个点的smaller after itself的时候，只需要看他父节点的左侧的tree node size，还有他上面的
    3) update: 和bst一样update，每次向下插入node，因此会不断的更新root

public class Solution {
    class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s; // left children数目
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    // presum是当前点之前比他小的
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) { // 第一个点，后面没有数字，所以是0
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) { // dup++
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}