public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int max = 0;
        
        for(int i = 0; i < s.length(); i ++) {
            while(j < s.length()) {
                char chr = s.charAt(j);
                if(map.size() == 2 && !map.containsKey(chr))    break;
                if(map.containsKey(chr)) {
                    map.put(chr, map.get(chr) + 1);
                } else {
                    map.put(chr, 1);
                }
                j ++;
            }
            max = Math.max(max, j - i);
            
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            if(map.get(s.charAt(i)) <= 0)   map.remove(s.charAt(i));
        }
        return max;
    }
}

/*
关键点在于终止条件的判断，
当map.size() == 0时候，还需要确认当时的j不在map中，这时候才能break，
同时，每次左移i的时候，将其对应数量--，同时当
*/