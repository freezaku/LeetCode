class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        while (i >= 0 || j >= 0) {
            int skip1 = 0, skip2 = 0;
            while (i >= 0) {
                // 注意这里是if条件，也就是对于每一个#都要进行一次backspace
                // 很可能有ab#c##，=> ""，而不是ab，等于是积累下来#，有char就backspace
                if (S.charAt(i) == '#') {
                    skip1++;
                    i--;
                } else if (S.charAt(i) != '#' && skip1>0) {
                    skip1--;
                    i--;
                } else {
                    break;
                }
            }
            
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skip2++;
                    j--;
                } else if (T.charAt(j) != '#' && skip2>0) {
                    skip2--;
                    j--;
                } else {
                    break;
                }   
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }
            if (i < 0 && j < 0) {
                return true;
            } else if (i < 0 || j < 0) {
                return false;
            }
            
            i--;j--;
        }
        return true;
    }

}
