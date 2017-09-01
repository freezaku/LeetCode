class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) {
            return b;
        } else if(b == null || b.length() == 0) {
            return a;
        }
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int acc = 0;
        String res = "";
        while(i >= 0 || j >= 0) {
            System.out.println(i + " " + j);
            int digit1 = i >= 0 ? a.charAt(i --) - '0' : 0;
            int digit2 = j >= 0 ? b.charAt(j --) - '0' : 0;
            int sum = digit1 + digit2 + acc;
            res = (sum % 2) + res;
            acc = sum / 2;
        }
        
        if(acc != 0) {
            res = "1" + res;
        }
        
        return res;
    }
}

/*
关于string的简单题，注意最后产生的进位的处理
*/