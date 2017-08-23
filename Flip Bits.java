Determine the number of bits required to flip if you want to convert integer n to integer m.

 Notice

Both n and m are 32-bit integers.

Have you met this question in a real interview? Yes
Example
Given n = 31 (11111), m = 14 (01110), return 2.

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int count = 0;
        for(int i = 0; i < 32; i ++) {
            int bit1 = (a >> i) & 1;
            int bit2 = (b >> i) & 1;
            if((bit1 ^ bit2) == 1) {
                count ++;
            }
        }
        
        return count;
    }
};

/*
bit操作，求得数字中的每一位，拿出来进行比较
*/