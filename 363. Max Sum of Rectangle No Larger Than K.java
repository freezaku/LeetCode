public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sums = new int[m][n];
        
        sums[0][0] = matrix[0][0];
        for(int i = 1; i < m; i ++) {
            sums[i][0] = sums[i - 1][0] + matrix[i][0];
        }
        for(int j = 1; j < n; j ++) {
            sums[0][j] = sums[0][j - 1] + matrix[0][j];
        }
        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i][j];
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int r1 = 0; r1 < m; r1 ++) {
            for(int r2 = r1; r2 < m; r2 ++) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for(int c = 0; c < n; c ++) {
                    int area = sums[r2][c];
                    if(r1 > 0) {
                        area -= sums[r1 - 1][c];
                    }
                    Integer ceiling = set.ceiling(area - k);
                    if(ceiling != null) {
                        max = Math.max(max, area - ceiling);
                    }
                    set.add(area);
                }
            }
        }
        
        return max;
    }
}

/*
已经尽可能简化了过程，关于利用binary search的做法，不太能明白。
sums数组存储到[i, j]位置的的和，然后使用特殊的方法遍历sums。
r1代表上面一行，r2代表下面一行，他们之间就组成了一个区域，
c代表列，从左到右遍历，然后r2, r1 和 c就组成了一个更小的区域，
用treeset存储这个区域的面积，treeset初始化的时候，放入一个0，
每次获得这个区域的面积area，利用ceiling方法寻找 大于 area - k 的最小值ceiling，
这个值存储在treeset中，就表示r1，r2和之前一个更小的c围成的区域，
若存在这样的值，则我们获得了一个由r1, r2, c 和 更小的c切割成额一个区域，其面积为area - ceiling，
用max来track这个最大值，同时将该area加入到set中。

注意treeset中要先加入一个0，因为当我们放入的面积area小于k的时候，仍然可以获得一个为0的ceiling。
*/