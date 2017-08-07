public class Solution {
    public double myPow(double x, int n) {
        if(x == 0)  return 0;
        if(n == 0)  return 1;
        
        if(n == Integer.MIN_VALUE) {
            n += 2;
        }
        
        if(n < 0) {
            n = -n;
            x = 1 / x;
        }
        
        if(n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x * x, n / 2);
        }
    }
}

/*
将x ^ n转化为x ^ (2) ^ (n / 2)，一种简单思路的DC，
需要注意两种特殊情况，
当n为负的时候，求的是 1 / x 的 -n；
当n为min_value的时候，-n依旧为min_value，此时将n += 2，既保持了符号，又比变了这种corner case
*/