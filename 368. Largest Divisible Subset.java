public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        int index = -1;
        int max = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < n; i ++) {
            count[i] = 1;
            pre[i] = -1;
            for(int j = i - 1; j >= 0; j --) {
                if(nums[i] % nums[j] == 0) {
                    if(count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if(count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while(index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        
        return res;
    }
}

/*
相当于寻找largest increasing subsequence.
count数组存储到当前位置为止的包含当前元素的最大subset的size，
pre数组存储在该subset的前一个数的位置，
遍历nums数组，初始化count[i]为1，pre[i]为-1，
然后对于当前位置往前找，若符合要求，则将其count[i]置为count[j] + 1，同时将pre[i]置为j，
对于每一个i，计算并更新max和index，
在遍历一遍之后，我们得到了最大的subset的终止位置index，然后从该位置开始利用pre数组往前遍历，加入到res中
*/