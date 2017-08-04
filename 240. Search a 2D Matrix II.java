public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while(row < m && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] > target) {
                col -= 1;
            } else {
                row += 1;
            }
        }
        
        return false;
    }
}

/*
简单题，选取四个顶点中的左下或者右上的作为起始点开始计算。
*/