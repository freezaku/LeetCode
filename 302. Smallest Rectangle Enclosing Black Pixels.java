public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        
        int left = find1(image, 0, y, 0, m, true);
        int right = find1(image, y + 1, n - 1, 0, m, false);
        int top = find2(image, 0, x, 0, n, true);
        int bottom = find2(image, x + 1, m - 1, 0, n, false);
        
        return (right - left) * (bottom - top);
    }
    
    private int find1(char[][]image, int start, int end, int top, int bottom, boolean flag) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int k = top;
            while(k < bottom && image[k][mid] == '0')   k ++;
            if(k < bottom == flag) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
    
    private int find2(char[][]image, int start, int end, int left, int right, boolean flag) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int k = left;
            while(k < right && image[mid][k] == '0')    k ++;
            if(k < right == flag) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}

/*
利用Binary Search解决，找到上下左右的边界，

左：
定义start和end分别为0和y，在这范围内找最左，
每次找出mid之后从上到下遍历，
当发现在该列有黑块之后，
再往左找，令end = mid - 1，否则往右找，令start = mid + 1；

右：
定义start和end分别为y + 1和n - 1，在这范围内找最右，
每次找出mid之后从上到下遍历，
当发现在该列有黑块之后，
再往右找，令start = mid + 1，否则往左找，令end = mid - 1；

上：
定义start和end分别为0和x，在这范围内找最上，
每次找出mid之后从左到右遍历，
当发现在该列有黑块之后，
再往上找，令end = mid - 1，否则往下找，令start = mid + 1；

下：
定义start和end分别为x + 1和m - 1，在这范围内找最下，
每次找出mid之后从左到右遍历，
当发现在该列有黑块之后，
再往下找，令start = mid + 1，否则往上找，令end = mid - 1；
*/