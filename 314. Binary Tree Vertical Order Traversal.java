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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexes = new LinkedList<>();
        queue.offer(root);
        indexes.offer(0);
        int min = 0;
        int max = 0;

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int index = indexes.poll();

            if(!map.containsKey(index)) {
                map.put(index, new ArrayList<Integer>());
            }
            map.get(index).add(node.val);

            if(node.left != null) {
                queue.offer(node.left);
                indexes.offer(index - 1);
                min = Math.min(index - 1, min);
            }
            if(node.right != null) {
                queue.offer(node.right);
                indexes.offer(index + 1);
                max = Math.max(index + 1, max);
            }
        }

        for(int i = min; i <= max; i ++) {
            res.add(map.get(i));
        }
        return res;
    }
}

/*
因为此题要求从上到下按顺序排列，因此使用dfs无法完成，
有可能有个节点走到了很深的地方，因而先加入了list中，因此需要使用bfs + level order来完成，即queue的使用。

构建新的class tuple，存储结点的node和index，设root的index为0，左子树index - 1，右子树index + 1.
构建hashmap，key为位置，即index，value为该位置的list。
用min和max表示index的范围，每次有tuple进入的时候，进行判断更新。

如果map中已经含有了该index的list，则直接进行加入，否则，进行初始化之后push。
因为是level traversal，所以要对每个left和right都进行判断，不为null，就将其转化为tuple，存入queue。
最后将map中的list全部取出，按顺序放入res中。
*/