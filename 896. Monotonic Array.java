class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length <= 1) {
            return true;
        }
        boolean isInc = A[0] <= A[A.length - 1];
        for (int i=0; i < A.length - 1; i++) {
            if (isInc && A[i] > A[i+1]) {
                return false;
            }
            if (!isInc && A[i] < A[i+1]) {
                return false;
            }
        }
        return true;
    }
}

/*
和之前写的面经有点不同，这里有个等号，所以只需要把第一个和最后一个比较就行了，不是第一个和第二个了

*/