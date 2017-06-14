public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        Stack<String> chrs = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        char[] arr = s.toCharArray();
        int i = 0;
        while(i < arr.length) {
            char chr = arr[i];
            if(Character.isDigit(chr)) {
                int num = 0;
                while(i < arr.length && Character.isDigit(arr[i])) {
                    num = num * 10 + (arr[i] - '0');
                    i ++;
                }
                i --;
                nums.push(num);
            } else if(Character.isLetter(chr) || chr =='[') {
                chrs.push(chr + "");
            } else if(chr == ']') {
                int count = nums.pop();
                String str = "";
                while(!chrs.peek().equals("[")) {
                    str = chrs.pop() + str;
                }
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < count; j ++) {
                    sb.append(str);
                }
                chrs.pop();
                chrs.push(sb.toString());
            }
            i ++;
        }
        String res = "";
        while(!chrs.isEmpty()) {
            res = chrs.pop() + res;
        }
        return res;
    }
}