public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)  return 0;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while(i < heights.length) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                i ++;
            } else {
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek());
                maxArea = Math.max(maxArea, area);
            }
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek());
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}

/*
对于这一题，如果用brute force来解决，
想到的就是针对每一个元素，找其左右两边比他小的元素，
这两边就形成了边界，可以求得针对每一个元素的maxarea，然后比较得到结果；

从这种思路扩展开去，发现这种可以利用stack来解决，算是经典的利用stack解决的例子，
在stack中存储的是下标，我们存储的下标对应的元素值，只能是递增的，
这样就可以保证每个元素的底下一个元素，是他的左边界，
而如果遇到新进来的元素的值小于stack.peek对应的值得话，
说明该元素的右边界也找到了，
此时，将该元素pop出来，作为高度，左右边界求差，相乘得到面积；

同时还有可能stack元素一路递增知道数组遍历结束，
此时要将stack中的元素不断pop，利用前面一样的方法求面积，再进行比较；

需要注意的是，
此题使用while循环遍历数组，
当将数组元素直接push的时候，i++，
而当需要计算area的时候，i不进行++操作，因为此时不能确定其一定比新的stack.peek对应的值要大，
因此还需要保持这个i，进入下一次循环继续进行比较。
*/