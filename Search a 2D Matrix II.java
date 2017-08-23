Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.
Have you met this question in a real interview? Yes
Example
Consider the following matrix:

[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
Given target = 3, return 2.

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        int sum = 0;
        while(row < m && col >= 0) {
            int num = matrix[row][col];
            if(num == target) {
                sum ++;
                row ++;
                col --;
            } else if(num > target) {
                col --;
            } else {
                row ++;
            }
        }
        
        return sum;
    }
}

/*
注意找到一个的时候，需要将row和col都进行改变
*/