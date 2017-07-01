Given an integer array, find a subarray where the sum of numbers is in a given interval. Your code should return the number of possible answers. (The element in the array should be positive)

Have you met this question in a real interview? Yes
Example
Given [1,2,3,4] and interval = [1,3], return 4. The possible answers are:

[0, 0]
[0, 1]
[1, 1]
[2, 2]

public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        int left = 0;
        int sum = 0;
        int res = 0;
        
        for(int i = 0; i < A.length; i ++) {
            sum += A[i];
            if(sum < start) {
                continue;
            } else if(sum > end) {
                while(sum > end && left <= i) {
                    sum -= A[left];
                    left ++;
                }
            }
            if(sum >= start && sum <= end){
                int tempLeft = left;
                int tempSum = sum;
                while(tempSum >= start && tempLeft <= i) {
                    res ++;
                    tempSum -= A[tempLeft];
                    tempLeft ++;
                }
            }
        }
        
        return res;
    }
}

/*
利用two pointer解决，
遍历数组A，每次将A[i]加到sum中，
判定sum的大小是否小于start，若小于，直接continue，因为此时既不在范围内，又不能从sum中减去A[left]，
是否大于end，若大于，从sum中不断减去A[left]，使之小于end为止，
然后再次进行判断，保存此时的left和sum，若在范围内则将res++，从tempsum中不断减去A[left]，同时将templeft向右推进
*/

public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        int n = A.length;
        int[] sums = new int[n + 1];
        for(int i = 1; i<= n; i ++) {
            sums[i] = sums[i - 1] + A[i - 1];
        }
        int count = 0;
        for(int i = 1; i <= n; i ++) {
            int value1 = sums[i] - start;
            int value2 = sums[i] - end;
            count += find(sums, value1 + 1) - find(sums, value2);
        }
        return count;
    }
    
    private int find(int[] sums, int value) {
        int n = sums.length;
        if(sums[n - 1] < value)    return n;
        int left = 0;
        int right = n - 1;
        int res = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(value <= sums[mid]) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid  + 1;
            }
        }
        return res;
    }
}

/*
非负整数 Subarray 相关题目的一个常用解法就是通过计算前缀和数组，然后利用二分搜索来找到目标。
在这里，类似的思路同样适用。
举个例子，假设给定一个目标区间[low, high]，当我们遍历到prefixSum[i]时，我们的搜索范围为prefixSum[0,i-1]，而搜索目标有两个：
argmin j (prefixSum[i]−prefixSum[j]≤high)
=> argmin j (prefixSum[i]−high<=prefixSum[j])

argmax k (prefixSum[i]−prefixSum[k]>=low)
=> argmax k(prefixSum[i]−low>=prefixSum[k])

分别为第一个大于或等于prefixSum[i] - high的位置，即最左边的位置，
以及最后一个小于或等于prefixSum[i] - low的位置，即最右边的位置。
看上去这是两种二分搜索，但这里有个小技巧，那就是把后一个条件稍稍修改，
变成第一个大于或等于prefixSum[i] - low + 1的位置，等效于我们把需要找的位置往后移了一位。
*/