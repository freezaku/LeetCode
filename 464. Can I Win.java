public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= 0)   return true;
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if(sum < desiredTotal)  return false;

        int[] state = new int[maxChoosableInteger];
        Map<String, Boolean> map = new HashMap<>();

        return helper(desiredTotal, state, map);
    }
    
    private boolean helper(int total, int[] state, Map<String, Boolean> map) {
        if(total <= 0)  return false;
        String strState = Arrays.toString(state);

        if(map.containsKey(strState))   return map.get(strState);

        for(int i = 0; i < state.length; i ++) {
            if(state[i] == 0) {
                state[i] = 1;
                if(!helper(total - (i + 1), state, map)) {
                    map.put(strState, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }

        map.put(strState, false);
        return false;
    }
}

/*
这题的关键问题，在于每个数字选用状态的转化和传递。
用state数组存储每个数字的选用状态，
利用Arrays.toString(state)将其转化为对应的string作为key存入map，value是该state能否组成total的可能true/false，
进入helper函数中，判断strState是否在map中，若在直接返回对应value，
若不在，对state进行遍历处理，
选用还没被使用的数字，进行backtracking，
将其置为1表示使用，然后从total里面减去该数进入下一层helper，若返回的是false，则说明对方会失败，自己则会成功，
此时，将map中存入对应的strstate和true，还原state，直接返回true，
记住即使下一层helper没有返回false，也要讲state还原，
中间没有返回true，则将map中存入strstate和false，返回false
*/