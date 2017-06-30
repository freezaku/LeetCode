public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int[][] res = new int[2][2];
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i+1][j+1] = matrix[i][j] + sum[i][j+1] + sum[i+1][j] - sum[i][j];
            }
        }
        
        for(int i1 = 0; i1 < m; i1 ++) {
            for(int i2 = i1 + 1; i2 <= m; i2 ++) {
                Map<Integer, Integer> map = new HashMap<>();
                for(int j = 0; j <= n; j ++) {
                    int diff = sum[i2][j] - sum[i1][j];
                    if(map.containsKey(diff)) {
                        res[0][0] = i1;
                        res[0][1] = map.get(diff);
                        res[1][0] = i2 - 1;
                        res[1][1] = j - 1;
                        return res;
                    }
                    map.put(diff, j);
                }
            }
        }
        
        return res;
    }
}

/*
这一题前面的内容都很容易想，构造一个二维sum数组，存储到该位置为止的sum，
但是后面不好想到，
遍历sum数组，选取两行i1和i2，
在选取了两行之后，对这两行进行处理找submatrix，
构造一个map，key是列数，value是两行之间的差，
从右往左遍历每一列，计算出两行到该列为止的差diff，
若diff存在于map中，说明在上一个获得该diff的列到该列之间，构成了一个sum为0的submatrix，
左上角为[i1, map.get(diff)]，右下角为[i2 - 1, j - 1]
*/