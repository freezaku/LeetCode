public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3)    return 0;
        int cur = 0;
        int res = 0;
        
        for(int i = 2; i < A.length; i ++) {
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur ++;
                res += cur;
            } else {
                cur = 0;
            }
        }
        
        return res;
    }
}

/*
这题的题意容易曲解和模糊，先解释一下。
需要找到这个数组内 连续的 用相同公差的 subarray的数量。
因此我们只需要从前往后遍历即可，不需要考虑存在隔项的情况。
从后往前遍历，cur代表包含该位置元素的slice的个数，res表示总个数，
当出现A[i] - A[i - 1] == A[i - 1] - A[i - 2]的情况的时候，cur在原有基础上++，
这个规律多列几个例子就能发现，并且将cur加到res中，
而不是这种情况的时候，将cur置为0
*/