class Solution {
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
        
        public Integer find(Integer node) {
            if(!parent.containsKey(node))   return null;
            
            Integer root = node;
            while(root != parent.get(root)) {
                root = parent.get(root);
            }
            
            while(node != root) {
                Integer next = parent.get(node);
                parent.put(node, root);
                node = next;
            }
            
            return root;
        } 
        
        public void union(Integer nodeA, Integer nodeB) {
            Integer rootA = find(nodeA);
            Integer rootB = find(nodeB);
            if(rootA == null || rootB == null)  return;
            
            if(rootA.equals(rootB)) {
                hasCycle = true;
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
        
        public boolean hasCycle() {
            return this.hasCycle;
        }
        
        public boolean isTree() {
            return (!this.hasCycle) && (count == 1);
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        if(edges == null || edges.length == 0) {
            if(n > 1)   return false;
            return true;
        }
        
        WeightedUnionFind uf = new WeightedUnionFind(n);
        for(int[] edge: edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            uf.union(nodeA, nodeB);
        }
        
        return uf.isTree();
    }
}

/*
注意union find的标准class写法。
同时需要注意一个valid的tree，无圈，且每个node都有线相连，没有孤立的点
*/