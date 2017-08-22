public class Solution {
    public int myAtoi(String str) {
        if(str.length() == 0) return 0;
        char[] chrs = str.toCharArray();
        int start = 0;
        while(start < chrs.length && chrs[start] == ' ')    start ++;
        if(start == chrs.length)    return 0;
        int sign = 1;
        if(chrs[start] == '+' || chrs[start] == '-') {
            sign = chrs[start] == '+' ? 1 : -1;
            start ++;
        }
        int res = 0;
        while(start < chrs.length && Character.isDigit(chrs[start])) {
            int digit = chrs[start] - '0';
            if((Integer.MAX_VALUE / 10 < res || Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            start ++;
        }
        return res * sign;
    }
}

/*
注意各种条件。

考虑所有规则：
1. 去除开头所有的空格
2. 判断之后第一位的符号
3. 有一位符号后不是数字的，invalid
4. 后面出现非数字，忽略其后所有内容
5. overflow，直接返回最大或最小值

注意对于最大值的判断
(Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < temp))
*/