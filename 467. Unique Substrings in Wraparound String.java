public class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int maxLength = 0;
        for(int i = 0; i < p.length(); i ++) {
            if(i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                maxLength ++;
            } else {
                maxLength = 1;
            }
            
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLength);
        }
        
        int sum = 0;
        for(int i = 0; i < count.length; i ++) {
            sum += count[i];
        }
        
        return sum;
    }
}

/*
跟413. Arithmetic Slices相似，那一题是求有相同公差的substring，
这一题求的是有连续情况出现的substring，
但是需要多考虑一个'az'的情况，
若出现连续的char，则将maxLength ++，并将其存入count中
*/