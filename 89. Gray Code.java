public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        
        for(int i = 0; i < n; i ++) {
            int hightestBit = (1 << i);
            int size = res.size();
            for(int j = size - 1; j >= 0; j --) {
                int num = res.get(j);
                num += hightestBit;
                res.add(num);
            }
        }
        
        return res;
    }
}

/*
初始值为0，每次用hightestBit来获取每一轮的最高位的数字，
然后逆序添加上一轮中出现的数，不过开头要加上hightestBit，
逆序添加可以保证该轮添加的第一个数和上一轮最后一个只有最高位不同.
*/