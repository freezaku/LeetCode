Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.

Find it.

 Notice

There is only one majority number in the array.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 1, 2, 1, 3, 3], return 1.

public class Solution {
    /*
     * @param nums: a list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int num1 = nums.get(0);
        int count1 = 0;
        int num2 = nums.get(0);
        int count2 = 0;
        
        for(int num: nums) {
            if(num1 == num) {
                count1 ++;
            } else if(num2 == num) {
                count2 ++;
            } else if(count1 == 0) {
                num1 = num;
                count1 ++;
            } else if(count2 == 0) {
                num2 = num;
                count2 ++;
            } else {
                count1 --;
                count2 --;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for(int num: nums) {
            if(num1 == num) {
                count1 ++;
            } else if(num2 == num) {
                count2 ++;
            }
        }
        
        return count1 > count2 ? num1 : num2;
    }
}

/*
利用已有的经典MOORE'S VOTING ALGORITHM解决。

注意各判定条件直接的顺序。
先判断num是否与当前的num1或num2相同；
再判断count1，count2是否为0；
若都不是，则将count1和count2都--。

最后再进行一次遍历，重新计算我们获得的num1和num2出现的次数，
题目说明必有一个答案，因此返回次数更多的即可。
*/