class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n-1)) == 0;
    }
}

/*
即判断n中有几个1，
如果n为2次幂，则在最高位有一个1，其余都是0，
通过n - 1可以将低位全部置1，高位的1置0，
n & (n - 1)若为0，则说明该n位2的整数次幂
*/

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if (n <= 0) {
            return false;
        }
        int count = 0;
        for(int i = 0; i < 32; i ++) {
            if(((n >> i) & 1) == 1) {
                count ++;
            }
        }
        
        return count == 1;
    }
};