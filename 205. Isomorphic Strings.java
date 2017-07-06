public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())    return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i ++) {
            char chr1 = s.charAt(i);
            char chr2 = t.charAt(i);
            if(map1.containsKey(chr1) && map1.get(chr1) != chr2)    return false;
            if(map2.containsKey(chr2) && map2.get(chr2) != chr1)    return false;
            map1.put(chr1, chr2);
            map2.put(chr2, chr1);
        }
        return true;
    }
}

/*
这题考察的是，如何实现一个 “双向 one-to-one onto mapping (bijection)”，原
domain 是 String S 的字符集，目标 domain 是 String T 的字符集。不能出现 oneto-many
或者 many-to-one.
写一会儿很快就可以发现，一个 hashmap 是不够的，至少不够快。因为一个
hashmap 只能做一个方向的 mapping，不能高效反方向查找有没有出现 one-tomany
/ many-to-one 的情况。
*/