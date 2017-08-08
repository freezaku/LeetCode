public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0)    return res;
        
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        dfs(digits, mapping, 0, new StringBuilder(), res);
        
        return res;
    }
    
    private void dfs(String digits, String[] mapping, int index, StringBuilder sb, List<String> res) {
        if(index == digits.length()) {
            res.add(new String(sb.toString()));
            return;
        }
        
        
        String strs = mapping[digits.charAt(index) - '0'];
        int len = sb.length();
        for(int i = 0; i < strs.length(); i ++) {
            char chr = strs.charAt(i);
            sb.append(chr);
            dfs(digits, mapping, index + 1, sb, res);
            sb.setLength(len);
        }
    }
}

/*
简单的string问题重做，注意获取对应数字下的string的方法，可以不使用map。

或者利用BFS思想，用linkedlist构造的queue来维护使用。

1. 将数字当做下标，其含有的string作为内容，存入mapping的string类型数组；
2. 给linkedlist类型数组初始化一个""空的string
3. 逐一访问digits内的每一位，得到其int值x，x也为我们需要使用的string数组的下标
4. 若此时res.peek()的length为i，说明res内的此string没有添加该digits数组的对应值
5. 我们将当前不符合要求的string移去，并将digits数组中的每一个值分别添加到该string后面，再添加到res中
6. 执行5直到res.peek()的length大于i值，则说明所有res内的string已经更新完毕，执行下个digits的元素

eg：
{""} -> {"a", "b", "c"} -> {"b", "c", "ad", "ae", "af"} -> {"c", "ad", "ae", "af", "cd", "ce", "cf"} ->
{"ad", "ae", "af", "cd", "ce", "cf", "cd", "ce", "cf"}
*/