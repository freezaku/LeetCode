public class Solution {
    public boolean isPerfectSquare(int num) {
        long lo = 1;
        long hi = num;
        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sum = mid * mid;
            if(sum == num) {
                return true;
            } else if(sum > num) {
                hi = mid - 1;
            } else{
                lo = mid + 1;
            }
        }
        
        return false;
    }
}

/*
简单的二分问题，注意使用long来避免一些bound case
*/

boolean isPerfectSquare(int num) {
  if (num < 1) return false;
  long t = num / 2;
  while (t * t > num) {
    t = (t + num / t) / 2;
  }
  return t * t == num;
}