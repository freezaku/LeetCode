class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A)*(D - B);
        int area2 = (G - E)*(H - F);
        if(A >= G || B >= H || C <= E || D <= F){
            return area1 + area2;
        }
        return area1 + area2 - (Math.min(H, D)-Math.max(F, B))*(Math.min(C, G) - Math.max(A, E));
    }
}