class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colA = A[0].length;
        int colB = B[0].length;
        int[][] res = new int[rowA][colB];
        
        for(int i = 0; i < rowA; i ++) {
            for(int k = 0; k < colA; k ++) {
                if(A[i][k] == 0)    continue;
                for(int j = 0; j < colB; j ++) {
                    if(B[k][j] == 0)    continue;
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return res;
    }
}

/*
其实这题要注意的是矩阵相乘的方法:
res[i][j] += A[i][k] * B[k][j] ;
掌握遍历矩阵的方法，
for(int i = 0; i < rowA; i ++) {
    for(int j = 0; j < colB; j ++) {
        for(int k = 0; k < colA; k ++) {\
            res[i][j] += A[i][k] * B[k][j];
        }
    }
}
*/