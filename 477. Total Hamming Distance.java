class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int n = nums.length;
        
        for(int i = 0; i < 32; i ++) {
            int bitCount = 0;
            for(int num: nums) {
                bitCount += ((num >> i) & 1);
            }
            res += bitCount * (n - bitCount);
        }
        
        return res;
    }
}

/*
基础bit问题，一位一位解决。
遍历nums的第i位，统计里面1的次数bit count，n - bit count为0出现的次数。
两者相乘得到在第i位，能够产生的hamming距离。
*/