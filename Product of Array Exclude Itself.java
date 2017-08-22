public class Solution {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        List<Long> res = new ArrayList<>();
        if(nums == null || nums.size() == 0)    return res;
        
        int n = nums.size();
        long[] leftProduct = new long[n];
        long[] rightProduct = new long[n];
        
        leftProduct[0] = nums.get(0);
        rightProduct[n - 1] = nums.get(n - 1);
        for(int i = 1; i < n; i ++) {
            leftProduct[i] = leftProduct[i - 1] * nums.get(i);
            rightProduct[n - i - 1] = rightProduct[n - i] * nums.get(n - i - 1);
        }
        
        for(int i = 0; i < n; i ++) {
            long left = (i - 1 < 0) ? 1 : leftProduct[i - 1];
            long right = (i + 1 >= n) ? 1 : rightProduct[i + 1];
            res.add(left * right);
        }
        
        return res;
    }
}

/*
利用array的偏移来解答，分别求出该index左右的积，相乘即可。
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i ++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int temp = 1;
        for(int i = nums.length - 2; i >= 0; i --) {
            temp = temp * nums[i + 1];
            res[i] *= temp;
        }
        return res;
    }
}

/*
一个数组解决，在第一次遍历时，跳过最后一个元素，将第0个置为1，则最后一个位置直接获得ans，
第二次遍历，从后往前，跳过第一个元素，用temp获得从后往前的积，与该位置res[i]相乘
*/