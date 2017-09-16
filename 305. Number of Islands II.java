public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(positions == null || positions.length == 0 || positions[0].length == 0)  return res;
        int[] roots = new int[m * n];
        int count = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Arrays.fill(roots, -1);
        for(int[] p: positions) {
            int root = n * p[0] + p[1];
            roots[root] = root;
            count ++;
            for(int[] dir: dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int nb = x * n + y;
                if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1)   continue;
                int rootNB = find(roots, nb);
                if(root != rootNB) {
                    roots[root] = rootNB;
                    root = rootNB;
                    count --;
                }
            }
            res.add(count);
        }
        return res;
    }
    private int find(int[] roots, int id) {
        while(roots[id] != id) {
            id = roots[id];
        }
        return id;
    }
}