class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input == null || input.length() == 0)    return res;
        
        for(int i = 0; i < input.length(); i ++) {
            char chr = input.charAt(i);
            if(chr == '+' || chr == '-' || chr == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1Res = diffWaysToCompute(part1);
                List<Integer> part2Res = diffWaysToCompute(part2);
                
                for(Integer p1: part1Res) {
                    for(Integer p2: part2Res) {
                        if(chr == '+') {
                            res.add(p1 + p2);
                        } else if(chr == '-') {
                            res.add(p1 - p2);
                        } else {
                            res.add(p1 * p2);
                        }
                    }
                }
            }
        }
        
        if(res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        
        return res;
    }
}