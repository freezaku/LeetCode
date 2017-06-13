Question

Find the number connected component in the undirected graph. Each node in the graph contains a label and a list of its neighbors. (a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)
Notice
Each connected component should sort by label.
Clarification
Learn more about representation of graphs
Example
Given graph:
A------B  C
 \     |  |
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}

public class Solution {
	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
		List<List<Integer>> res = new ArrayList<>();
		if(nodes == null || nodes.size() == 0)	return res;
		Map<Integer, Boolean> visited = new HashMap<>();

		for(UndirectedGraphNode node: nodes) {
			visited.put(node.label, false);
		}

		for(UndirectedGraphNode node: nodes) {
			if(!visited.get(node.label)) {
				bfs(res, visited, node);
			}
		}

		return res;
	}

	private void bfs(List<List<Integer>> res, Map<Integer, Boolean> visited, UndirectedGraphNode node) {
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		queue.add(node);
		visited.put(node.label, true);
		while(!queue.isEmpty()) {
			UndirectedGraphNode temp = queue.poll();
			list.add(temp.label);
			for(UndirectedGraphNode neighbor: temp.neighbors) {
				if(!visited.get(neighbor.label)) {
					queue.offer(neighbor);
					visited.put(neighbor.label, true);
				}
			}
		}
		Collections.sort(list);
		res.add(list);
	}
}