public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)   return 0;
        
        for(int i = 0; i <= haystack.length() - needle.length(); i ++) {
            int j = 0;
            while((i + j) < haystack.length() && j  < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j ++;
            }
            if(j == needle.length())    return i;
        }
        
        return -1;
    }
}

/*
简单题重写。
j代表needle的下标，i+j代表haystack的下标；
若j到达needle末位，则说明已经找到，返回i；
若i+j到达haystack末位，则说明没有找到，返回-1；
若出现两者不同的情况，则此时的i不适用，跳出j的循环。

可参考KMP算法。
*/