public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(0, 0, new StringBuilder(), n, res);
        return res;
    }
    
    private void helper(int left, int right, StringBuilder sb, int n, List<String> res) {
        if(left == n && right == n) {
            res.add(new String(sb.toString()));
            return;
        }
        
        if(left < n) {
            sb.append("(");
            helper(left + 1, right, sb, n, res);
            sb.setLength(sb.length() - 1);
        }
        
        if(right < left) {
            sb.append(")");
            helper(left, right + 1, sb, n, res);
            sb.setLength(sb.length() - 1);
        }

    }
}

/*
String简单题重做.

典型的使用recursion的例子，同时添加backtracking方法。
给cur不断添加 ( 和 ) , 直到长度达到要求且形式为止，若此时的形式满足条件，则加上此cur，
否则直接return，在添加了( 和 )之后，要进行删除操作。

注意stringbuilder的一些方法:
StringBuilder sb = new StringBuilder()
1. 长度 sb.length()
2. 添加 sb.append(...)
3. 设置长度相当于直接删去某些字符串 sb.setLength(...)
*/