class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0)    return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('X', 10);
        map.put('C', 100);
        map.put('M', 1000);
        map.put('V', 5);
        map.put('L', 50);
        map.put('D', 500);
        
        int n = s.length();
        int res = map.get(s.charAt(n - 1));
        for(int i = n - 2; i >= 0; i --) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        
        return res;
    }
}

/*
因为有一一对应的关系，所以构造map来表明这种关系，可以更方便的使用这些char和int，
同时注意，罗马数字转阿拉伯数字，是从低位开始计算看起。

规则：
1. 从低位向高位计算
2. 左边数字大于右边数字，相加
3. 左边数字小于右边数字，大减小

即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
*/