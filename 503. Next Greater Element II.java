public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if(n == 0)  return res;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n * 2; i ++) {
            int num = nums[i % n];
            while(!stack.isEmpty() && num > nums[stack.peek()]) {
                map.put(stack.pop(), num);
            }
            stack.push(i % n);
        }
        for(int i = 0; i < n; i ++) {
            if(map.containsKey(i)) {
                res[i] = map.get(i);
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}

/*
最初的做法，沿袭了I的做法，使用stack和map解决，但是这次stack中存储的是index，这样方便计算，
map中也是存储index和对应额Next greater element
对于这种有circular的描述，直接使用“重复”的方法进行计算，相当于遍历数组两遍
*/

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if(n == 0)  return res;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n * 2; i ++) {
            int num = nums[i % n];
            while(!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            stack.push(i % n);
        }
        return res;
    }
}

/*
更好的做法，省去了map，每次pop出来之后直接赋值
*/

