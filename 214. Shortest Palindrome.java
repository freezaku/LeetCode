class Solution {
    public String shortestPalindrome(String s) {
        int left = 0;
        for(int right = s.length() - 1; right >= 0; right --) {
            if(s.charAt(left) == s.charAt(right)) {
                left ++;
            }
        }
        
        if(left == s.length())  return s;
        
        String suffix = s.substring(left);
        
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, left)) + suffix;
    }
}

/*
通过for循环，则[0,left)为可能的最长的palindrome，将其继续处理，
suffix部分reverse之后放在最前面，suffix放在最后。
*/