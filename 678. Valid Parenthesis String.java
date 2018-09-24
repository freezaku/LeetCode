class Solution {
    public boolean checkValidString(String s) {
        if(s == null || s.length() == 0)    return true;
 
        return helper(s, new Stack<Character>(), 0);
    }
    
    private boolean helper(String s, Stack<Character> stack, int index) {
        if(index == s.length()) {
            return stack.isEmpty();
        }
        
        char chr = s.charAt(index);
        if(chr == '(') {
            
            stack.push('(');
            if(helper(s, stack, index + 1)) {
                return true;
            } else {
                stack.pop();
                return false;
            }
        } else if(chr == ')') {
            if(!stack.isEmpty()) {
                char p = stack.pop();
                if(p == '(' && helper(s, stack, index + 1)) {
                    return true;
                }
                stack.push(p);
                return false;
            } else {
                return false;
            }
            
        } else {
            
            if(helper(s, stack, index + 1)) {
                return true;
            }
            
            stack.push('(');
            if(helper(s, stack, index + 1)) {
                return true;
            }
            stack.pop();
            
            if(!stack.isEmpty()) {
                char p = stack.pop();
                if(p == '(' && helper(s, stack, index + 1)) {
                    return true;
                } else {
                    stack.push(p);
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}