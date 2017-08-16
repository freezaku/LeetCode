public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)  return 0;
        
        int n = citations.length;
        int[] count = new int[n + 1];
        
        for(int citation: citations) {
            if(citation > n) {
                count[n] ++;
            } else {
                count[citation] ++;
            }
        }
        
        int res = 0;
        for(int index = n; index >= 0; index --) {
            res += count[index];
            if(res >= index)  return index;
        }
        
        return 0;
    }
}

/*
利用bucket方法解决，
构建array数组，下标为citation，存储相应的citation出现的次数，
若大于数组长度的citation则存储在数组最后一个；
再从后往前遍历数组，将每个index下的个数加到res中，
不断寻找从哪儿开始总出现的大于该index的数的 次数 大于index，返回此时的index。
*/