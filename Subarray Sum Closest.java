Given an integer array, find a subarray with sum closest to zero. 
Return the indexes of the first number and last number.

Have you met this question in a real interview? Yes
Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].


public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    class Pair {
        int sum;
        int index;
        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        } 
        int n = nums.length;
        if(n == 1) {
            res[0] = res[1] = 0;
            return res;
        }
        Pair[] sums = new Pair[n + 1];
        int prev = 0;
        sums[0] = new Pair(0, 0);
        for (int i = 1; i <= n; i++) {
            prev += nums[i - 1];
            sums[i] = new Pair(prev, i);
        }

        Arrays.sort(sums, new Comparator<Pair>() {
           public int compare(Pair a, Pair b) {
               return a.sum - b.sum;
           } 
        });
        
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (ans > sums[i].sum - sums[i-1].sum) {
                ans = sums[i].sum - sums[i-1].sum;
                int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }

        return res;
    }
}

/*
计算closet 0的subarray，就是计算两个presum之间的差，他们中间的部分离0最近，
我们想到的是将presum和对应的index作为pair，存入数组，
然后将sum进行sort，比较sort之后相邻两个pair之间的sum之差，
因为他们的差比起其他任意两个pair，必然最小，
同时需要注意，得出的两个pair，需要根据index重新排序，调整正确的start和end
*/
