Given an circular integer array (the next element of the last element is the first element), 
find a continuous subarray in it, where the sum of numbers is the biggest. 
Your code should return the index of the first number and the index of the last number.

If duplicate answers exist, return any of them.

Have you met this question in a real interview? Yes
Example
Give [3, 1, -100, -3, 4], return [4,1].

public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        int start = 0;
        int end = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int total = 0;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(0);
        for(int i = 0; i < A.length; i ++) {
            int num = A[i];
            total += num;
            if(sum < 0) {
                sum = num;
                start = i;
                end = i;
            } else {
                sum += num;
                end = i;
            }
            if(sum > max) {
                max = sum;
                res.set(0, start);
                res.set(1, end);
            }
        }
        
       sum = 0;
       start = 0;
       end = 0;
       for(int i = 0; i < A.length; i ++) {
            int num = A[i];
            if(sum > 0) {
                sum = num;
                start = i;
                end = i;
            } else {
                sum += num;
                end = i;
            }
            if(start == 0 && end == A.length - 1) continue;
            if(total - sum > max) {
                max = total - sum;
                res.set(0, end + 1);
                res.set(1, start - 1);
            }
        }
        return res;
    }
}

/*
最大数组的范围只有两种可能：1. [ i ~ j ]，2. [ i ~ N-1] + [ 0 ~ j ]. 
所以，只要分别找到两种情况的最大者，取这两个最大者中较大的即可。
1和Continuous Subarray Sum I相同。
2等价于找一个范围[j+1 ~i-1]，使得这个范围内的数组和最小。
从总的total中减去这么多跟原来的max进行比较，找最大和的[j+1 ~ i+1]范围即可。
*/