public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0)    return Integer.MAX_VALUE;
        if(dividend == 0)   return 0;
        long did = Math.abs((long)dividend);
        long dir = Math.abs((long)divisor);
        int sign = 0;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        } else {
            sign = 1;
        }
        long res  = 0;
        while(did >= dir) {
            long temp = dir;
            long mul = 1;
            while(did >= (temp << 1)) {
                temp <<= 1;
                mul <<= 1;
            }
            did -= temp;
            res += mul;
        }
        if(res > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            return sign == 1 ? (int)res : (int)-res;
        }
    }
}

/*
这个题目就是寻找在dividend里面又多少个divisor，
通过将divisor不断左移，来将divisor扩大，用mul来记录这个加倍的过程，
左移一次变成2倍，两次为4倍，表明dividend里面有mul个divisor，
直到dividend的结果小于divisor左移的结果，从dividend里面减去这个temp，将res中加上这个mul，
然后继续执行循环，接下来是在余数里面寻找有多少个divisor，
注意：
1. 将dividend和divisor转化成long型再求得他们的绝对值，用于计算
2. 将res定义为long型
3. 如果res的值大于max，需要特殊处理结果
*/

// https://leetcode.com/problems/divide-two-integers/discuss/13397/Clean-Java-solution-with-some-comment.
/*
没必要用bit shift解决问题
*/
public int divide(int dividend, int divisor) {
	//Reduce the problem to positive long integer to make it easier.
	//Use long to avoid integer overflow cases.
	int sign = 1;
	if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
		sign = -1;
	long ldividend = Math.abs((long) dividend);
	long ldivisor = Math.abs((long) divisor);
	
	//Take care the edge cases.
	if (ldivisor == 0) return Integer.MAX_VALUE;
	if ((ldividend == 0) || (ldividend < ldivisor))	return 0;
	
	long lans = ldivide(ldividend, ldivisor);
	
	int ans;
	if (lans > Integer.MAX_VALUE){ //Handle overflow.
		ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
	} else {
		ans = (int) (sign * lans);
	}
	return ans;
}

private long ldivide(long ldividend, long ldivisor) {
	// Recursion exit condition
	if (ldividend < ldivisor) return 0;
	
	//  Find the largest multiple so that (divisor * multiple <= dividend), 
	//  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
	//  Think this as a binary search.
	long sum = ldivisor;
	long multiple = 1;
	while ((sum+sum) <= ldividend) {
		sum += sum;
		multiple += multiple;
	}
	//Look for additional value for the multiple from the reminder (dividend - sum) recursively.
	return multiple + ldivide(ldividend - sum, ldivisor);
}
