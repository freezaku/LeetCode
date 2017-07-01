Given an array of n * m matrix, and a moving matrix window (size k * k), 
move the window from top left to botton right at each iteration, find the maximum sum inside the window at each moving.
Return 0 if the answer does not exist.

Have you met this question in a real interview? Yes
Example
For matrix

[
  [1, 5, 3],
  [3, 2, 1],
  [4, 1, 9],
]
The moving window size k = 2. 
return 13.

At first the window is at the start of the array like this

[
  [|1, 5|, 3],
  [|3, 2|, 1],
  [4, 1, 9],
]
,get the sum 11;
then the window move one step forward.

[
  [1, |5, 3|],
  [3, |2, 1|],
  [4, 1, 9],
]
,get the sum 11;
then the window move one step forward again.

[
  [1, 5, 3],
  [|3, 2|, 1],
  [|4, 1|, 9],
]
,get the sum 10;
then the window move one step forward again.

[
  [1, 5, 3],
  [3, |2, 1|],
  [4, |1, 9|],
]
,get the sum 13;
SO finally, get the maximum from all the sum which is 13.''

public class Solution {
    /**
     * @param matrix an integer array of n * m matrix
     * @param k an integer
     * @return the maximum number
     */
    public int maxSlidingMatrix(int[][] matrix, int k) {
        // Write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        if(m < k || n < k)  return 0;
        int[][] sums = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                sums[i][j] = matrix[i - 1][j - 1] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = k; i <= m; i ++) {
            for(int j = k; j <= n; j ++) {
                int value = sums[i][j] - sums[i - k][j] - sums[i][j - k] + sums[i - k][j - k];
                max = Math.max(max, value);
            }
        }
        
        return max;
    }
}

/*
在原matrix的基础上构造新的sums数组，构造方法和以前做过的题目相同，
关键是之后使用的方法，在sums数组上，很容易得到制定空间大小的window的和，
利用max来track比较进行更新
*/