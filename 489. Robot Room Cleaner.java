/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    Set<String> visited;
    public void cleanRoom(Robot robot) {
        visited = new HashSet<>();
        dfs(robot, 0, 0, 0);
    }
    private void dfs(Robot robot, int i, int j, int cur_dir) {
        // 用虚拟的"i,j"来模拟整个room
        String tmp = i + "," + j;
        if (visited.contains(tmp)) {
            return;
        }
        robot.clean();
        visited.add(tmp);
        
        for (int k=0; k < 4; k++) {
            int x = i, y = j;
            if (robot.move()) {
                // 和dfs中选定下一个(x,y)是一样的
                if (cur_dir == 0) {
                    x = i-1;
                } else if (cur_dir == 90) {
                    y = j+1;
                } else if (cur_dir == 180) {
                    x = i+1; 
                } else if (cur_dir == 270) {
                    y = j-1;
                }
                // 选定下一个(x,y)之后进行dfs
                dfs(robot, x, y, cur_dir);

                // 然后把robot放回原位，比如原来是从A -> B, 现在就需要从B->Left->Left->move->right->right->A
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            // 换dfs的下一个方向，里面有个%360
            robot.turnRight();
            cur_dir += 90;
            cur_dir %= 360;
        }  
    }
}