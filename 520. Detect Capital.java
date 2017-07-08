public class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for(char chr: word.toCharArray()) {
            if(Character.isUpperCase(chr))  count ++;
        }
        if(count == 0 || count == word.length() || (count == 1 && Character.isUpperCase(word.charAt(0)))) {
            return true;
        } else {
            return false;
        }
    }
}

/*
自己想得方法太蠢了，这个直接计数的方法简单方便
*/