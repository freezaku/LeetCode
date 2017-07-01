Implement an iterator to flatten a 2d vector.

Have you met this question in a real interview? Yes
Example
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> iter1;
    Iterator<Integer> iter2;
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        if(vec2d != null) {
            iter1 = vec2d.iterator();
        }
        iter2 = null;
    }

    @Override
    public Integer next() {
        // Write your code here
        hasNext();
        return iter2.next();
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while(iter2 == null || !iter2.hasNext() && iter1.hasNext()) {
            iter2 = iter1.next().iterator();
        }
        return iter2 != null && iter2.hasNext();
    }
    
    @Override
    public void remove() {}
}

/*
用这题好好理解迭代器的概念。
i表示List<List>的迭代器，j表示List<Integer>的迭代器；

当j == null || !j.hasNext()的时候，说明j在此时要么没有被赋值，要么已经到达该list的尾部，
看此时的i是否有next，若有，将其next赋给j；
在这里使用while循环，因为即使j = i.next().iterator()，j依旧有可能为null；
最后判断，利用j != null && j.hasNext()判断j是否有next；
 */