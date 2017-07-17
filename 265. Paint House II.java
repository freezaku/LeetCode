public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0)   return 0;
        int min1 = -1;
        int min2 = -1;
        
        for(int i = 0; i < costs.length; i ++) {
            int last1 = min1;
            int last2 = min2;
            min1 = -1;
            min2 = -1;
            for(int j = 0; j < costs[i].length; j ++) {
                if(j != last1) {
                    costs[i][j] += (last1 < 0 ? 0 : costs[i - 1][last1]);
                } else {
                    costs[i][j] += (last2 < 0 ? 0 : costs[i - 1][last2]); 
                }
                
                if(min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                    System.out.println(min1 + " " + min2);
                } else if(min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        
        System.out.println(costs.length - 1 + " " + min1);
        return costs[costs.length - 1][min1];
    }
}

/*
因为此题中每个位置没有重复的costs，因此，维护两个变量，一个min1表示到前一个位置为止，
其中最小的costs的位置，min2表示第二小的costs，当当前的j与min1相同，即表示他们冲突的时候，用min2加上当前的costs变成新的costs。

这里面，将min1和min2置为-1，当其为-1时说明还没有开始遍历赋值，因此此时的costs[i][j]保留，即+0；

另一种方法是与except self array类似，
设立从上到下遍历找当前位置以上的最小值的数组right[k + 1]，和从下往上遍历找当前位置以下最小值的数组left[k + 1]，right[k] = max，left[0] = max，
获得当前行两种最小值，然后再将这两个数组进行合并，得到当前行，除了本位置以外的各个位置的最小值数组minexceptself；
然后更新mincosts数组为minexceptself[j] + costs[i][j]；
最后比较最后一竖行所有元素。
*/