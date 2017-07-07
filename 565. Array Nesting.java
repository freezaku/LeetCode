public class Solution {
    public int arrayNesting(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int i = 0; i < nums.length; i ++) {
            int len = 0;
            int j = i;
            while(j < nums.length && !set.contains(j)) {
                len ++;
                set.add(j);
                j = nums[j];
            }
            res = Math.max(res, len);
        }
        return res;
    }
}

public class Solution {
    public int arrayNesting(int[] a) {
        int maxsize = 0;
        for (int i = 0; i < a.length; i++) {
            int size = 0;
            for (int k = i; a[k] >= 0; size++) {
                int ak = a[k];
                a[k] = -1; // mark a[k] as visited;
                k = ak;
            }
            maxsize = Integer.max(maxsize, size);
        }

        return maxsize;
    }
}

/*
遍历并记录已经访问的元素
*/