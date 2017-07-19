public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int m = s.length();
        int n = t.length();
        int sIndex = 0;
        int tIndex = 0;
        while(tIndex < n) {
            if(s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex ++;
                if(sIndex == m) return true;
            }
            tIndex ++;
        }
        return false;
    }
}

/*
正常的简单做法，利用two pointers解决，
当两个string的char相等时，iIndex ++，并且比较iIndex与m。
而tIndex总是 ++.
*/

public class Solution {
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] count = new List[256];
        
        for(int i = 0; i < t.length(); i ++) {
            char chr = t.charAt(i);
            if(count[chr] == null) {
                count[chr] = new ArrayList<>();
            }
            count[chr].add(i);
        }
        
        int index = 0;
        for(int i = 0; i < s.length(); i ++) {
            char chr = s.charAt(i);
            if(count[chr] == null)  return false;
            int j = Collections.binarySearch(count[chr], index);
            if(j < 0) {
                j = - (j + 1);
            }
            if(j == count[chr].size())  return false;
            index = count[chr].get(j) + 1;
        }
        
        return true;
    }
}

/*
满足follow-up的做法，即对于一个t，可以多次使用s来跟他进行比较查看是否为subsequence.
构造count数组，每个char对应一个count内的list，
首先遍历t，将其内的每个char的下标，存入count数组对应list的位置，这样我们就得到了每个char在t内位置的一个数组count，
初始化一个index为0，这个index就相当于在t内的坐标了，
然后遍历s，若s内的char所对应的count该位置为null，直接返回false，
否则利用binarysearch方法，在char对应的list内寻找index，
这个index的位置，若找到了就为j，若没有找到，则返回一个负值的应当插入的位置，利用-(j + 1)进行转化，
其实index就相当于提供了一个下界，应该在list中找到第一个比他大的值，
若这个j和对应的list的size一样大，说明在t中无法找到符合条件的一个char，return false，
否则，说明找到了，这个index需要增大1.
*/