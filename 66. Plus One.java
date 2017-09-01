class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i --) {
            if(digits[i] < 9) {
                digits[i] ++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        
        int[] res = new int[n + 1];
        res[0] = 1;
        
        return res;
    }
}

/*
注意仅仅是+1，因此很多操作可以简化。
当digit < 9的时候，必然停止loop，该位 ++之后return；
否则，产生进位，digit变为0，继续loop；
当超出digits范围的时候，需新建数组，首位置1，后面保持即可。
*/