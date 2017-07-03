Given a string source and a string target, find the minimum window in source which will contain all the characters in target.

 Notice

If there is no such window in source that covers all characters in target, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.

Have you met this question in a real interview? Yes
Clarification
Should the characters in minimum window has the same order in target?

Not necessary.
Example
For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"

public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        Map<Character, Integer> map = new HashMap<>();
        for(char chr: target.toCharArray()) {
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }
        int len = Integer.MAX_VALUE;
        int count = target.length();
        String res = "";
        for(int i = 0, j = 0; i < source.length(); i ++) {
            while(j < source.length() && count > 0) {
                char chr = source.charAt(j);
                if(map.containsKey(chr)) {
                    map.put(chr, map.get(chr) - 1);
                    if(map.get(chr) >= 0) {
                        count --;
                    }
                }
                j ++;
            }
            System.out.println(i + " " + j);
            if(count == 0 && j - i < len) {
                len = j - i;
                res = source.substring(i, j);
            }
            char chrchr = source.charAt(i);
            if(map.containsKey(chrchr)) {
                map.put(chrchr, map.get(chrchr) + 1);
                if(map.get(chrchr) > 0) {
                   count ++; 
                }
            }
        }
        
        return res;
    }
}

/*
基本思路就是利用hashmap解决，但是需要注意各种细节，
用count来计算需要cover的char的数目，
遍历数组，当该chr在map中的时候，将其对应数目--，但是还需要注意的是当该数量>=0的时候，将count--，
而小于0的时候，说明这些char是无用的，
同时将i前移的时候，将对应char的数目++，而且需要注意，当++之后的数量>0的时候，将count++，
而小于0的时候，说明这些char是无用的，
*/