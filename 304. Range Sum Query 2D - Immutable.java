public class NumMatrix {
    private int[][] sums;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return;
        int m = matrix.length;
        int n = matrix[0].length;
        sums = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int bottom = Math.max(row1, row2);
        int top = Math.min(row1, row2);
        int left = Math.min(col1, col2);
        int right = Math.max(col1, col2);
        
        return sums[bottom + 1][right + 1] - sums[bottom + 1][left] - sums[top][right + 1] + sums[top][left];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

/*
基本dp问题
*/