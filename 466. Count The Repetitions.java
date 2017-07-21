public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int m = s1.length();
        int n = s2.length();
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        int s1Index = 0;
        int s2Index = 0;
        int s1Count = 0;
        int s2Count = 0;
        
        while(s1Count < n1) {
            if(array1[s1Index] == array2[s2Index]) {
                s2Index ++;
                if(s2Index == n) {
                    s2Index = 0;
                    s2Count ++;
                }
            }
            s1Index ++;
            if(s1Index == m) {
                s1Index = 0;
                s1Count ++;
            }
        }
        
        return s2Count / n2;
    }
}

/*
brute force
*/