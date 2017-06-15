public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)    return 0;
        int[] height = new int[matrix[0].length];
        for(int i = 0; i < matrix[0].length; i ++) {
            if(matrix[0][i] == '1') height[i] = 1;
        }
        int result = largestInLine(height);
        for(int i = 1; i < matrix.length; i ++) {
            resultHeight(matrix, height, i);
            result = Math.max(result, largestInLine(height));
        }
        return result;
    }

    private void resultHeight(char[][] matrix, int[] height, int index) {
        for(int i = 0; i < matrix[0].length; i ++) {
            if(matrix[index][i] == '1') {
                height[i] += 1;
            } else {
                height[i] = 0;
            }
        }
    }
    
    private int largestInLine(int[] height) {
        if(height == null || height.length == 0)    return 0;
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= len; i ++) {
            int h = (i == len ? 0 : height[i]);
            if(stack.isEmpty() || height[stack.peek()] <= h) {
                stack.push(i);
            } else {
                int top = stack.pop();
                int area = height[top] * (stack.isEmpty() ? i : i - 1 - stack.peek());
                maxArea = Math.max(maxArea, area);
                i --;
            }
        }
        return maxArea;
    }
}

/*
要用到上一题的思路，
将一个二维的数组转化为根据每一行的一维的高度数组，
利用上一题那个找最大面积的方法，
计算出每一行能够对应的height，然后来求maxarea
*/