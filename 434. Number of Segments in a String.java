public class Solution {
    public int countSegments(String s) {
        int i = 0;
        int count = 0;
        while(i < s.length()) {
            while(i < s.length() && s.charAt(i) == ' ')   i ++;
            if(i == s.length()) return count;
            while(i < s.length() && s.charAt(i) != ' ')   i ++;
            count ++;
        }
        return count;
    }
}

/*
挺蠢得题目，感觉也没哪家公司会出这么蠢得题
*/