public class Solution {
    /*
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if(strs == null || strs.length == 0)  return "";
        
        StringBuilder prefix = new StringBuilder(strs[0]);
        for(int i = 1; i < strs.length; i ++) {
            String str = strs[i];
            while(str.indexOf(prefix.toString()) != 0) {
                prefix.setLength(prefix.length() - 1);
            }
        }
        
        return prefix.toString();
    }
}