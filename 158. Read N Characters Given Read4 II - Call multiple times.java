/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] temp = new char[4];
    int bufPtr = 0;
    int bufCount = 0;
    int bufEnd = 0;
    
    public int read(char[] buf, int n) {
        int curPtr = 0;
        while(curPtr < n) {
            if(bufCount == 0) {
                bufCount = read4(temp);
                bufEnd = bufCount;
                bufPtr = 0;
            }
            if(bufCount == 0)   break;
            while(bufPtr < bufEnd && curPtr < n) {
                buf[curPtr ++] = temp[bufPtr ++];
                bufCount --;
            }
        }
        return curPtr;
    }
}

/*
因为每次将char读取到了temp这个数组里面，
但是又不一定每次都将整个temp数组的元素都取出放入buf，因此需要一个ptr(bufPtr)来指示在上一次call read中到达的位置，
这个bufPtr其实是和bufCount相对应的，bufPtr没有计数到bufEnd，bufCount也就不会--到0，
因此再下次call的时候，bufCount != 0，会先将遗留在temp中char取出来再说。
其他和I的思路方法一样
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    LinkedList<Character> list = new LinkedList<>();
    public int read(char[] buf, int n) {
        int total = 0;
        while(true) {
            char[] tmp = new char[4];
            int in = read4(tmp);
            
            for(int i = 0; i < in; i ++) {
                list.add(tmp[i]);
            }
            
            in = Math.min(n - total, list.size());
            
            for(int i = 0; i < in; i ++) {
                buf[total ++] = list.removeFirst();
            }
            
            if(in == 0) break;
        }
        return total;
    }
}

/*
与第一题比较，变化是这样：
比如先call了n=3，然后call n=5，那么第一次就读入了4个char，第二次call应该把上一次的最后一个char拿来。
也就是说要有个cache取缓存已读取的字符，然后从这个cache里面取。
每次读4个字符，放入 cache，然后in = Math.min(n - total, list.size()) 这个是精髓，
这样就知道还需要多少个字符了。
如果是in=0了，那么说明已经够了或者没字符了，这样就不用再读取了。
使用linkedlist来cache上一次没有读完的char。
*/