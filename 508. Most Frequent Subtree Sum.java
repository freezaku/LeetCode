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
    int count = 0;
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        helper(root, map, res);
        
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i ++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
    
    private int helper(TreeNode root, Map<Integer, Integer> map, List<Integer> res) {
        if(root == null)    return 0;
        int sum = root.val;
        sum += helper(root.left, map, res) + helper(root.right, map, res);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    
        if(map.get(sum) > count) {
            count = map.get(sum);
            max = sum;
            res.clear();
            res.add(max);
        } else if(map.get(sum) == count){
            res.add(sum);
        }
        
        return sum;
    }
}

/*
跟Path Sum III的思路基本一致.
Bottom-up求每条路劲的sum，放入map中，
用count和max来track最大值相关信息，不断更新并放入res中
*/