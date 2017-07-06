public class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        int m = picture.length;
        int n = picture[0].length;
        Map<String, Integer> map = new HashMap<>();
        int[] colCount = new int[n];
        
        for(int i = 0; i < m; i ++) {
            String key = scanRow(picture, i, N, colCount);
            if(key.length() != 0) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            } 
        }
        
        int res = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() == N) {
                for(int j = 0; j < n; j ++) {
                    if(entry.getKey().charAt(j) == 'B' && colCount[j] == N) {
                        res += N;
                    }
                }
            }
        }
        
        return res;
    }
    
    private String scanRow(char[][] picture, int row, int N, int[] colCount) {
        int n = picture[0].length;
        StringBuilder sb = new StringBuilder();
        int rowCount = 0;
        
        for(int i = 0; i < n; i ++) {
            if(picture[row][i] == 'B') {
                rowCount ++;
                colCount[i] ++;
            }
            sb.append(picture[row][i]);
        }
        
        if(rowCount == N)   return sb.toString();
        return "";
    }
}

/*
这题的思考方法比较特殊，
因为题目rule2的说明，所以利用map，key是某行组成的string，value是这个string出现的次数；

首先遍历每一行，对于每一行，利用scanrow函数进行遍历，
获取改行组成的string，同时也计算这一行出现的black的数目，而且将其存入每一列出现的black数目的数组中，
若改行有N的black，则满足rule1的一半条件，将其存入map；

然后遍历map，取出每个string，若该string对应的value是N，表示这个string出现了N次，满足rule2的要求，
遍历这个string的每个char，若该char为'B'且对应该列出现的'B'为N个，则说明这N个'B'是满足要求的，直接给res加上N
*/