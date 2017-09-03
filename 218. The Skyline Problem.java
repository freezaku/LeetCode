class Solution {
    class Height {
        int x;
        int h;
        public Height(int x, int h) {
            this.x = x;
            this.h = h;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        
        int n = buildings.length;
        Height[] heights = new Height[2 * n];
        for(int i = 0; i < n; i ++) {
            int[] building = buildings[i];
            heights[2 * i] = new Height(building[0], -building[2]);
            heights[2 * i + 1] = new Height(building[1], building[2]);
        }
        
        Arrays.sort(heights, new Comparator<Height>() {
            public int compare(Height a, Height b) {
                if(a.x != b.x) {
                    return a.x - b.x;
                } else {
                    return a.h - b.h;
                }
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            }
        );
        pq.offer(0);
        int prev = 0;
        
        for(Height height: heights) {
            if(height.h < 0) {
                pq.offer(-height.h);
            } else {
                pq.remove(height.h);
            }
            
            int cur = pq.peek();
            if(cur != prev) {
                res.add(new int[]{height.x, cur});
                prev = cur;
            }
        }
        
        return res;
    }
}

/*
构造Height类，x代表坐标，h代表高度。
将buildings中每个元素取出，根据左边界和右边界，分别利用负和正的高度构造Height类，放入数组。
这样就能区分开来左右边界。
对heights进行排序，保证左边界先于右边界出现，同时高度较低的在前。
构造maxHeap，并放入初始值0，代表始终有一个高度为0的地面，处理其他情况。

遍历heights数组，若遇到h < 0的情况，说明遇到新的左边界，将其对应正值加入pq，
否则说明遇到右边界，将其对应高度h移出pq，
cur为pq的peek，也是当前最高的点，
若cur != prev，说明最高点发生改变，res中需要加入新的线段，同时更新prev。
*/