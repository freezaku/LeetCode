/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }
    
    private int helper(TreeNode root, int curSum, int target, Map<Integer, Integer> map) {
        if(root == null)    return 0;
        
        curSum += root.val;
        int res = map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        
        res += helper(root.left, curSum, target, map) + helper(root.right, curSum, target, map);
        map.put(curSum, map.getOrDefault(curSum, 1) - 1);
        return res;
    }
}

/*
Discussion中给出的最优解。
利用map来存储prefix的sum和其出现的次数，
在helper函数内，将curSum加上当前root的val，map表示当前root的prefix出现的次数，
curSum - target将会得到一个prefix，这个prefix和target组合能够成为curSum，
也就说明这个prefix和curSum之间的部分能够组成target，
记住在最后要将curSum的对应value - 1，防止重复计算
*/

public class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null)    return 0;
        helper(root, sum);
        return count;
    }
    
    private List<Integer> helper(TreeNode root, int sum) {
        List<Integer> res = new ArrayList<>();
        if(root == null)    return res;
        res.add(root.val);
        if(root.val == sum) {
            count ++;
        }
        if(root.left == null && root.right == null) {
            return res;
        }
        
        List<Integer> list1 = helper(root.left, sum);
        for(int value: list1) {
            if(root.val + value == sum) {
                count ++;
            }
            res.add(root.val + value);
        }
        
        List<Integer> list2 = helper(root.right, sum);
        for(int value: list2) {
            if(root.val + value == sum) {
                count ++;
            }
            res.add(root.val + value);
        }
        
        return res;
    }
}

/*
粗糙的DFS想法，速度很慢。
bottom-up，将当前root以下所有出现的和用list的形式获取，
然后和当前root.val组合看是否会出现结果，并且将这些结果再次放入list中返回
*/