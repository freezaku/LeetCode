Given an integer array, heapify it into a min-heap array.

For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].

Clarification
What is heap?

Heap is a data structure, which usually have three methods: push, pop and top. where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, "top" return the minimum/maximum element.

What is heapify?
Convert an unordered integer array into a heap array. If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].

Example
Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        for(int i = A.length / 2; i >= 0; i --) {
            swiftDown(A, i);
        }
    }
    
    private void swiftDown(int[] A, int index) {
        int n = A.length;
        while(index < n) {
            int smallest = index;
            int left = index * 2 + 1;
            if(left < n && A[left] < A[smallest]) {
                smallest = left;
            }
            int right = index * 2 + 2;
            if(right < n && A[right] < A[smallest]) {
                smallest = right;
            }
            if(smallest == index)   break; 
            
            int temp = A[smallest];
            A[smallest] = A[index];
            A[index] = temp;
            
            index = smallest;
        }
    }
}

/*
从上往下的方法进行heapify，时间复杂度是O(n)；
需要从中间开始，一直到数组的开头进行swiftDown；
遍历这个范围内的每个元素，
该元素的下标为index，则其left为index * 2 + 1, right为index * 2 + 2，
比较该点的值和left以及right，将smallest初始化为index，
若其小于left或者right，将smallest置为left或者right的下标，
若smallest==index，说明此时已经符合条件，不需要再改变，
否则，将index和smallest处的两个元素交换，
并且将index赋值为smallest，继续进入下一层循环，
这要可以保证前2 / n个元素每次都能找到自己的位置
*/