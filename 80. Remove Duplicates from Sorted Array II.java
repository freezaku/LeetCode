public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int num: nums) {
            if(i < 2 || num > nums[i - 2]) {
                nums[i ++] = num;
            }
        }
        return i;
    }
}

/*
简单的对于two pointer的应用，判断当前的数是否大于前两个数，
若大于，则将该数放入对应的位置，若不大于，则跳过，不放入，
其实相当于重新构造了一遍该数组，将符合要求的放入，不符合要求的跳过。
*/