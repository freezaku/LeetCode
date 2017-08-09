public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)    return res;
        
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(list, res, nums, visited);
        return res;
    }
    private void helper(List<Integer> list, List<List<Integer>> res, int[] nums, boolean[] visited) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i ++) {
            if(visited[i])  continue;
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            list.add(nums[i]);
            helper(list, res, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}

/*
和46使用相同的思路，但是需要注意这里面可能出现重复的元素，
因此对nums进行排序的预先处理。
在加入时先判断是否出现了前一个数与当前数相等的情况，若相等，则直接跳过。
同时使用visited数组来记录当前数是否被使用。
*/