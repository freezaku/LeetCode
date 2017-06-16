Given an expression string array, return the Polish notation of this expression. (remove the parentheses)

Example

For the expression [(5 − 6) * 7] (which represented by ["(", "5", "−", "6", ")", "*", "7"]), the corresponding polish notation is [ - 5 6 7] (which the return value should be ["*", "−", "5", "6", "7"]).

public class Solution {
  /**
   * @param expression: A string array
   * @return: The Polish notation of this expression
   */
  public ArrayList<String> convertToPN(String[] expression) {
    ArrayList<String> res = new ArrayList<>();
    if(expression == null || expression.length == 0)  return  res;
    Stack<String> stack = new Stack<>();
    for(String str: expression) {
      if(Character.isDigit(str.charAt(0))) {
        res.add(str);
      } else if(str.equals(")")) {
        stack.push(str);
      } else if(str.equals("(")) {
        while(!stack.peek().equals(")")) {
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
      res.add(stack.pop);
    }    
    Collections.reverse(res);
    return res;
  }
  private int getPriority(String str) {
    if(str.equals(")")) {
      return 0;
    } else if(str.equals("+") || str.equals("-")) {
      return 1;
    } else {
      return 2;
    }
  }
}

/*
polish notation就相当于是将符号放在前面，
在前一题的基础上改变，思路完全一样，
注意需要从前往后遍历数组，然后每次将元素加入到res这个list的头，
也可以选择正常add，最后再reverse
*/