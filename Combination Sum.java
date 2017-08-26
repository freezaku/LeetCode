public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)    return res;
        
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), 0, candidates, target);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int start, int[] candidates, int target) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        } else if(target < 0) {
            return;
        }
        
        for(int i = start; i < candidates.length; i ++) {
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            helper(res, list, i, candidates, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}

/*
backtracking简单题。
注意这次可以使用一个元素多次，所以下一层recusion中start直接置为i即可，
同时注意防止重复list，跳过连续的重复元素即可
*/