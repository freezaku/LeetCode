Description
Implement double sqrt(double x) and x >= 0.

Compute and return the square root of x.

Notice
You do not care about the accuracy of the result, we will help you to output results.


Example
Given n = 2 return 1.41421356

public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        // Write your code here
        double start = 1;
        double end = x;
        double precise = 1e-12;

        if(x < 1.0) {
        	end = 1.0;
        }

        while(end - start >= precise) {
        	double mid = start + (end - start) / 2.0;
        	if(mid * mid < x) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }

        return start;
    }
}

/*
二分法。
注意这里要设一个precise表示start和end之间的距离小于它，我们的答案就已经收敛了。
这里不能把start置为mid + 1这种类似的操作，这样的话精确度没法保证，
还要注意，如果x<1，那么sqrt(x)是>x的。在这种情况下我们把end设为1。
*/
