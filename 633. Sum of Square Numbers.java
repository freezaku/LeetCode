public class Solution {
    public boolean judgeSquareSum(int c) {
        long cc = (long)c;
        for(long i = 0; i * i <= cc; i ++) {
            long remain = c - i * i;
            if(remain < 0)   break;
            long j = (long)Math.sqrt(remain);
            if(j * j == remain) return true;
        }
        return false;
    }
}

/*
直接将a和b的范围缩小为0到i * i <= cc,
然后从中减去一个的平方，另一个sqrt时候看能否还原成原来的数即可，
感觉这种方法很暴力，说不清楚逻辑
*/