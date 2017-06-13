public class ConnectingGraph {
	Map<Integer, Integer> parent;

	public ConnectingGraph(int n) {
		parent = new HashMap<>();
		for(int i = 1; i <= n; i ++) {
			parent.put(i, i);
		}
	}

	public void connect(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) {
			return;
		}
		parent.put(rootA, rootB);
	}

	public boolean query(int a, int b) {
		return find(a) == find(b);
	}

	private int find(int node) {
		int root = node;
		while(root != parent.get(root)) {
			root = parent.get(root);
		}
		return root;
	}
}