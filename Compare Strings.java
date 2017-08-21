Compare two strings A and B, determine whether A contains all of the characters in B.

The characters in string A and B are all Upper Case letters.

 Notice

The characters of B in A are not necessary continuous or ordered.

Have you met this question in a real interview? Yes
Example
For A = "ABCD", B = "ACD", return true.

For A = "ABCD", B = "AABC", return false.

public class Solution {
    /*
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if(A.length() < B.length()) return false;
        
        int[] count = new int[26];
        for(int i = 0; i < A.length(); i ++) {
            count[A.charAt(i) - 'A'] ++;
        }
        for(int i = 0; i < B.length(); i ++) {
            count[B.charAt(i) - 'A'] --;
            if(count[B.charAt(i) - 'A'] < 0)    return false;
        }
        
        return true;
    }
}

/*
简单题
*/