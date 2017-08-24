public class Solution {
    /*
     * @param A: An integer array
     * @return: An integer array
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if(A == null || A.length == 0)  return res;
        
        int diff = 0;
        for(int num: A) {
            diff ^= num;
        }
        
        // diff &= (-diff);
        diff &= ~(diff - 1);
        
        int group1 = 0;
        int group2 = 0;
        for(int num: A) {
            if((num & diff) == 0) {
                group1 ^= num;
            } else {
                group2 ^= num;
            }
        }
        
        res.add(group1);
        res.add(group2);
        return res;
    }
}

/*
遍历nums，利用^获取两个target异或之后的结果diff；

将diff进行处理 diff = ~(diff - 1) 或者 diff &= -diff 可以获取diff中右边第一个1的位置，
即两个target在该位不同，一个是0，一个是1，

再次遍历nums，根据该位，将nums分成两组来异或，则可以得到两个target
*/