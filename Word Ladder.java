public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if(start.length() != end.length())   return 0;
        if(dict == null || dict.size() == 0)    return 0;
        if(start.equals(end))   return 1;
        
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        
        beginSet.add(start);
        endSet.add(end);
        
        dict.remove(start);
        dict.remove(end);
        
        int step = 2;
        
        while(!beginSet.isEmpty()) {
            Set<String> nextLevel = new HashSet<>();
            for(String word: beginSet) {
                for(int i = 0; i < word.length(); i ++) {
                    char[] chrs = word.toCharArray();
                    for(char chr = 'a'; chr <= 'z'; chr ++) {
                        chrs[i] = chr;
                        String str = String.valueOf(chrs);
                        
                        if(endSet.contains(str))    return step;
                        
                        if(dict.contains(str)) {
                            nextLevel.add(str);
                            dict.remove(str);
                        }
                    }
                }
            }
            step ++;
            if(nextLevel.size() < endSet.size()) {
                beginSet = nextLevel;
            } else {
                beginSet = endSet;
                endSet = nextLevel;
            }
        }
        
        return 0;
    }
}

/*
利用beginset和endset分别存储已经获取的word，和待获取的word。
利用BFS来寻找beginset中的每一个word可能替代的word，若该word存在于dict中，则将其放入nextlevel中，
然后根据nextlevel和endset的相对关系来判定beginset怎么变化。
*/