Given a 2D grid, each cell is either a wall 2, an house 1 or empty 0 (the number zero, one, two), find a place to build a post office so that the sum of the distance from the post office to all the houses is smallest.

Return the smallest sum of distance. Return -1 if it is not possible.

 Notice

You cannot pass through wall and house, but can pass through empty.
You only build post office on an empty.
Have you met this question in a real interview? Yes
Example
Given a grid:

0 1 0 0 0
1 0 0 2 1
0 1 0 0 0
return 8, You can build at (1,1). (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)

public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    class Node {
        int x;
        int y;
        int dis;
        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        
        List<Node> house = new ArrayList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    house.add(new Node(i, j, 0));
                }
            }
        }
        
        if(house.size() == m * n)   return -1;
        if(house.size() == 0)   return 0;
        
        int k = house.size();
        int[][][] distance = new int[m][n][k];
        
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                Arrays.fill(distance[i][j], Integer.MAX_VALUE);
            }
        }
        
        for(int i = 0; i < k; i ++) {
            findDis(house.get(i), i, grid, distance);
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == 0) {
                    int sum = 0;
                    for(int l = 0; l < k; l ++) {
                        if(distance[i][j][l] == Integer.MAX_VALUE) {
                            sum = Integer.MAX_VALUE;
                            break;
                        }
                        sum += distance[i][j][l];
                    }
                    min = Math.min(min, sum);
                }
            }
        }
        
        if(min == Integer.MAX_VALUE) {
            return -1;
        }
        
        return min;
    }
    
    private void findDis(Node node, int k, int[][] grid, int[][][] distance) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.x][node.y] = true;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                Node cur = queue.poll();
                for(int j = 0; j < 4; j ++) {
                    int xx = cur.x + dx[j];
                    int yy = cur.y + dy[j];
                    if(xx < 0 || xx >= m || yy < 0 || yy >= n || visited[xx][yy] || grid[xx][yy] != 0)  continue;
                    distance[xx][yy][k] = cur.dis + 1;
                    queue.add(new Node(xx, yy, cur.dis + 1));
                    visited[xx][yy] = true;
                }
            }
        }
    }
}

/*
参考Leecode 317. Shortest Distance from All Buildings.

这道题和I比较类似，但是因为不能穿过wall和house，所以必须用bfs的方法搜索最近距离，而不能直接计算几何距离。
将数组扫描一遍找到所有房子。
为每一个房子建立一个距离矩阵，计算该房子到所有0点的距离。即distance[i][j][k]为k房子到grid[i][j]上的点的距离。计算距离的时候用bfs搜索。
然后遍历图上所有为0的点，查询k张距离矩阵，将所有房子到该点的距离加起来即为在该点建邮局的距离总和。
若在查询过程中遇到某个点在某张距离矩阵上的值为无穷大，则说明该点无法到达该房子，直接停止搜索即可。
选其中距离最小的点即可。

但是这一题的各种做法，code较为复杂，需要格外注意，多加练习。
*/