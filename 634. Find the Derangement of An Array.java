public class Solution {
    public int findDerangement(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        long[] dp = new long[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for(int i = 3; i <= n; i ++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return (int)dp[n];
    }
}

/*
The Staggered formula is D(n) = (n-1) [D(n-2) + D(n-1)]：
For the k th element, it has k-1 positions and there are two possibilities for its position
1.It's not in the first element, so it's going to be the same thing as D(n - 1)
2.It's in the position of the first element,so there are two elements in the deranged position.
So it's going to be the same thing as D(n - 2)
so array[i] = (i - 1 + 1) * (array[i - 1] + array[i - 2])%1000000007 ;

dp[n]表示1-n共有n个数，都不存储在其位置上共有多少可能。
对于第i个数，将其加入到这前i - 1个数当中，有两种情况：
1. 将第i个数放在第k个数的位置，而第k个数不放在第i个数的位置，则为(i - 1) * dp[i - 1]
2. 将第i个数放在第k个数的位置，而第k个数也放在第i个数的位置，则为(i - 1) * dp[i - 2]
*/