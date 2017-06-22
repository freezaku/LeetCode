Given n books( the page number of each book is the same) and an array of integer with size k means k people to copy the book and the i th integer is the time i th person to copy one book). 
You must distribute the continuous id books to one people to copy. 
(You can give book A[1],A[2] to one people, but you cannot give book A[1], A[3] to one people, because book A[1] and A[3] is not continuous.) 
Return the number of smallest minutes need to copy all the books.

Have you met this question in a real interview? Yes
Example
Given n = 4, array A = [3,2,4], .

Return 4( First person spends 3 minutes to copy book 1, Second person spends 4 minutes to copy book 2 and 3, Third person spends 4 minutes to copy book 4. )

public class Solution {
    /**
     * @param n: an integer
     * @param times: an array of integers
     * @return: an integer
     */
    public int copyBooksII(int n, int[] times) {
        // write your code here
        int k = times.length;
        int[][] dp = new int[2][n + 1];
        for(int i = 0; i <= n; i ++) {
            dp[0][i] = times[0] * i;
        }
        for(int i = 1; i < k; i ++) {
            for(int j = 1; j <= n; j ++) {
                int a = i % 2;
                int b = 1 - a;
                dp[a][j] = Integer.MAX_VALUE;
                for(int l = 0; l <= j; l ++) {
                    if(dp[b][j - l] > times[i] * l) {
                        dp[a][j] = Math.min(dp[a][j], dp[b][j - l]);
                    } else {
                        dp[a][j] = Math.min(dp[a][j], times[i] * l);
                        break;
                    }
                }
            }
        }
        return dp[(k - 1) % 2][n];
    }
}

public int copyBooksII2D(int n, int[] times) {
        int k = times.length;
        int[][] f = new int[k][n+1];
        for (int j = 0 ; j <= n; ++j) {
            f[0][j] = j * times[0];
        }
        for (int i = 1; i < k; ++i) {
            for (int j = 1; j <= n; ++j) {
                f[i][j] = Integer.MAX_VALUE;
                for (int l = 0; l <= j; ++l) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[i-1][j-l], times[i] * l));
                    if (f[i-1][j-l] <= times[i] * l) {
                        break;
                    }
                }
                
            }
        }
        return f[k-1][n];
    }
}

/*
f[i][j]表示前i+1个人处理前j本书所需要的最少时间，
首先进行初始化f[0][j]，即第一个人处理j本书所需要的不同的时间，
然后遍历i和j，
将我们所需要的当前的f[i][j]初始化为MAX_VALUE,
然后将另一个变量l从0到j进行变换，
f[i - 1][j - l]表示前i个人处理j - l本书所需要话费的时间，
剩下的l本书都交给第i + 1人解决，为times[i] * l的时间，
这两项工作同时进行，因此两项工作中花费时间更长的就是花费的总时间，
比较f[i][j]之后更新，

同时需要注意，
当f[i-1][j-l] <= times[i] * l的时候，接下来再增加j只会是times[i] * j增大，
此时f[i][j]也不会再更新，因此可以break

第一种做法减少了空间复杂度，
注意变化，a = 2 % i不断获取，b = 1 - a可以获得i - 1的值
*/