public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)  return 1;
        int availableNum = 9;
        int uniqueDigits = 9;
        int res = 10;
        while(n-- > 1 && availableNum > 0) {
            uniqueDigits = uniqueDigits * availableNum;
            res += uniqueDigits;
            availableNum --;
        }
        return res;
    }
}

/*
简单题，但是有那么一丢丢不容易想到。
把res和uniqueDigits进行一个分离，res初始化是10，而uniqueDigits初始化是9，
availableNum不断--，uniqueDigits转化为其和availableNum的积，表示当前位数的包含的unique digits的数的数量，
并且将res加上uniqueDigits进行更新
*/