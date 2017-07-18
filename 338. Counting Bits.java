public int[] countBits(int num) {
    int result[] = new int[num + 1];
    int offset = 1;
    for (int index = 1; index < num + 1; ++index){
        if (offset * 2 == index){
            offset *= 2;
        }
        result[index] = result[index - offset] + 1;
    }
    return result;
}

/*
Question:
Given a non negative integer number num. 
For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Thinking:

We do not need check the input parameter, because the question has already mentioned that the number is non negative.

How we do this? The first idea come up with is find the pattern or rules for the result. Therefore, we can get following pattern

Index : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

num : 0 1 1 2 1 2 2 3 1 2 2 3 2 3 3 4

Do you find the pattern?

Obviously, this is overlap sub problem, and we can come up the DP solution. For now, we need find the function to implement DP.

dp[0] = 0;

dp[1] = dp[0] + 1;

dp[2] = dp[0] + 1;

dp[3] = dp[1] +1;

dp[4] = dp[0] + 1;

dp[5] = dp[1] + 1;

dp[6] = dp[2] + 1;

dp[7] = dp[3] + 1;

dp[8] = dp[0] + 1;
...

This is the function we get, now we need find the other pattern for the function to get the general function. After we analyze the above function, we can get
dp[0] = 0;

dp[1] = dp[1-1] + 1;

dp[2] = dp[2-2] + 1;

dp[3] = dp[3-2] +1;

dp[4] = dp[4-4] + 1;

dp[5] = dp[5-4] + 1;

dp[6] = dp[6-4] + 1;

dp[7] = dp[7-4] + 1;

dp[8] = dp[8-8] + 1;
..

Obviously, we can find the pattern for above example, so now we get the general function

dp[index] = dp[index - offset] + 1;
*/