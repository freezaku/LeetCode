Given a (decimal - e.g. 3.72) number that is passed in as a string, return the binary representation that is passed in as a string. 
If the fractional part of the number can not be represented accurately in binary with at most 32 characters, return ERROR.

Have you met this question in a real interview? Yes
Example
For n = "3.72", return "ERROR".

For n = "3.5", return "11.1".

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        if(n.indexOf(".") == -1) {
            return parseInteger(n);
        }
        
        String[] params = n.split("\\.");
        
        String flt = parseFloat(params[1]);
        if(flt.equals("ERROR")) {
            return flt;
        }
        
        if(flt.equals("0") || flt.equals("")) {
            return parseInteger(params[0]);
        }
        
        return parseInteger(params[0]) + "." + flt;
    }
    
    private String parseFloat(String str) {
        double d = Double.parseDouble("0." + str);
        String binary = "";
        Set<Double> set = new HashSet<>();
        while(d > 0) {
            if(binary.length() > 32 || set.contains(d)) {
                return "ERROR";
            }
            set.add(d);
            d = d * 2;
            if(d >= 1) {
                binary = binary + "1";
                d = d - 1;
            } else {
                binary = binary + "0";
            }
        }
        
        return binary;
    }
    
    private String parseInteger(String str) {
        if(str.equals("") || str.equals("0"))   return "0";
        
        int n = Integer.parseInt(str);
        String binary = "";
        while(n != 0) {
            binary = (n % 2) + binary;
            n = n / 2;
        }
        return binary;
    }
}

/*
整数部分 / 2取余，从低位到高位
小数部分 * 2取余，从高位到低位，用hashset存储每次获得的数，若有重复，直接返回false，说明无法化为小数形式
*/