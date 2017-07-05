public class TwoSum {
    Map<Integer, Integer> map;
    //List<Integer> list;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
        //list = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(!map.containsKey(number)) {
            map.put(number, 1);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int num = entry.getKey();
            int target = value - num;
            if(map.containsKey(target)) {
                if(target != num || map.get(target) >= 2)   return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

/*
利用map解决，注意遇到两个相同的数相加才能得到value的情况，这时需要判断该数的个数
*/