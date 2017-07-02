Given a 2D grid, each cell is either an house 1 or empty 0 (the number zero, one), 
find the place to build a post office, the distance that post office to all the house sum is smallest. 
Return the smallest distance. Return -1 if it is not possible.

 Notice

You can pass through house and empty.
You only build post office on an empty.
Have you met this question in a real interview? Yes
Example
Given a grid:

0 1 0 0
1 0 1 1
0 1 0 0
return 6. (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)

public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        
        List<Node> house = new ArrayList<>();
        List<Integer> xArr = new ArrayList<>();
        List<Integer> yArr = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
        int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
        
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == 1) {
                    house.add(new Node(i, j));
                    xArr.add(i);
                    yArr.add(j);
                }
            }
        }
        
        if(house.size() == m * n)   return -1;
        if(house.size() == 0)   return 0;
        
        int xMedian = findMed(xArr);
        int yMedian = findMed(yArr);
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(xMedian, yMedian));
        visited[xMedian][yMedian] = true;
        int min = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                Node cur = queue.poll();
                if(grid[cur.x][cur.y] == 0) {
                    min = Math.min(min, findDis(house, cur));
                }
                for(int j = 0; j < 8; j ++) {
                    int xx = cur.x + dx[j];
                    int yy = cur.y + dy[j];
                    if(xx < 0 || xx >= m || yy < 0 || yy >= n || visited[xx][yy])   continue;
                    queue.add(new Node(xx, yy));
                    visited[xx][yy] = true;
                }
            }
            
            if(min != Integer.MAX_VALUE)    return min;
        }
        
        return -1;
    }
    
    private int findMed(List<Integer> arr) {
        Collections.sort(arr);
        int size = arr.size();
        int median = arr.get(size / 2);
        if(size % 2 == 0) {
            median = (median + arr.get(size / 2 - 1)) / 2;
        }
        return median;
    }
    
    private int findDis(List<Node> house, Node cur) {
        int sum = 0;
        for(Node node: house) {
            sum += Math.abs(cur.x - node.x) + Math.abs(cur.y - node.y);
        }
        return sum;
    }
}

/*

首先找到所有房子的重心。
利用house的list存储所有house的位置，xaar的list存储house的横坐标，yarr的list存储house的纵坐标，
找所有房子x值的median和y值的median（如果是奇数个就是排序后取中间值，如果是偶数则取中间两个数再取平均值）即为重心。

然后用bfs来搜索。将重心加入queue中，然后开始一圈一圈（将出队的每个点周围八个点加入队中）向外找，
用的是和逐层遍历二叉树的类似的方法（即在每一层开始的时候记录一下本层的点的个数，然后一次出队这么多点即可将本层的点全部出队）。
每一圈结束时，返回该圈上的点作为post office能取的最小值，如果存在则停止搜索。
即如果存在可以作为post office的点，则外圈点到各个房子的距离一定不会比内圈点更优。
*/