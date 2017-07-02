ind K-th largest element in N arrays.

 Notice

You can swap elements in the array

Have you met this question in a real interview? Yes
Example
In n=2 arrays [[9,3,2,4,7],[1,2,3,4,8]], the 3rd largest element is 7.

In n=2 arrays [[9,3,2,4,8],[1,2,3,4,2]], the 1st largest element is 9, 2nd largest element is 8, 3rd largest element is 7 and etc.

public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    class Node {
        int value;
        int x;
        int y;
        public Node(int value, int index, int y) {
            this.value = value;
            this.x = index;
            this.y = y;
        }
    }
    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
        PriorityQueue<Node> pq = new PriorityQueue<>(k, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return b.value - a.value;
            }
        });

        for(int i = 0; i < arrays.length; i ++) {
            Arrays.sort(arrays[i]);
            if(arrays[i].length > 0) {
                pq.offer(new Node(arrays[i][arrays[i].length - 1], i, arrays[i].length - 1));
            }
        }
        
        for(int i = 0; i < k - 1; i ++) {
            Node node = pq.poll();
            int x = node.x;
            int y = node.y;
            if(y == 0)  continue;
            pq.offer(new Node(arrays[x][y - 1], x, y - 1));
        }
        
        return pq.peek().value;
    }
}

/*
思路很简单，利用pq来存储每个array的最后一个，构造出来的node包含value和这个元素所在的x和y具体位置，
然后不断poll出来，将该元素的前一个放进去，

需要注意的就是这个comparator的写法，
new Comparator<>() {
    public int compare(, ) {
    
    }
}
<>和()一个都不能少
*/