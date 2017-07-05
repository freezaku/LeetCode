public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for(char chr: s.toCharArray()) {
            res = res * 26 + (chr - 'A' + 1);
        }
        return res;
    }
}

/*
so easy
*/