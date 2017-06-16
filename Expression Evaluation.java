Given an expression string array, return the final result of this expression

 Notice

The expression contains only integer, +, -, *, /, (, ).

Have you met this question in a real interview? Yes
Example
For the expression 2*6-(23+7)/(1+2),
input is

[
  "2", "*", "6", "-", "(",
  "23", "+", "7", ")", "/",
  "(", "1", "+", "2", ")"
]  
return 2

public class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        // write your code here
        return solveRPN(getRPN(expression));
    }
    private int solveRPN(ArrayList<String> list) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(String str: list) {
            if("+-*/".indexOf(str) != -1) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(str.equals("+")) {
                    stack.push(num1 + num2);
                } else if(str.equals("-")) {
                    stack.push(num2 - num1);
                } else if(str.equals("*")) {
                    stack.push(num1 * num2);
                } else {
                    stack.push(num2 / num1);
                }
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }
    private ArrayList<String> getRPN(String[] expression) {
        ArrayList<String> res = new ArrayList<>();
        if(expression == null || expression.length == 0)    return res;
        Stack<String> stack = new Stack<>();
        for(String str: expression) {
            if(Character.isDigit(str.charAt(0))) {
                res.add(str);
            } else if(str.equals("(")) {
                stack.push(str);
            } else if(str.equals(")")) {
                while(!stack.peek().equals("(")) {
                    res.add(stack.pop());
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(str)) {
                    res.add(stack.pop());
                }
                stack.push(str);
            }
        }
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
    private int getPriority(String str) {
        if(str.equals("(")) {
            return 0;
        } else if(str.equals("+") || str.equals("-")) {
            return 1;
        } else {
            return 2;
        }
    }
}

/*
利用之前做的expression和PRN之间的转化，
先将expression转化为RPN，
然后针对RPN求解；

RPN求解比较简单，
就是利用stack，将元素不断pop出来，
遇到数字直接放入，
遇到符号，pop出来两个，根据符号进行计算，
然后再将答案push进stack，
最后留在stack就是最终结果
*/