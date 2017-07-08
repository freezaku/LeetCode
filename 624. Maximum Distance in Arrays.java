public class Solution {
    class Point {
        int val;
        int index;
        public Point(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
    public int maxDistance(List<List<Integer>> arrays) {
        if(arrays.size() <= 1)  return 0;
        Point max1 = new Point(Integer.MIN_VALUE, -1);
        Point max2 = new Point(Integer.MIN_VALUE, -1);
        Point min1 = new Point(Integer.MAX_VALUE, -1);
        Point min2 = new Point(Integer.MAX_VALUE, -1);
        
        for(int i = 0; i < arrays.size(); i ++) {
            List<Integer> array = arrays.get(i);
            int num2 = array.get(0);
            int num1 = array.get(array.size() - 1);
            if(num1 >= max1.val) {
                max2 = new Point(max1.val, max1.index);
                max1 = new Point(num1, i);
            } else if(num1 >= max2.val) {
                max2 = new Point(num1, i);
            }
            if(num2 <= min1.val) {
                min2 = new Point(min1.val, min1.index);
                min1 = new Point(num2, i);
            } else if(num2 <= min2.val) {
                min2 = new Point(num2, i);
            }
            
        }
        
        int res = 0;
        if(max1.index != min1.index) {
            res = Math.max(res, max1.val - min1.val);
        } else {
            if(max1.index != min2.index && min2.index != -1) {
                res = Math.max(res, max1.val - min2.val);
            }
            if(max2.index != min1.index && max2.index != -1) {
                res = Math.max(res, max2.val - min1.val);
            }
        }
        
        return res;
    }
}

/*
自己难以直视的愚蠢做法
*/

public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        
        for (int i = 1; i < arrays.size(); i++) {
            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));
            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        
        return result;
    }
}

/*
正确的做法
*/