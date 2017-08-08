public class Solution {
    int maxLen = 0;
    int lo = 0;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)    return "";
        
        for(int i = 0; i < s.length(); i ++) {
            extend(i, i, s);
            extend(i, i + 1, s);
        }
        
        return s.substring(lo, lo + maxLen);
    }
    
    private void extend(int left, int right, String s) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        if(right - left - 1 > maxLen) {
            maxLen = right - left - 1;
            lo = left + 1;
        }
    }
}

/*
基础DP问题重做，

这一题需要掌握的基本思想，就是从每个char向两边寻找，使用extendPalidrome(s, i, i)，若两边相等，则将头尾两pointer扩展；
或者从每两个char之间的空格向两边寻找，使用extendPalidrome(s, i, i + 1)。
需要注意的就是边界条件的控制，j必>=0，而k必须< s.length；
与此同时，求得的maxlen的长度为 k - j - 1，因为是当两边不等的时候得到的k和j的值，需要将其减去；进行substring为low 和 low + maxlen，需要仔细检查，带入test case测试。
*/