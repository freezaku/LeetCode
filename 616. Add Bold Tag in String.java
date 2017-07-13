public class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        
        for(int i = 0, end = 0; i < s.length(); i ++) {
            for(String word: dict) {
                if(s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            if(end > i) {
                bold[i] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i ++) {
            if(!bold[i]) {
                sb.append(s.charAt(i));
                continue;
            }
            int j = i;
            while(j < s.length() && bold[j]) {
                j ++;
            }
            sb.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }
        
        return sb.toString();
    }
}

/*
利用boolean数组存储该位置是否在bold中，
首先遍历string s，对于每个位置，再遍历一次dict，
利用startswith的方法，找出对于该位置，可能存在的最长的word的长度，用end这个变量来track，
若end>i，表明该位置再dict中可以找到，置为true，

重新遍历s，利用sb构造result，
当bold[i]为false的时候，表明不是bold，直接append，
否则，找到该位置持续的true，在其前后加上<b></b>后再append.
*/