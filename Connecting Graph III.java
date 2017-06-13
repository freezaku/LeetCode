public class ConnectingGraph3 {
	Map<Integer, Integer> parent;
	Map<Integer, Integer> size;
	int count;
	public ConnectingGraph3(int n) {
		parent = new HashMap<>();
		size = new HashMap<>();
		count = n;
		for(int i = 1; i <= n; i ++) {
			parent.put(i, i);
			size.put(i, 1);
		}
	}

	public void connect(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) {
			return;
		}
		int sizeA = size.get(rootA);
		int sizeB = size.get(rootB);
		if(sizeA > sizeB) {
			parent.put(rootB, rootA);
			size.put(rootA, sizeA + sizeB);
		} else {
			parent.put(rootA, rootB);
			size.put(rootB, sizeA + sizeB);
		}
		count --;
	}

	public int query(int a) {
		return count;
	}

	private int find(int node) {
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
}