class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        int lP = 0;
        int rP = 0;
        
        for(char chr: s.toCharArray()) {
            if(chr == '(') {
                lP ++;
            } else if(chr == ')'){
                if(lP > 0) {
                    lP --;
                } else {
                    rP ++;
                }
            }
        }
        
        helper(new StringBuilder(), 0, set, s, lP, rP, 0);
        
        return new ArrayList<String>(set);
    }
    
    private void helper(StringBuilder sb, int index, Set<String> set, String s, int lP, int rP, int open) {
        if(lP < 0 || rP < 0 || open < 0) {
            return;
        }
        
        if(index == s.length()) {
            if(lP == 0 && rP == 0 && open == 0) {
                set.add(sb.toString());
            }
            return;
        }
        
        char chr = s.charAt(index);
        int len = sb.length();
        if(chr == '(') {
            helper(sb, index + 1, set, s, lP - 1, rP, open);
            helper(sb.append(chr), index + 1, set, s, lP, rP, open + 1);
        } else if(chr == ')') {
            helper(sb, index + 1, set, s, lP, rP - 1, open);
            helper(sb.append(chr), index + 1, set, s, lP, rP, open - 1);
        } else {
            helper(sb.append(chr), index + 1, set, s, lP, rP, open);
        }
        
        sb.setLength(len);
    }
}

/*
第二种方法比较正常。
先用rP和lP计算出需要删除的左括号和右括号的数目，
然后利用set来去除那些重复的string，
当lp, rP和open都为0的时候，将sb加入到res中，
然后利用backtracking进行处理，
分两种情况，就是保留当前的括号，和去除当前的括号，
保留时，sb和open需要改变，
去除时，lP/RP需要改变，
最后利用set length来返回重新的sb。
*/