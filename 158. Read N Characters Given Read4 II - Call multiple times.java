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