/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        char[] buffer = new char[4];
        while(total < n && !eof) {
            int count = read4(buffer);
            if(count < 4)   eof = true;
            int len = Math.min(n - total, count);
            for(int i = 0; i < len; i ++) {
                buf[total + i] = buffer[i];
            }
            total += len;
        }
        return total;
    }
}

/*
很奇怪的问题，
这题其实是要求从一个file中读出n个char，但是这个file的大小，可能大于n，也可能小于n，
同时需要将读出来的char存入buf数组中。

因此我们需要照顾到两点，
1. file的size小于n，判断我们read的过程是否到了文件尾，用eof表示
2. file的size大于n，判断我们是否read了超过n的char，用total来进行计数

每次用read4将文件读入buffer中，返回一个count为读的char的个数，
若count < 4表明已经读到了文件尾，eof置为true，
同时将count和n - count中的较小值赋给len，表明按照要求应该读取的char的个数，
然后将规定个数的char从buffer中取出放入buf，total对应加上这个个数
*/