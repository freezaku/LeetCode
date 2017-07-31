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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if(root == null)    return res;
        
        Map<String, Integer> map = new HashMap<>();
        helper(root, map, res);
        
        return res;
    }
    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if(root == null)    return "#";
        String str = root.val + "," + helper(root.left, map, res) + helper(root.right, map, res);
        System.out.println(str);
        map.put(str, map.getOrDefault(str, 0) + 1);
        if(map.get(str) == 2)    res.add(root);
        return str;
    }
}

/*
在contest一直没想到该怎么样处理这个TreeNode的比较问题，
想要重新构造TreeNode的equals然后利用hashmap来解决，彻底偏离了方向。
利用postorder traverse，将路劲转化为string的形式就能很好的处理，
首先中，然后利用helper进入下一层root的left和right，遇到null直接返回#.
需要注意的一点就是避免重复，因此只有到map.get(str) == 2的时候才加入.
*/