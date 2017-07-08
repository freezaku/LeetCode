public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        
        while(i < word.length() && j < abbr.length()) {

            if(word.charAt(i) == abbr.charAt(j)) {
                i ++;
                j ++;
                continue;
            }
            
            if(abbr.charAt(j) <= '0' || abbr.charAt(j) > '9')  return false;
            
            int start = j;
            while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                j ++;
            }

            int count = Integer.valueOf(abbr.substring(start, j));
            i += count;

        }
        
        if(i == word.length() && j == abbr.length()) {
            return true;
        } else {
            return false;
        }
    }
}

/*
利用两个pointer分别指示word和abbr的位置，遇到char进行比较，abbr遇到digit，计数跳过；
别的都很好想，就是一点需要注意，若abbr出现数字，且第一位是0，则直接返回false。
*/