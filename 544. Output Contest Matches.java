public class Solution {
    public String findContestMatch(int n) {
        String[] strs = new String[n];
        for(int i = 0; i < n; i ++) {
            strs[i] = String.valueOf(i + 1);
        }
        
        while(n > 1) {
            for(int i = 0; i < n / 2; i ++) {
                strs[i] = "(" + strs[i] + "," + strs[n - 1 - i] + ")";
            }
            n /= 2;
        }
        
        return strs[0];
    }
}

/*
利用string数组存储所有的数字，
然后每次融合前后两个string并存储在前一个string的位置
*/