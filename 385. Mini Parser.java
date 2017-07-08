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
    public NestedInteger deserialize(String s) {
        if(s.length() == 0) return null;
        if(s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger cur = null;
        int left = 0;
        for(int right = 0; right < s.length(); right ++) {
            char chr = s.charAt(right);
            if(chr == '[') {
                if(cur != null) {
                    stack.push(cur);
                }
                cur = new NestedInteger();
                left = right + 1;
            } else if(chr == ']') {
                String num = s.substring(left, right);
                if(num.length() != 0) {
                    cur.add(new NestedInteger(Integer.valueOf(num)));
                }
                if(!stack.isEmpty()) {
                    NestedInteger temp = stack.pop();
                    temp.add(cur);
                    cur = temp;
                }
                left = right + 1;
            } else if(chr == ',') {
                if(s.charAt(right - 1) != ']') {
                    String num = s.substring(left, right);
                    cur.add(new NestedInteger(Integer.valueOf(num)));
                }
                left = right + 1;
            }
        }
        return cur;
    }
}

/*
能想到利用stack解决，但是具体怎样操作解决还是没弄通。
遍历s，遇到'['，表明开始了新的一段NestedInteger的构造，将原有的cur放入stack，并将其置为空，left更新为right + 1;
遇到']'，表明完成了一段num，需要开始构造，利用substring找到我们需要的num，
当num存在的时候，将他作为一段新的NestedInteger放入cur中，
若此时的stack中还有NestedInteger，则将其pop，并将cur add进去，并将cur更新为这个NestedInteger，更新left为right + 1；
若遇到','，且其前面一个不是']'，也表明需要开始构造，substring获得num，然后加入到cur，并更新left，但是此时不需要将cur置为空

If encounters '[', push current NestedInteger to stack and start a new one.
If encounters ']', end current NestedInteger and pop a NestedInteger from stack to continue.
If encounters ',', append a new number to curr NestedInteger, if this comma is not right after a brackets.
Update index l and r, where l shall point to the start of a integer substring, while r shall points to the end+1 of substring
*/