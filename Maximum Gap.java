Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Notice

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

Have you met this question in a real interview? Yes
Example
Given [1, 9, 2, 5], the sorted form of it is [1, 2, 5, 9], the maximum gap is between 5 and 9 = 4.

class Solution {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
        if(nums == null || nums.length < 2)    return 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int gap = (int)Math.ceil((double)(max - min) / (n - 1));
        
        int[] maxArr = new int[n - 1];
        int[] minArr = new int[n - 1];
        Arrays.fill(maxArr, Integer.MIN_VALUE);
        Arrays.fill(minArr, Integer.MAX_VALUE);
        
        for(int num: nums) {
            if(num == min || num == max)    continue;
            int index = (num - min) / gap;
            maxArr[index] = Math.max(maxArr[index], num);
            minArr[index] = Math.min(minArr[index], num);
        }
        
        int previous = min;
        int maxGap = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i ++) {
            if(maxArr[i] == Integer.MIN_VALUE || minArr[i] == Integer.MAX_VALUE)    continue;
            maxGap = Math.max(maxGap, minArr[i] - previous);
            previous = maxArr[i];
        }
        
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}

/*
相当于使用了bucket sort，
这个max gap肯定大于等于(int)Math.ceil((double)(max - min) / (n - 1))，将最大数减去最小数除以他们的间距数目，
构造maxarr和minarr数组，
遍历nums中的元素，判定该元素属于哪个bucket的范围， k-th bucket contains all numbers in [min + (k-1)gap, min + k*gap)，
然后将其分别存入maxarr和minarr，

再次遍历maxarr和minarr数组，
将第i个bucket的min和第i - 1个bucket的max做差进行比较，用maxgap来track比较

*/