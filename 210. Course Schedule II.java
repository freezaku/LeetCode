class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] edges = new List[numCourses];
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i ++) {
            edges[i] = new ArrayList<>();
        }
        
        for(int[] prerequisite: prerequisites) {
            int start = prerequisite[1];
            int end = prerequisite[0];
            edges[start].add(end);
            inDegree[end] ++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int[] res = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()) {
            int start = queue.poll();
            res[index ++] = start;
            List<Integer> list = edges[start];
            for(int end: list) {
                inDegree[end] --;
                if(inDegree[end] == 0) {
                    queue.add(end);
                }
            }
        }
        
        if(index == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }
}

/*
与 Course Schedule I方法相同，但是需要在poll的时候，将元素加入array。
*/