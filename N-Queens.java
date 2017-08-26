class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        if(n <= 0)  return res;
        
        search(res, new ArrayList<Integer>(), n);
        
        return res;
    }
    
    // 每层search代表每一行，从第一行开始，找到该行中那一列置为Q
    // cols每个index代表是哪一行，该index上的值代表是哪一列置为了Q
    private void search(ArrayList<ArrayList<String>> res, ArrayList<Integer> cols, int n) {
        if(cols.size() == n) {
            res.add(drawBoard(cols));
            return;
        }
        
        // 遍历每一列，找到合适的列，将该行该列置为Q
        for(int colIndex = 0; colIndex < n; colIndex ++) {
            // 判断在新一行的colIndex列放上Q，是否会产生冲突
            if(!isValid(cols, colIndex))    continue;
            cols.add(colIndex);
            search(res, cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    
    
    private boolean isValid(ArrayList<Integer> cols, int colIndex) {
        // 已经拥有Q的行数，将新一行colIndex列加上Q之后，是否会和之前的行产生冲突
        // 也代表当前Q加入的行的坐标(从0开始)
        int row = cols.size();
        // 遍历之前的每一行
        for(int rowIndex = 0; rowIndex < cols.size(); rowIndex ++) {
            // 第rowIndex行是否在colIndex位置有Q
            if(cols.get(rowIndex) == colIndex) {
                return false;
            }
            // 第rowIndex行的cols.get(rowIndex)的 / 方向是否有Q
            if(rowIndex + cols.get(rowIndex) == row + colIndex) {
                return false;
            }
            // 第rowIndex行的cols.get(rowIndex)的 \ 方向是否有Q
            if(rowIndex - cols.get(rowIndex) == row - colIndex) {
                return false;
            }
        }
        return true;
    }
    
    private ArrayList<String> drawBoard(ArrayList<Integer> cols) {
        ArrayList<String> list = new ArrayList<>();
        int n = cols.size();
        for(int i = 0; i < n; i ++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j ++) {
                if(cols.get(i) == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        
        return list;
    }
};

/*
令人窒息的蠢题.
看注释。
*/