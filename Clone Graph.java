/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null)    return node;
        
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        map.put(node, new UndirectedGraphNode(node.label));
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for(UndirectedGraphNode neighbor: cur.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
}

/*
BFS处理。
先用map存储初始节点和copy的节点。
然后利用queue，每次poll出一个cur节点，
遍历其所有的neighbor，若该neighbor不存在map中，则建立映射关系并存储在map中，
并将其放入queue中，
同时将cur节点的copy节点的neighbors的list中加入改点。

用map存储原有的node和copy出来的node，<node, copynode>，
利用queue存储node
然后利用bfs遍历node的neighbors，
若map里面有，则将其加入到copynode的neighbors里面；
若map里面没有，将该neighbor和copyneighbor放入map中，<neighbor，copyneighbor>，
再将copyneighbor加入到copynode的neighbors中，
并将neighbor加入到queue中。

*/