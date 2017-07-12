public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, 0, 0, s);
        return res;
    }
    
    private void dfs(List<String> res, StringBuilder sb, int idx, int count, String s) {
        if(count > 4)   return;
        if(count == 4 && idx == s.length()) {
            res.add(new String(sb.toString()));
            return;
        }
        for(int i = 0; i < 4; i ++) {
            if(idx + i > s.length())    break;
            String str = s.substring(idx, idx + i);
            if(isValid(str)) {
                int len = sb.length();
                sb.append(str);
                if(count != 3)  sb.append(".");
                dfs(res, sb, idx + i, count + 1, s);
                sb.setLength(len);
            }
        }
    }
    
    private boolean isValid(String str) {
        if(str.length() == 0) return false;
        if(str.length() > 1 && str.charAt(0) == '0')    return false;
        int num = Integer.valueOf(str);
        if(num < 0 || num > 255)    return false;
        return true;
    }
}

/*
比较复杂的backtracking问题，因为判断条件很多，需要仔细思考。
此题中，用ipIndex代表是第几段ip，strIndex代表是s中的第几个，
当ipIndex＝4，strIndex ＝ s.length()的时候，满足要求，将sb最后的 . 去掉加入res。

在循环里，利用i从1到3的循环，将其＋1，分别截取长度为1 ～ 3不等的substr，再将substr放入isValid进行判断，若符合要求，将其加入sb，更新helper的各种参数，再次调用helper，最后再将sb进行截取还原，取下一个substr进行循环判断。

注意isValid函数，对substr首位为0的情况，若有多位，则false，若就是0，则true。
*/