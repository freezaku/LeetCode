public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for(int i = 0; i < A.length; i ++) {
            for(int j = 0; j < B.length; j ++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        for(int i = 0; i < C.length; i ++) {
            for(int j = 0; j < D.length; j ++) {
                int sum = C[i] + D[j];
                res += map.getOrDefault(-1 * sum, 0);
            }
        }
        
        return res;
    }
}

/*
利用hashmap解决，
首先将A[I],B[J]所有相加的可能值及其出现的次数存入map，
然后获得C[I], D[J]内所有相加的可能，每次判断其相反数是否存在。
*/