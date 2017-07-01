Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), 
return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.

 Notice

You can only put the bomb at an empty cell.

Have you met this question in a real interview? Yes
Example
Given a grid:

0 E 0 0
E 0 W E
0 E 0 0
return 3. (Placing a bomb at (1,1) kills 3 enemies)

public class Solution {
    /**
     * @param grid Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int[] cols = new int[n];
        int max = 0;
        int row = 0;
        
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == 'W')    continue;
                if(i == 0 || grid[i - 1][j] == 'W') {
                    cols[j] = countCol(grid, i, j);
                }
                if(j == 0 || grid[i][j - 1] == 'W') {
                    row = countRow(grid, i, j);
                }
                if(grid[i][j] == '0') {
                    max = Math.max(max, cols[j] + row);
                }
            }
        }
        
        return max;
    }
    
    private int countCol(char[][] grid, int i, int j) {
        int sum = 0;
        while(i < grid.length && grid[i][j] != 'W') {
            if(grid[i][j] == 'E')   sum ++;
            i ++;
        }
        return sum;
    }
    
    private int countRow(char[][] grid, int i, int j) {
        int sum = 0;
        while(j < grid[0].length && grid[i][j] != 'W') {
            if(grid[i][j] == 'E')   sum ++;
            j ++;
        }
        return sum;
    }
}

/*
不要把问题复杂化。
设置行和列的存储数组，根据当前的格子的位置，设置用来存储该行和列当前能bomb的敌人。
当i或j为0的时候，进行一个初始化计算。
当该格子的上方或左方有W的时候，则重新开始计数，直到再次遇到W为止。
row只需要维护一个变量，col需要维护一个数组。
*/