public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0)    return res;
        
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] chrs = str.toCharArray();
            Arrays.sort(chrs);
            String strstr = String.valueOf(chrs);
            if(!map.containsKey(strstr)) {
                List<String> list = new ArrayList<>();
                map.put(strstr, list);
            }
            map.get(strstr).add(str);
        }
        
        for(String str: map.keySet()) {
            res.add(map.get(str));
        }
        
        return res;
    }
}

/*
简单题重做。
*/