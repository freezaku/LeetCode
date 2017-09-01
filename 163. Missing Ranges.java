class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(lower > upper)  return res;
        
        long start = lower;
        for(int num: nums) {
            if(num > start) {
                int end = num - 1;
                if(start == end) {
                    String str = String.valueOf(start);
                    res.add(str);
                } else {
                    String str = start + "->" + end;
                    res.add(str);
                }
            }
            if(num == upper) {
                return res;
            } else {
                start = num + 1;
            }
        }
        
        if(start == upper) {
            String str = String.valueOf(start);
            res.add(str);
        } else if(start < upper){
            String str = start + "->" + upper;
            res.add(str);
        }
        
        return res;
    }
}

/*
主要思路很简单，但是要注意各种corner case的处理。
当num == upper的时候，直接return res，防止start = num + 1之后，start变成MIN_VALUE的各种情况。
*/