1. Two Stack
public class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    //int res;
    public MinStack() {
        // do initialize if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int number) {
        // write your code here
        stack1.push(number);
        if(number <= stack2.peek()) {
            stack2.push(number);
        }
    }

    public int pop() {
        // write your code here
        int num = stack1.pop();
        if(num == stack2.peek()) {
            stack2.pop();
        }
        return num;
    }

    public int min() {
        // write your code here
        return stack2.peek();
    }
}

2. One Stack
public class MinStack {
    Stack<Integer> stack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
       if(x <= min) {
           stack.push(min);
           min = x;
       }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.pop() == min) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/*
push进的数是min的时候，将该数push两次；
pop出的数是min的时候，将该数pop两次；
*/
