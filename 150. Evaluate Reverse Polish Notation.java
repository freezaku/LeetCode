public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for(String str: tokens) {
            if(str.equals("+")) {
                int num1 = deque.pop();
                int num2 = deque.pop();
                deque.push(num1 + num2);
            } else if(str.equals("*")) {
                int num1 = deque.pop();
                int num2 = deque.pop();
                deque.push(num1 * num2);
            } else if(str.equals("-")) {
                int num1 = deque.pop();
                int num2 = deque.pop();
                deque.push(num2 - num1);
            } else if(str.equals("/")) {
                int num1 = deque.pop();
                int num2 = deque.pop();
                deque.push(num2 / num1);
            } else {
                deque.push(Integer.valueOf(str));
            }
        }
        return deque.peek();
    }
}