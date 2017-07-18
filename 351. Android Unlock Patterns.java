public class Solution {
    public int numberOfPatterns(int m, int n) {
        boolean[] visited = new boolean[10];
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[7][9] = skip[9][7] = 8;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = skip[2][8] = skip[8][2] = 5;
        
        int res = 0;
        for(int i = m; i <= n; i ++) {
            res += dfs(1, visited, skip, i - 1) * 4;
            res += dfs(2, visited, skip, i - 1) * 4;
            res += dfs(5, visited, skip, i - 1);
        }
        
        return res;
    }
    
    private int dfs(int cur, boolean[] visited, int[][] skip, int remain) {
        if(remain < -1) return 0;
        if(remain == 0) return 1;
        visited[cur] = true;
        int ans = 0;
        for(int i = 1; i <= 9; i ++) {
            if(!visited[i] && (skip[cur][i] == 0 || visited[skip[cur][i]])) {
                ans += dfs(i, visited, skip, remain - 1);
            }
        }
        visited[cur] = false;
        return ans;
    }
}

/*
这一题的关键在于确定所有的情况。
1，3，7，9属于一种个情况，2，4，6，8属于一种情况，5属于一种情况，
针对每一种情况，分别求出在该种情况下以该数字开始的可能性。
用skip的二维数组表示i和j之间的那个数字，visited表示该数字是否有访问过，remain表示剩余的长度，
在dfs函数中，限定范围为1到9，跟当前cur进行连接，符合要求额话，进入下一层dfs，注意visited的变化
*/