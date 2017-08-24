class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int max = ~0;
        
        int tmp = 0;
        if(j == 31) {
            tmp = max;
        } else {
            // tmp = 00..00 10000000 -> 00..00 01111111
            tmp = (1 << (j + 1)) - 1;
        }
        
        // left = 11..11 10000000
        int left = max - tmp;
        // right = 00..00 100 -> 00..00 011
        int right = (1 << i) - 1;
        //mask = 11..11 000000 11
        int mask = left | right;
        
        // n & mask make n becomes 0 from i to j become 0, n -> 100 000000 00
        // m << i = 10011 00
        return (n & mask) | (m << i);
    }
}


/*
利用位操作将特定位数清零后再置为特定值
*/