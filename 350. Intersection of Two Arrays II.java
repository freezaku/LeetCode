public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int num: nums2) {
            if(map.containsKey(num)) {
                if(map.get(num) >= 1) {
                    list.add(num);
                }
                map.put(num, map.get(num) - 1);
            }
        }
        
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i ++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}

/*
直观使用hashmap的做法
*/

/*
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
If both arrays are sorted, I would use two pointers to iterate, which somehow resembles the merge process in merge sort.

What if nums1's size is small compared to nums2's size? Which algorithm is better?
Suppose lengths of two arrays are N and M, the time complexity of my solution is O(N+M) and the space complexity if O(N) considering the hash. 
So it's better to use the smaller array to construct the counter hash.
Well, as we are calculating the intersection of two arrays, the order of array doesn't matter. We are totally free to swap to arrays.

What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.

An improvement can be sort them using external sort, read (let's say) 2G of each into memory and then using the 2 pointer technique, then read 2G more from the array that has been exhausted.
Repeat this until no more data to read from disk.
