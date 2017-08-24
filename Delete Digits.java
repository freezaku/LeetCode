Given string A representative a positive integer which has N digits, 
remove any k digits of the number, the remaining digits are arranged according to the original order to become a new positive integer.

Find the smallest integer after remove k digits.

N <= 240 and k <= N,

Have you met this question in a real interview? Yes
Example
Given an integer A = "178542", k = 4

return a string "12"

public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if(A == null || A.length() == 0)  return "0";
        
        StringBuilder sb = new StringBuilder(A);
        for(int i = 0; i < k;i ++) {
            int n = sb.length();
            int j = 0;
            while(j < n - 1 && sb.charAt(j) <= sb.charAt(j + 1)) {
                j ++;
            }
            sb.delete(j, j + 1);
        }
        
        while(sb.length() > 0 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        
        return sb.toString();
    }
}

/*
greedy类别问题，关键在于找到规律，使能够获得的结果符合要求最小。
发现的规律是，找到第一个peak元素，即其左右两边的数都比他要小，将该元素删除即可，
此操作重复k次，即得到一个值，
同时需要注意该值可能前面有多个0，将这些0去除即可
*/