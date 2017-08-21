Write a method anagram(s,t) to decide if two strings are anagrams or not.

Have you met this question in a real interview? Yes
Clarification
What is Anagram?
- Two strings are anagram if they can be the same after change the order of characters.

Example
Given s = "abcd", t = "dcab", return true.
Given s = "ab", t = "ab", return true.
Given s = "ab", t = "ac", return false.

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if(s.length() != t.length())    return false;
        
        int n = s.length();
        int[] count = new int[128];
        int numOfSpace = 0;
        for(int i = 0; i < n; i ++) {
            count[s.charAt(i)] ++;
            count[t.charAt(i)] --;
        }
        
        for(int i = 0; i < 128; i ++) {
            if(count[i] != 0)   return false;
        }
        
        return true;
    }
}

/*
简单题，注意这个string中可能含有非字母的char，所以应当使用更大的count数组
*/