public class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        // write your code here
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
想到了利用stack解决，但是没有注意到这个优先级的问题，
遇到数字，直接将其加入到res的list中；

遇到 ( 表明将有一段优先处理，因此直接放入stack中；

遇到 ) 表明需要优先处理的一段expression已经遍历结束了，可以开始处理了，
不断将stack中的内容pop出来知道peek为 ( 为止，记得要将 （ pop出去；

遇到的是运算符，需要根据其优先级进行pop，
*和/的优先级为2，高于+和-的优先级为1，( 优先级为0，最低，
这也就表明了乘除的运算需要先进行，
因此利用判断条件getP(stack.peek()) > getP(str)将需要先行计算的部分从stack中pop出去加入res，
最后记得将该运算符加入stack

若最后stack还有东西，要将他们逐个pop出来
*/