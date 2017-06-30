private class WeightedUnionFind {
	Map<Integer, Integer> parent;
	Map<Integer, Integer> size;
	boolean hasCycle;
	int count;
	public WeightedUnionFind(int n) {
		parent = new HashMap<>();
		size = new HashMap<>();
		hasCycle = false;
		count = n;

		for(int i = 0; i < n; i ++) {
			parent.put(i, i);
			size.put(i, 1);
		}
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

		if(rootA == rootB) {
			hasCycle = true;
			return;
		}

		int sizeA = size.get(rootA);
		int sizeB = size.get(rootB);

		if(sizeA > sizeB) {
			parent.put(rootB, rootA);
			size.put(roota, sizeA + sizeB);
		} else {
			parent.put(rootA, rootB);
			size.put(rootB, sizeA + sizeB);
		}
		count --;
	}

	public boolean hasCycle {
		return this.hasCycle;
	}

	public boolean isTree {
		return (!this.hasCycle) && (count == 1);
	}
}