/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int res = guess(mid);
            if(res == 0) {
                return mid;
            } else if(res == 1) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return lo;
    }
}

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        
        while(lo <= hi) {
            int mid1 = lo + (hi - lo) / 3;
            int mid2 = hi - (hi - lo) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if(res1 == 0) {
                return mid1;
            }
            if(res2 == 0) {
                return mid2;
            }
            if(res1 == -1) {
                hi = mid1 - 1;
            } else if(res2 == 1) {
                lo = mid2 + 1;
            } else {
                lo = mid1 + 1;
                hi = mid2 - 1;
            }
         }
        
        return lo;
    }
}
/*
优化的做法，将其分为三段
*/