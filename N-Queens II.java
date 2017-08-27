public class Solution {
    /*
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    private int res = 0;
    public int totalNQueens(int n) {
        // write your code here

        if(n <= 0){
        	return 0;
        }

        search(n, new ArrayList<>());
        return res;
    }
    private void search(int n, ArrayList<Integer> cols){
        if(cols.size() == n){
        	res++;
        	return;
        }
        for(int i=0;i<n;i++){
        	if(!isValid(cols, i)){
        		continue;
        	}
        	cols.add(i);
        	search(n, cols);
        	cols.remove(cols.size() - 1);
        }

    }
    private boolean isValid(ArrayList<Integer> cols, int column){
    	int row = cols.size();
    	for(int rowIndex = 0; rowIndex < cols.size(); rowIndex++){
    		if(cols.get(rowIndex) == column){
    			return false;
    		}
    		if(rowIndex + cols.get(rowIndex) == row + column){
    			return false;
    		}
    		if(rowIndex - cols.get(rowIndex) == row - column){
    			return false;
    		}

    	}
    	return true;
    }

    
};

/*
N-Queeens的简化版，不需要进行打印
*/