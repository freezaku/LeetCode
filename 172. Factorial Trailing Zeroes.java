public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}

/*
计算的是n!里面的trailing 0 的数目，
而所有的结尾0都是由2 * 5得到的，
因为n!里面，5的数目远远多于2，因此就需要计算5的数量即可
*/