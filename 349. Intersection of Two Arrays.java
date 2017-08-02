public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums1) {
            set.add(num);
        }
        
        Set<Integer> duplicate = new HashSet<>();
        for(int num: nums2) {
            if(set.contains(num)) {
                duplicate.add(num);
            }
        }
        
        int[] res = new int[duplicate.size()];
        int index = 0;
        for(int num: duplicate) {
            res[index ++] = num;
        }
        
        return res;
    }
}

/*
利用两个set解决
*/