class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null)  return false;
        
        int m = s.length();
        int n = t.length();
        if(Math.abs(m - n) > 1)    return false;
        
        for(int i = 0; i < Math.min(m, n); i ++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(m > n) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else if(m == n) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        
        return m != n; 
    }
}

/*
注意各种test case的处理，
不需要使用两个index分别在s和t内使用，只需要使用一个index i，
当在i位置的s和t的char不同的时候，根据他们的大小关系，进行对应的截取来比较。
*/