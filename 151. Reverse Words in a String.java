public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0)    return s;
        char[] arr = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            swap(arr, start, end);
            start ++;
            end --;
        }
        return String.valueOf(arr);
    }
    private void swap(char[] arr, int start, int end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}

/*
ez
*/