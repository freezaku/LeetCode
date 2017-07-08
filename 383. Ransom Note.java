public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[256];
        for(char chr: magazine.toCharArray()) {
            count[chr - 'a'] ++;
        }
        for(char chr: ransomNote.toCharArray()) {
            count[chr - 'a'] --;
            if(count[chr - 'a'] < 0)    return false;
        }
        return true;
    }
}

/*
ez
*/