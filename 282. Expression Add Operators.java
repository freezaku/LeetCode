class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0)    return res;
        
        helper(res, new StringBuilder(), num, target, 0, 0, 0);
        
        return res;
    }
    
    private void helper(List<String> res, StringBuilder sb, String num, int target, int index, long curVal, long prevVal) {
        if(curVal == target && index == num.length()) {
            res.add(new String(sb.toString()));
            return;
        }
        
        for(int i = index; i < num.length(); i ++) {
            if(num.charAt(index) == '0' && i != index)  return;
            
            int len = sb.length();
            String str = num.substring(index, i + 1);
            long val = Long.parseLong(str);
            
            if(index == 0) {
                helper(res, sb.append(str), num, target, i + 1, val, val);
                sb.setLength(len);
            } else {
                helper(res, sb.append("+" + str), num, target, i + 1, curVal + val, val);
                sb.setLength(len);
                helper(res, sb.append("-" + str), num, target, i + 1, curVal - val, -val);
                sb.setLength(len);
                helper(res, sb.append("*" + str), num, target, i + 1, curVal - prevVal + prevVal * val, prevVal * val);
                sb.setLength(len);
            }
        }
    }
}

/*
利用DFS + BACKTRACKING求解。
在helper函数中，需要维护两个参数，curval代表当前获得的值，prevval代表上一次操作中+/-/*的值，
返回条件很简单直接，curval == target 且 index到达num的末尾；

然后逐个substring num中从index开始的string，进行操作，
注意当index处的char为'0'的时候，不能进行进一步操作，因为'05'不能当做5来处理，直接return；

每次获取一个val，
三个helper函数分别代表 +, -, *，
把curval按照符号进行变化，
特别需要注意的是*，因为存在优先级问题，所以先将之前的prevval从curval中减去，跟当前的val进行相乘，
同时进入下一层helper中的时候，prevval也要更新为prevval * val
*/