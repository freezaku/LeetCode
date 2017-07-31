public class Solution {
    class Point {
        int x;
        int y;
        int dis;
        public Point(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        if(start[0] == destination[0] && start[1] == destination[1]) return 0;
        
        int[][] dir = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start[0], start[1], 0));
        
        int res = -1;
        
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int dis = point.dis;
            for(int i = 0; i < 4; i ++) {
                int xx = x;
                int yy = y;
                int disdis = dis;
                while(xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
                    xx += dir[i][0];
                    yy += dir[i][1];
                    disdis += 1;
                }
                xx -= dir[i][0];
                yy -= dir[i][1];
                disdis -= 1;
                
                if(disdis > dist[destination[0]][destination[1]])   continue;
                
                if(disdis < dist[xx][yy]) {
                    dist[xx][yy] = disdis;
                    queue.offer(new Point(xx, yy, disdis));
                }
            }
        }
        
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? - 1 : dist[destination[0]][destination[1]];
    }
}

/*
和maze的思路一致，但是这次需要做一些改变。
dist初始化为MAX_VALUE;
利用一个dist数组来存储每个位置到起点的距离，并且不断进行更新，
当得到的disdis已经大于最终我们需要的dist[destination[0]][destination[1]]时，直接continue，
而当disdis < dist[xx][yy]时，对dist[xx][yy]进行更新，并且将其Point放入queue；
最后对dist[destination[0]][destination[1]]的值进行判断，看是否找到了这样一条路径
*/