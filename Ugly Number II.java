public class Solution {
    /*
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        
        for(int i = 1; i < n; i ++) {
            dp[i] = Math.min(dp[index2] * 2, Math.min(dp[index3] * 3, dp[index5] * 5));
            if(dp[i] == dp[index2] * 2) index2 ++;
            if(dp[i] == dp[index3] * 3) index3 ++;
            if(dp[i] == dp[index5] * 5) index5 ++;
        }
        
        return dp[n - 1];
    }
}

/*
这就是多链表Merge Sort的一个扩展题。
有三个链表，分别代表有2，3，5获得的ugly number，每次从这三个链表中取出头最小的那个，然后将取出的那个链表坐标向后推移一个，
对于任意一个ugly number - K, 2*K, 3*K, 和5*K都是ugly number，所以说新的ugly number都是从已有的ugly number上，通过与{2,3,5}相乘而产生的。
如果
Ugly Number:       1,         2,          3,           4,           5,           6,            8,         10,     ..............
那么               1*2      2*2        3*2         4*2         5*2         6*2         8*2        10*2  .............. *2
                   1*3      2*3        3*3         4*3         5*3         6*3         8*3        10*3  .............. *3
                    1*5      2*5        3*5         4*5         5*5         6*5         8*5        10*5  .............. *5
都是ugly number。只要不断把新产生的ugly number通过merge sort添加到原有的ugly number数组中就可以了，直到找到第N个。
*/