Find the number Weak Connected Component in the directed graph. Each node in the graph contains a label and a list of its neighbors. (a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)

Example

Given graph:

A----->B  C
 \     |  | 
  \    |  |
   \   |  |
    \  v  v
     ->D  E <- F
Return {A,B,D}, {C,E,F}. Since there are two connected component which are {A,B,D} and {C,E,F}

Note

Sort the element in the set in increasing order



public class Solution {
	class WeightedUnionFind {
		Map<Integer, Integer> parent;
		Map<Integer, Integer> size;

		public WeightedUnionFind() {
			parent = new HashMap<>();
			size = new HashMap<>();
		}

		public void add(int node) {
			parent.put(node, node);
			size.put(node, 1);
		}

		public int find(int node) {
			int root = node;
			while(root != parent.get(root)) {
				root = parent.get(root);
			}
			while(node != root) {
				int next = parent.get(node);
				parent.put(node, root);
				node = next;
			}
			return root;
		}

		public void union(int nodeA, int nodeB) {
			int rootA = find(nodeA);
			int rootB = find(nodeB);
			int sizeA = size.get(rootA);
			int sizeB = size.get(rootB);
			if(sizeA > sizeB) {
				parent.put(rootB, rootA);
				size.put(rootA, sizeA + sizeB);
			} else {
				parent.put(rootB, rootA);
				size.put(rootB, sizeA + sizeB);
			}
		}
	}

	public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
		List<List<Integer>> res = new ArrayList<>();
		WeightedUnionFind uf = new WeightedUnionFind();

		for(DirectedGraphNode node: nodes) {
			uf.add(node.label);
		}

		for(DirectedGraphNode node: nodes) {
			for(DirectedGraphNode neighbor: node.neighbors) {
				uf.union(node.label, neighbor.label);
			}
		}

		Map<Integer, List<Integer>> components = new HashMap<>();
		for(DirectedGraphNode node: nodes) {
			int root = uf.find(node.label);
			if(!components.containsKey(root)) {
				components.put(root, new ArrayList<Integer>());
			}
			components.get(root).add(node.label);
		}

		for(List<Integer> list: components.values()) {
			res.add(list);
		}
		return res;
	}
}