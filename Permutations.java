class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null)    return res;
        
        boolean[] visited = new boolean[nums.length];
        helper(res, new ArrayList<Integer>(), visited, nums);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, boolean[] visited, int[] nums) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i ++) {
            if(visited[i])  continue;
            visited[i] = true;
            list.add(nums[i]);
            helper(res, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}


/*
简单backtracking解决。
利用visited数组来记录已经使用的元素
*/