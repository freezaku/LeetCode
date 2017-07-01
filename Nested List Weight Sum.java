Given a nested list of integers, return the sum of all integers in the list weighted by their depth. 
Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Have you met this question in a real interview? Yes
Example
Given the list [[1,1],2,[1,1]], return 10. (four 1 at depth 2, one 2 at depth 1, 4 * 1 * 2 + 1 * 2 * 1 = 10)
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 42 + 63 = 27)

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        return helper(nestedList, 1);
    }
    private int helper(List<NestedInteger> list, int depth) {
        int sum = 0;
        for(int i = 0; i < list.size(); i ++) {
            NestedInteger item = list.get(i);
            if(item.isInteger()) {
                sum += item.getInteger() * depth;
            } else {
                sum += helper(item.getList(), depth + 1);
            }
        }
        return sum;
    }
}

/*
很简单的题目，
重新构造helper函数，将depth作为参数传入即可
*/