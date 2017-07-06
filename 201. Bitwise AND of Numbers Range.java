public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0)  return 0;
        int moveFactor = 0;
        while(m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor ++;
        }
        return m << moveFactor;
    }
}

/*
实际上就是观察m和n有多少位相同，因为不同的位都会经过&都会变成0，
因此用moveFactor记录不同的位的位数，m和n不断右移直到相同为止，
最后将他们相同的位数左移moveFactor位即可。
*/