public class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        
        for(int num: nums) {
            max = Math.max(max, num);
            sum += num;
        }
        
        if(m == 1)  return (int)sum;
        
        long left = max;
        long right = sum;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            if(isValid(mid, nums, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return (int)left;
    }
    
    private boolean isValid(long mid, int[] nums, int m) {
        int count = 1;
        int sum = 0;
        
        for(int num: nums) {
            sum += num;
            if(sum > mid) {
                count ++;
                sum = num;
                if(count > m) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

/*
没想到使用binary search的做法，将优化问题转化为判断问题，
不断获取可能的最小值，然后以这个最小值为标准，判断能不能将其分为m份
*/

public class Solution {
    public int splitArray(int[] nums, int m) {
        int L = nums.length;
        int[] S = new int[L + 1];
        S[0] = 0;
        for(int i = 0; i < L; i ++) {
            // S[i]表示前i个元素的和
            S[i + 1] = S[i] + nums[i];
        }
        
        int[] dp = new int[L];
        for(int i = 0; i < L; i ++) {
            // dp[i]表示从i到末尾的和，如dp[0]表示nums[0] + ... + nums[L - 1]的和
            dp[i] = S[L] - S[i];
        }
        
        for(int s = 1; s < m; s ++) {
            for(int i = 0; i < L - s; i ++) {
                dp[i] = Integer.MAX_VALUE;
                for(int j = i + 1; j <= L - s; j ++) {
                    // S[j] - S[i]表示从nums[i] + ... + nums[j - 1]的和
                    int t = Math.max(dp[j], S[j] - S[i]);
                    if(t <= dp[i]) {
                        dp[i] = t;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return dp[0];
    }
}

/*
dp[i]表示将nums[i] ... nums[L - 1]元素分为若干份的最小的最大值，
将nums[i] ... nums[L - 1]个元素分为s + 1份，因此要保持在i < L - s，即前面有i个元素，后面有L - i个元素，而这L - i > s才可以进行分割，
dp[i]可以由dp[j]得到，j从i + 1 到 L - s，表示将后L - j个元素分为s份，留一份表示从i到j，
因此这个j <= L - s，即后L - j个元素，正好分为s份是临界情况，
因此对于后i个元素分为s + 1份，我们能够得到的其中的最大值为t = max(dp[j], S[j] - S[i]),
若t <= dp[i]，则dp[i] = t，否则直接break，因为之后随着j的增大，S[j] - S[i]会更大，不会得到更小的S[i]；
dp[s,j] is the solution for splitting subarray n[j]...n[L-1] into s parts.
dp[s+1,i] = min{ max(dp[s,j], n[i]+...+n[j-1]) }, i+1 <= j <= L-s
*/