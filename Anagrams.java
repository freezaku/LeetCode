public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<>();
        if(strs == null || strs.length == 0)    return res;
        
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] chrs = str.toCharArray();
            Arrays.sort(chrs);
            String tmp = String.valueOf(chrs);
            if(!map.containsKey(tmp)) {
                List<String> list = new ArrayList<>();
                map.put(tmp, list);
            }
            map.get(tmp).add(str);
        }
        
        for(String str: map.keySet()) {
            if(map.get(str).size() > 1) {
                res.addAll(map.get(str));
            }
        }
        
        return res;
    }
}

/*
ez
*/