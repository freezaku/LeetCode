class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        
        int pos = map.get(val);
        if(pos != list.size() - 1) {
            int lastOne = list.get(list.size() - 1);
            map.put(lastOne, pos);
            list.set(pos, lastOne);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

/*
list中，remove是O(n)，但是remove最后一个是O(1)；

insert时，利用map存储当前的val和其在list中的位置，然后将该val也加入list中；

remove时，先利用map获取val在list中的位置pos，若其不是list的最后一个元素，
则将list中的最后一个元素，利用set操作，赋给位置为pos的数，
相当于就已经把val删除了，但是同时要更新map，把map中的val删去，
并加上lastone，pos的一组entry，同时，将list中最后一个元素删去。

getRandom只需要从list中任取一个即可。
*/