class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        
        if(len % 2 == 1) {
            // 寻找nums1和nums2合在一起时的第len / 2 + 1个数
            return findMedian(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return (findMedian(nums1, 0, nums2, 0, len / 2) + findMedian(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
    }
    
    private double findMedian(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if(nums1.length <= start1) {
            // 返回nums2从start2开始的第k个数，其坐标为start2 + k - 1
            return nums2[start2 + k - 1];
        }
        if(nums2.length <= start2){
            // 返回nums2从start1开始的第k个数，其坐标为start1 + k - 1
            return nums1[start1 + k - 1];
        }
        
        if(k == 1) {
            // 若k为1的时候，则返回nums1和nums2合成时候的第1个数，即两者start的较小值
            return Math.min(nums1[start1], nums2[start2]);
        }
        
        // 获取nums1和nums2自start之后的第k / 2个数，其坐标为start + k / 2 - 1
        int key1 = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int key2 = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        
        // 关于k的变化，每次舍弃的是k / 2个数，因此新的k变为k - k / 2，不能直接变成k / 2
        if(key1 < key2) {
            return findMedian(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return findMedian(nums1, start1, nums2, start2 + k / 2, k - k / 2);
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