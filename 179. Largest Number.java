public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)    return "";
        
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i ++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String str1 = a + b;
                String str2 = b + a;
                return str2.compareTo(str1);
            }
        });
        
        if(strs[0].charAt(0) == '0')    return "0";
        
        String res = "";
        for(String str: strs) {
            res += str;
        }
        
        return res;
    }
}

/*
注意自己override的comparator的构造方法。
此题中比较的是将两个str相连之后，不同顺序情况下的大小，按照从大到小进行排列。

有几点需要注意：
1. comparator的写法
2. int转化为string的方法：String.valueOf(int) 或 Integer.toString(int);
*/