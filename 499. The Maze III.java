public class Solution {
    class Point implements Comparable<Point> {
        int x;
        int y;
        int dis;
        String path;
        public Point(int x, int y, int dis, String path) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.path = path;
        }
        public int compareTo(Point p) {
            return dis == p.dis ? path.compareTo(p.path) : dis - p.dis;
        }
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if(maze == null || maze.length == 0 || maze[0].length == 0) return "";
        if(ball[0] == hole[0] && ball[1] == hole[1])    return "";
        int m = maze.length;
        int n = maze[0].length;
        
        Point[][] points = new Point[m][n];
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                points[i][j] = new Point(i, j, Integer.MAX_VALUE, "");
            }
        }
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        String[] ds=new String[] {"u", "r", "d", "l"};
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(ball[0], ball[1], 0, ""));
        
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int dis = point.dis;
            String str = point.path;
            if(points[x][y].compareTo(point) <= 0)  continue;
            points[x][y] = point;
            for(int i = 0; i < 4; i ++) {
                int xx = x;
                int yy = y;
                int disdis = dis;
                while(xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0 && !(xx == hole[0] && yy == hole[1])) {
                    xx += dir[i][0];
                    yy += dir[i][1];
                    disdis += 1;
                }
                if(!(xx == hole[0] && yy == hole[1])) {
                    xx -= dir[i][0];
                    yy -= dir[i][1];
                    disdis -= 1;
                }
                queue.offer(new Point(xx, yy, disdis, str + ds[i]));
            }
        }
        
        return points[hole[0]][hole[1]].dis == Integer.MAX_VALUE ? "impossible" : points[hole[0]][hole[1]].path;
    }
}

/*
相比MAZE II，加了两个条件：
1. 记录路径
2. 不一定是遇到墙才停下来，到达destination也会停下来
因此需要对我们定义的Point进行处理，将其implements Comparable，
加上compareTo的方法，在dis的基础上比较path。
利用prorityqueue来存储point，同时利用一个points数组来存储每个位置的最小path，
每次将poll出来的point与points中对应位置的数值进行比较，若已经大于，直接continue，
否则继续进行处理位置
*/