class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)    return true;
        
        String ss = s.toLowerCase();
        int left = 0;
        int right = ss.length() - 1;
        
        while(left <= right) {
            char chr1 = ss.charAt(left);
            char chr2 = ss.charAt(right);
            if(!Character.isLetterOrDigit(chr1)) {
                left ++;
                continue;
            }
            if(!Character.isLetterOrDigit(chr2)) {
                right --;
                continue;
            }
            
            if(chr1 != chr2) {
                return false;
            }
            
            left ++;
            right --;
        }
        
        return true;
    }
}

/*
简单题，注意两个方法

String: s.toLowerCase();

Character: Character.isLetterOrDigit(char);
*/