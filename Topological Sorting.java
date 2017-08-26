/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        if(graph == null || graph.size() == 0)  return res;
        
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for(DirectedGraphNode node: graph) {
            for(DirectedGraphNode neighbor: node.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, 0);
                }
                map.put(neighbor, map.get(neighbor) + 1);
            }
        }
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode node: graph) {
            if(!map.containsKey(node)) {
                queue.add(node);
                res.add(node);
            }
        }
        
        while(!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for(DirectedGraphNode neighbor: node.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if(map.get(neighbor) == 0) {
                    res.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        return res;
    }
}

/*
利用hashmap求解，存储DirectedGraphNode和其对应的入度，但是没有想到怎么使用queue简化操作过程。
遍历graph，将DirectedGraphNode和对应入度存入map；
再次遍历map，将入度为0的node加入queue和res，作为初始点的candidate，
然后对queue进行处理，当其不是empty的while循环中，每次poll出来pre的点，并且将其neighbor的入度-1，
当有neighbor的入度减为0的时候，将其加入queue和res，作为下一次poll出来的初始pre点
*/