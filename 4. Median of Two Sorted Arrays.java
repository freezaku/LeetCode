public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if(len % 2 == 1) {
            return helper(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return (helper(nums1, 0, nums2, 0, len / 2) + helper(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
    }
    
    private double helper(int[] nums1, int A_start, int[] nums2, int B_start, int k) {
        if(nums1.length <= A_start) {
            return nums2[B_start + k - 1];
        }
        if(nums2.length <= B_start) {
            return nums1[A_start + k - 1];
        }
        
        if(k == 1)  return Math.min(nums1[A_start], nums2[B_start]);
        
        int A_key = A_start + k / 2 - 1 < nums1.length ? nums1[A_start + k / 2 - 1] : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < nums2.length ? nums2[B_start + k / 2 - 1] : Integer.MAX_VALUE;
        
        if(A_key < B_key) {
            return helper(nums1, A_start + k / 2, nums2, B_start, k - k / 2);
        } else {
            return helper(nums1, A_start, nums2, B_start + k / 2, k - k / 2);
        }
    }
}

/*
利用DC和Binary Search来解决。
对于两个数组，
若长度和是奇数，直接返回第len / 2 + 1个数，
若长度和是偶数，返回len / 2和len / 2 + 1的平均数。
对于helper函数，A_start和B_start代表A数组和B数组开始寻找的位置，k代表需要的得到是dik大的数，
如果A_start或者B_start超过了限定范围，直接返回另一个数组的第start + k - 1个，
若k == 1，直接返回A和B的最小值；
获得从nums1和nums2的k / 2 - 1的数，
根据比较的结果舍弃一部分。
*/