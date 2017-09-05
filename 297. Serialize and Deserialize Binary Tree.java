/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)    return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                TreeNode cur = queue.poll();
                if(cur == null) {
                    sb.append("# ");
                } else {
                    sb.append(cur.val + " ");
                    queue.add(cur.left);
                    queue.add(cur.right);
                }   
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)  return null;
        
        String[] strs = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        for(int i = 1; i < strs.length; i ++) {
            int size = queue.size();
            for(int j = 0; j < size; j ++) {
                TreeNode parent = queue.poll();
                if(!strs[i].equals("#")) {
                    TreeNode left = new TreeNode(Integer.valueOf(strs[i]));
                    parent.left = left;
                    queue.add(left);
                }
                i ++;
                if(!strs[i].equals("#")) {
                    TreeNode right = new TreeNode(Integer.valueOf(strs[i]));
                    parent.right = right;
                    queue.add(right);
                }   
                if(j != size - 1) {
                    i ++;
                }
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

/*
标准BFS遍历解答。
注意在deserialize中，第二层循环内，当j != size - 1的时候，i进行++，否则会出现越界的情况
*/