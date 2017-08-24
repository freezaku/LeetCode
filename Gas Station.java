public class Solution {
    /*
     * @param gas: An array of integers
     * @param cost: An array of integers
     * @return: An integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        int tank = 0;
        int total = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i ++) {
            tank += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        
        return total >= 0 ? start : -1;
    }
}

/*
greedy思想。
确认两个原则：
1. 若total gas > total cost，说明能够完成一圈旅行；
2. 若从i出发，到j的时候，total gas < total cost，说明所有从i到j的点都无法到达j；
在这两点原则之下，我们使用greedy算法，
从后往前遍历，maintain两个变量，tank代表油箱内的油量，total代表总的total和cost的关系，
当tank < 0的时候，说明从该start开始的旅行，无法到达当前的i点，
将其置0，同时将start更新为i + 1，
最后根据total的正负来返回
*/