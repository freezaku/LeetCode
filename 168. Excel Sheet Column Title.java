class Solution {
    public String convertToTitle(int n) {
        String res = "";
        
        while(n != 0) {
            int num = n - 1;
            char chr = (char)(num % 26 + 'A');
            res = chr + res;
            n = num / 26;
        }
        
        return res;
    }
}

/*
没什么特殊技巧，带入多个testcase进行测试
*/