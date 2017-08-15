public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i <= rowIndex; i ++) {
            res.add(1);
            int size = res.size();
            for(int j = size - 2; j > 0; j --) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        
        return res;
    }
}

/*
画图找关系
*/