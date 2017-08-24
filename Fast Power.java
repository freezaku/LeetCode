Calculate the an % b where a, b and n are all 32bit integers.

Have you met this question in a real interview? Yes
Example
For 231 % 3 = 2

For 1001000 % 1000 = 0

class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if(n == 0) {
            return 1 % b;
        }
        if(n == 1) {
            return a % b;
        }
        
        long product = fastPower(a, b, n / 2);
        product = (product * product) % b;
        
        if(n % 2 == 1) {
            product = (product * a) % b;
        }
        
        return (int)product;
    }
};

/*
利用recursion(递归)解答很简便，
需要注意的是但b为奇数的时候，需要额外处理
*/