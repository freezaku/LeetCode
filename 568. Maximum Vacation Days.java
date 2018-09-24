class Solution {
    int[][] memo;
    public int maxVacationDays(int[][] flights, int[][] days) {
        int res = 0;
        memo = new int[flights.length][days.length];
        for (int[] arr : memo) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        
        return dfs(flights, days, 0, 0);
    }
    private int dfs(int[][] flights, int[][] days, int cur_city, int cur_week) {
        if (cur_city == days.length || cur_week == days[0].length) {
            return 0;
        }
        
        if (memo[cur_city][cur_week] != Integer.MIN_VALUE) {
            return memo[cur_city][cur_week];
        }
        int maxvac = 0;
        for (int i=0; i < days.length; i++) {
            if (flights[cur_city][i] == 1 || i == cur_city) {
                // 想想起点是(city, week) -> (0,0), 但是week 0也不需要待在city 0
                // 因此，+days[i][cur_week]，表示的是，cur_week在city i度过，如果+days[cur_city][cur_week]
                // 对于(0,0)来说，只能在city 0度过了
                maxvac = Math.max(maxvac, days[i][cur_week] + dfs(flights, days, i, cur_week+1)); 
            }
        }
        memo[cur_city][cur_week] = maxvac;
        return maxvac;
    }
}