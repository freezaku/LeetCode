public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)    return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0, j = 0; i < s.length(); i ++) {
            char chr = s.charAt(i);
            if(map.containsKey(chr)) {
                j = Math.max(j, map.get(chr) + 1);
            }
            map.put(chr, i);
            res = Math.max(res, i - j + 1);
        }
        
        return res;
    }
}