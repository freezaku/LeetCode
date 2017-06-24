Given n kind of items with size Ai and value Vi( each item has an infinite number available) and a backpack with size m. 
What the maximum value can you put into the backpack?

 Notice

You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Have you met this question in a real interview? Yes
Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 15.

public class Solution {
    /**
     * @param A an integer array
     * @param V an integer array
     * @param m an integer
     * @return an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // Write your code here
        int[] dp = new int[m + 1];
        for(int i = 0; i < A.length; i ++) {
            for(int j = A[i]; j <= m; j ++) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }
        return dp[m];
    }
}

/*
跟II基本相似，但是这次可以取一个item多次，
这样我们将j从A[i]到m进行遍历，
这样一个item就可以取多次了，其他一样，
内层遍历j的时候从小到大遍历，这样物品可以重复选取。比如一开始在j的时候取了i，然后随着j的增大，在j'的时候又取了i，而恰好j = j' - A[i]，
在这种情况下i就被重复选取。如果从大往小遍历则所有物品只能取一次，所以II中是从大往小遍历。
*/