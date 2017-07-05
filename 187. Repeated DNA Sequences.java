public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for(int i = 0; i <= s.length() - 10; i ++) {
            String str = s.substring(i, i + 10);
            if(!set1.add(str)) {
                set2.add(str);
            }
        }
        return new ArrayList<>(set2);   
    }
}

/*
两种方式求解：

1. 利用两个set，遍历s并且每次substring出长度为10的word，
若其不能加入set1，则将其加入set2中，最后利用 new ArrayList<>(set2)进行输出；

2. 利用只含有四种碱基的特点，设定一个char数组，使得char[0]对应A，char[1]对应C，char[2]对应G，char[3]对应T；
然后遍历s，对i之后10个char进行处理，每次根据char的值得到0,1,2,3之一的值，用v进行存储这两位00,01,10,11, 在运行之前先将v << 两位，
再 ^ 结果，最终得到一个用v存储你10位char的二进制数，
若set1无法加入v，而set2可以加入，则说明v重复，将其加入list
*/