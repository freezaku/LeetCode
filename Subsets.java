public class Solution {
    
    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
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
            list.add(nums[i]);
            helper(res, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}

/*
backtraking简单题
*/