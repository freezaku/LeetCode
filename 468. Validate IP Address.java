public class Solution {
    public String validIPAddress(String IP) {
        if(IP.indexOf(".") != -1) {
            return checkIP4(IP);
        } else if(IP.indexOf(":") != -1) {
            return checkIP6(IP);
        } else {
            return "Neither";
        }
    }
    
    private String checkIP4(String IP) {
        if(IP.charAt(IP.length() - 1) == '.' || IP.charAt(0) == '.')    return "Neither";
        String[] strs = IP.split("\\.");
        if(strs.length != 4)    return "Neither";
        for(String str: strs) {
            if(!isValidIP4(str))    return "Neither";
        }
        return "IPv4";
    }
    private boolean isValidIP4(String str) {
        if(str.length() == 0) return false;
        if(str.length() > 1 && str.charAt(0) == '0' || str.length() > 3)    return false;
        for(char chr: str.toCharArray()) {
            if(!Character.isDigit(chr))    return false;
        }
        int num = Integer.valueOf(str);
        if(num < 0 || num > 255)    return false;
        return true;
    }
    
    private String checkIP6(String IP) {
        if(IP.length() < 15) return "Neither";
        if(IP.charAt(IP.length() - 1) == ':' || IP.charAt(0) == ':')    return "Neither";
        String[] strs = IP.split(":");
        if(strs.length != 8)    return "Neither";
        for(String str: strs) {
            if(!isValidIP6(str))    return "Neither";
        }
        return "IPv6";
    }
    private boolean isValidIP6(String str) {
        if(str.length() == 0)    return false;
        if(str.length() > 4)    return false;
        for(char chr: str.toCharArray()) {
            if(Character.isLetter(chr)) {
                if("abcdefABCDEF".indexOf(chr) == -1) {
                    return false;
                }
            } else if(!Character.isDigit(chr)) {
                return false;
            }
        }
        return true;
    }
}

/*
题目本身很直观简单，
但是需要考虑的情况太多太复杂了，不是个好题目，怪不得点灭这么多
*/