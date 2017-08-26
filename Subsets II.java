public class Solution {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null)    return res;
        
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), 0, nums);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int start, int[] nums) {
        res.add(new ArrayList<>(list));
        
        for(int i = start; i < nums.length; i ++) {
            if(i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            helper(res, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}

/*
简单的backtracking题。
注意对重复元素的处理，两种
(1)一开始就跳过重复元素
(2)在最后跳过重复元素

要求相同，第一位不能使用重复的，但是后几位可以重复。
*/