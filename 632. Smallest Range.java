public class Solution {
    class Node {
        int row;
        int index;
        int val;
        public Node(int row, int index, int val) {
            this.row = row;
            this.index = index;
            this.val = val;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.val - b.val;
            }
        });
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i ++) {
            List<Integer> list = nums.get(i);
            max = Math.max(max, list.get(0));
            Node node = new Node(i, 0, list.get(0));
            pq.offer(node);
        }
        
        int range = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        while(pq.size() == nums.size()) {
            Node node = pq.poll();
            if(max - node.val < range) {
                range = max - node.val;
                start = node.val;
                end = max;
            }
            if(node.index < nums.get(node.row).size() - 1) {
                Node temp = new Node(node.row, node.index + 1, nums.get(node.row).get(node.index + 1));
                max = Math.max(max, temp.val);
                pq.offer(temp);
            }
        }
        
        return new int[]{start, end};
    }
}

/*
和merge k arrays类似。
利用priorityqueue存储每个list的第一个元素，并track一个最大值，
此时pq中的元素能够符合要求，
然后不断pop出最小的元素，用于计算range，
然后将该元素同一个list中的后一个元素加入pq，继续进行计算，
当pq的size小于nums.size()的时候，说明不能满足包含每个list中至少一个元素的要求，结束while循环
*/