class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        // check differece between each char
        for (String string : strings) {
            StringBuilder sb = new StringBuilder();
            for (int i=1; i < string.length(); i++) {
                int diff = string.charAt(i) - string.charAt(i-1);
                diff = diff >= 0 ? diff : 26 + diff;
                sb.append(diff);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(string);
        }
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        
        return res;
        
    }
}

/*
把每一个string内部的offerset求出来，变成一个string，存为key

注意string不一定是alphabet升序，所以有可能有负值，所以需要在diff < 0的时候+26
*/