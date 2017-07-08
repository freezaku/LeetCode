public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int num: nums) {
            while(!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int[] res = new int[findNums.length];
        for(int i = 0; i < findNums.length; i ++) {
            res[i] = map.getOrDefault(findNums[i], -1);
        }
        
        return res;
    }
}

/*
不对findNums内的元素一个一个处理，而是全部处理nums内的元素，
利用stack，将每个元素右边比他大的元素记录下来，然后放入map中，
最后再遍历findNums找出对应元素的next greater element，
*/