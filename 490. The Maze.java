public class Solution {
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        
        int[][] dir = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        boolean[][] visited = new boolean[m][n];
        Queue<Point> queue = new LinkedList<>();
        
        visited[start[0]][start[1]] = true;
        queue.offer(new Point(start[0], start[1]));
        
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            for(int i = 0; i < 4; i ++) {
                int xx = x;
                int yy = y;
                while(xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
                    xx += dir[i][0];
                    yy += dir[i][1];
                }
                xx -= dir[i][0];
                yy -= dir[i][1];
                if(visited[xx][yy]) continue;
                visited[xx][yy] = true;
                if(xx == destination[0] && yy == destination[1])    return true;
                queue.offer(new Point(xx, yy));
            }
        }
        
        return false;
    }
}

/*
这些单纯的DFS和BFS问题都不难，但是需要注意的限定条件很多 很复杂。
这题需要注意的就是不碰到墙壁，球不停止，
因此利用BFS解决的时候，在poll出一个point之后，球的位置需要在一个方向上一直改变知道碰壁，
其他的和普通的BFS没有区别，
注意xx -= dir[i][0]; yy -= dir[i][1];的操作，这样能获取一个正常的point位置
*/