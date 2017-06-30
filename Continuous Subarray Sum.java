Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return anyone)

Have you met this question in a real interview? Yes
Example
Give [-3, 1, 3, -3, 4], return [1,4].

public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(0);
        int start = 0;
        int end = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i ++) {
            if(sum < 0) {
                sum = A[i];
                start = i;
                end = i;
            } else {
                sum += A[i];
                end = i;
            }
            if(sum > max) {
                max = sum;
                res.set(0, start);
                res.set(1, end);
            }
        }
        return res;
    }
}

/*
start和end用来track构成max的坐标，
sum用来不断变换获取可能的最大值，
max通过跟sum的比较来track最大值，
当sum小于0的时候，说明可以重新考虑构成新的sum，因此将sum重置为A[i],start和end都置为i，
而当sum大于0的时候，说明可以考虑继续这个max，将end置为i，
每进入一个数，都需要跟max进行一个比较，更新res
*/