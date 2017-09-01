class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)    return true;
        
        Deque<Character> deque = new LinkedList<>();
        for(char chr: s.toCharArray()) {
            if(chr == '(') {
                deque.push(')');
            } else if(chr == '[') {
                deque.push(']');
            } else if(chr == '{'){
                deque.push('}');
            } else {
                if(deque.isEmpty() || chr != deque.pop()) {
                    return false;
                }
            }
        }
        
        return deque.isEmpty();
    }
}

/*
此题注意最后返回时使用的判断条件，为stack.isEmpty();
*/