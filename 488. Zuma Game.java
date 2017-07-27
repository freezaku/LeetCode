public class Solution {
    int maxCount = 6;
    public int findMinStep(String board, String hand) {
        int[] count = new int[26];
        for(char chr: hand.toCharArray()) {
            count[chr - 'A'] ++;
        }
        
        int res = dfs(board + "#", count);
        
        return res == maxCount ? -1 : res;
    }
    
    private int dfs(String s, int[] count) {
        s = removeConsecutive(s);
        if(s.equals("#"))   return 0;
        
        int rs = maxCount;
        int need = 0;
        
        for(int i = 0, j = 0; j < s.length(); j ++) {
            if(s.charAt(i) == s.charAt(j)) {
                continue;
            }
            need = 3 - (j - i);
            if(count[s.charAt(i) - 'A'] >= need) {
                count[s.charAt(i) - 'A'] -= need;
                rs = Math.min(rs, need + dfs(s.substring(0, i) + s.substring(j), count));
                count[s.charAt(i) - 'A'] += need;
            }
            i = j;
        }
        
        return rs;
    }
    
    private String removeConsecutive(String s) {
        for(int i = 0, j = 0; j < s.length(); j ++) {
            if(s.charAt(i) == s.charAt(j))  continue;
            if(j - i >= 3)  return removeConsecutive(s.substring(0, i) + s.substring(j));
            i = j;
        }
        return s;
    }
}

/*
简单的dfs，但是整个处理过程比较复杂。
利用count存储hand中的char和数量，然后进入dfs中。
在dfs中，每次都先利用removeConsecutive进行合并操作，舍弃已经包含的连续三个相同char，
然后对s进行遍历，每次都发现一个需要加入char的substring，获取need，从count中减去这些need，
进入下一层dfs，记得要和原来的res进行比较，need加上dfs
*/