public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0)    return res;
        
        Map<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int len = words[0].length();
        int sumLen = len * words.length;
        
        for(int i = 0; i <= s.length() - sumLen; i ++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for(int j = 0; j < words.length; j ++) {
                int left = i + j * len;
                int right = i + (j + 1) * len;
                String word = s.substring(left, right);
                if(!copy.containsKey(word)) break;
                int count = copy.get(word);
                if(count == 1) {
                    copy.remove(word);
                } else {
                    copy.put(word, count - 1);
                }
            }
            if(copy.isEmpty()) {
                res.add(i);
            }
        }
        
        return res;
    }
}

/*
过程复杂，但是思路简单的题。

将所有的words内的word放入map中，key为word，value为出现的次数。

遍历s，其实相当于切割，i表示此次遍历的开头地址，
j相当于words中的每一个word，利用substring切下来每一个s中的单词，
看是否在map中，若在的话，将其count - 1，count为0的时候，就把这个给去了，
最后若map能为空，则将i加到res中。
若中间出现不在map中的情况，直接break，进入新的i。
*/