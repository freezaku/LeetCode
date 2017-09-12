class Solution {
    public int hammingDistance(int x, int y) {
        int distance = 0;
        
        for(int i = 0; i < 32; i ++) {
            int digitx = ((x >> i) & 1);
            int digity = ((y >> i) & 1);
            if(digitx != digity) {
                distance ++;
            }
        }
        
        return distance;
    }
}

/*
基础bit问题
*/