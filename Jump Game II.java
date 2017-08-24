Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Have you met this question in a real interview? Yes
Example
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)


public class Solution {
    /*
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int count = 0;
        int index = 0;
        int n = A.length;
        while(index < n) {
            int dist = A[index];
            if(index + dist >= n - 1) {
                count ++;
                return count;
            }
            int nextStep = index;
            int nextIndex = index;
            for(int i = index + 1; i <= index + dist; i ++) {
                if(i + A[i] > nextStep) {
                    nextIndex = i;
                    nextStep = i + A[i];
                }
            }
            count ++;
            index = nextIndex;
        }
        
        return count;
    }
}

/*
自己的greedy粗糙做法
*/

public class Solution {
    /*
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int curEnd = 0;
        int farEnd = 0;
        int step = 0;
        for(int i = 0; i < A.length; i ++) {
            farEnd = Math.max(farEnd, i + A[i]);
            if(i == curEnd) {
                step ++;
                curEnd = farEnd;
                if(curEnd >= A.length - 1) {
                    return step;
                }
            }
        }
        
        return step;
    }
}

/*
精细的greedy做法。

当前的一次jump能够跳跃的范围是[curbegin, curend]，farend是能够到达的最远的地方，
因此，初始化为currend = 0， farend = 0，
然后遍历整个数组，farend不断更新为当前的最大值，
当i到达了curend的时候，说明在该范围内的数均已被探查，可以进行下一次jump，
将step++,同时判断新的current是否已经到达了末尾，若到达可以提前结束
*/

public class Solution {
    public int jump(int[] A) {
        // state
        int[] steps = new int[A.length];

        // initialize
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }

        // function
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                }
            }
        }
        
        // answer
        return steps[A.length - 1];
    }
}

/*
复杂度为 O(n^2)的dp解法，step[i]代表到达i位置，需要的最小跳跃数，
注意初始化为step[0] = 0，其他均为MAX_VALUE
*/