public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        // 这次(circular)跟之前相比，变成了从后往前遍历。
        // 变成维护一个递减的stack
        
        // 通过第一遍，留下比当前数字更大的下一个数字
        // 比如4 6 5 1 2 -> 4 6 5 1 2 // 4 6 5 1 2
        // 第一遍之后stack中剩下了6 4，也就是2之后的最大两个值
        // 之后再在第二遍里做相同操作的话，相当于留下了之前的最大值，也就是满足了circular的条件
        
        // 对比非circular：从前向后遍历，如果遇到更大的，就pop出去stack.peek()，那么现在的值也就是比pop出去的index更大的值，维护递减的stack
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            // 这里的处理也不同，这里是res[遍历中的index]；非circular是，res[stack.pop()] = nums[i]
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
}