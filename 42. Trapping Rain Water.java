public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 1) return 0;
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        int leftMax = height[left];
        int rightMax = height[right];
        
        while(left < right) {
            if(leftMax < rightMax) {
                if(left + 1 < n && leftMax > height[left + 1]) {
                    res += leftMax - height[left + 1];
                }
                left ++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                if(right - 1 >= 0 && rightMax > height[right - 1]) {
                    res += rightMax - height[right - 1];
                }
                right --;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        
        return res;
    }
}

/*
/*
完全没有思路的一题，注意理解和记忆。

木桶原理的算法版，最两边的板子形成一个木桶，由两块板子最低的那块决定水位。
每次都从两边最低的方向向里扫描。
因为 i,j 当前高度未必是当前左右两边最高高度，每次更新的时候要注意维护下。
*/
*/