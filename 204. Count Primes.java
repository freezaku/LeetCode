public class Solution {
    public int countPrimes(int n) {
        if(n <= 2)   return 0;
        
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for(int i = 2; i < Math.sqrt(n); i ++) {
            if(isPrime[i]) {
                for(int j = 2; i * j < n; j ++) {
                    isPrime[i * j] = false;
                }
            }
        }
        
        int count = 0;
        for(int i = 2; i < n; i ++) {
            if(isPrime[i])  count ++;
        }
        
        return count;
    }
}

/*
初始化isPrime均为true，
注意判断prime的方法：
（1）维护两个循环，一个i，一个j;
（2）i从2开始，j也从2开始，将所有以i * j为下标的数组元素isPrime[i * j] = false;
（3）注意i * i < n这个简单的约束条件
*/