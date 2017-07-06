public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i ++) {
            res <<= 1;
            if((n & 1) == 1) {
                res += 1;
            }
            n >>= 1;
        }
        return res;
    }
}

/*
从低到高遍历n的每一位，若为1，则将res ++，通过 >> 来获取n的每一位；

res在处理之前，先将其 << 来把之前获得的数位放到高位，再根据res来处理，判断是否 ++，
相当于把低位不断放到了高位。

同时n每次均右移一位获取便于获取其低位元素
*/