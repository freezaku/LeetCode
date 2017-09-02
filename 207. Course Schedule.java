class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] edges = new List[numCourses]; 
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i ++) {
            edges[i] = new ArrayList<>();
        }
        
        for(int[] prerequisite: prerequisites) {
            int end = prerequisite[0];
            int start = prerequisite[1];
            inDegree[end] ++;
            edges[start].add(end);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int start = queue.poll();
            List<Integer> list = edges[start];
            for(int end: list) {
                inDegree[end] --;
                if(inDegree[end] == 0) {
                    queue.add(end);
                }
            }
        }
        
        for(int i = 0; i < numCourses; i ++) {
            if(inDegree[i] != 0)    return false;
        }
        
        return true;
    }
}

/*
建立ArrayList[]不能使用泛型，list.get(i)默认返回Object，需要cast成int型。
有两种方式写：
1.BFS
比较容易理解。将prerequisite内的每一个元素，分别作为parent和child，存入邻接表，一个parent对应了多个child。
同时，遍历indegree数组，记录每个child的入度。
将入度为0的child，放入queue中。可以用queue中这些点开始寻找，利用topological sort的方法，将入度为0的点从queue中去除，并将此点的所有相邻点的入度减1，若再次出现入度为0的点，将其加入queue。

2. DFS
建立prerequisite的方法相同，建立visited来判断该点是否访问，但是使用noCycle来判断从该点开始DFS是否有圈。
在noCycle中，如果visited[course] = true，则说明已经访问，有圈了，return false；
否则，置当前的visited[course] = true；
接下来，继续用noCycle来访问以course为parent的每一个点；访问了之后，将visited[course]置为false，return true，表示该点开始的DFS没有圈。
*/