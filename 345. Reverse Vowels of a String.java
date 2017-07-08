public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1)    return s;
        int start = 0;
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        while(start <= end) {
            while(start <= end && "AEIOUaeiou".indexOf(arr[start]) == -1)   start ++;
            while(start <= end && "AEIOUaeiou".indexOf(arr[end]) == -1) end --;
            if(start <= end)    swap(arr, start, end);
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