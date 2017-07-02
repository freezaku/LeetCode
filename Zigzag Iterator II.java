Follow up Zigzag Iterator: What if you are given k 1d vectors? How well can your code be extended to such cases? The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".

Have you met this question in a real interview? Yes
Example
Given k = 3 1d vectors:

[1,2,3]
[4,5,6,7]
[8,9]
Return [1,4,8,2,5,9,3,6,7].

public class ZigzagIterator2 {
    /**
     * @param vecs a list of 1d vectors
     */
    LinkedList<Iterator<Integer>> list;
    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        // initialize your data structure here.
        list = new LinkedList<>();
        for(ArrayList<Integer> vec: vecs) {
            if(!vec.isEmpty())  list.add(vec.iterator());
        }
    }

    public int next() {
        // Write your code here
        Iterator<Integer> iter = list.removeFirst();
        int res = iter.next();
        if(iter.hasNext())  list.add(iter);
        return res;
    }

    public boolean hasNext() {
        // Write your code here
        return !list.isEmpty();
    }
}

/*
跟I使用相同的方法，利用一个iterator的list来存储所有vec的iterator，
然后next()方法中，每次removefirst出来一个，返回这个的next()，
若其仍有next，则将其再次放回list中即可
*/