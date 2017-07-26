/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int weighted = 0;
        int unweighted = 0;
        
        while(!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for(NestedInteger item: nestedList) {
                if(item.isInteger()) {
                    unweighted += item.getInteger();
                } else {
                    nextLevel.addAll(item.getList());
                }
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        
        return weighted;
    }
}

/*
没有想到这个depth能转化为更简单的形式进行计算。
直接将本来就是integer的item加入unweighted中，然后每次计算weighted的时候都加上这个unweighted就行，
这样这些item就相当于计算了多次了。
这是利用level order traverse的方式进行的计算，每次都取出integer加入unweighted，
留下的list放入nextlevel进行下一层计算
*/