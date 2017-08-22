class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here
        if(source == null || target == null)  return -1;
        if(target.length() == 0)    return 0;
        int m = source.length();
        int n = target.length();
        
        for(int i = 0; i <= m - n; i ++) {
            int j = 0;
            while(j < n && source.charAt(i + j) == target.charAt(j)) {
                j ++;
            }
            if(j == n) {
                return i;
            }
        }
        
        return -1;
    }
}

/*
two pointer简单问题
*/