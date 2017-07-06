public class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        int res = 0;
        
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(picture[i][j] == 'B') {
                    rowCount[i] ++;
                    colCount[j] ++;
                }
            }
        }
        
        for(int i = 0; i < m; i ++) {
            if(rowCount[i] != 1)    continue;
            for(int j = 0; j < n; j ++) {
                if(picture[i][j] == 'B' && colCount[j] == 1) {
                    res ++;
                    break;
                }
            }
        }
        
        return res;
    }
}

/*
利用rowcount和colcount两个数组进行计数，计算再改行或该列出现的'B'的次数，
然后再次遍历picutre，当[i][j]处rowcount, colcount和char为'B'均满足时，计数 ++
*/