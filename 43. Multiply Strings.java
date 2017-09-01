class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        
        for(int i = m - 1; i >= 0; i --) {
            int digit1 = num1.charAt(i) - '0';
            for(int j = n - 1; j >= 0; j --) {
                int digit2 = num2.charAt(j) - '0';
                res[i + j + 1] += digit1 * digit2;
            }
        }
        
        int acc = 0;
        for(int i = m + n - 1; i >= 0; i --) {
            int sum = res[i] + acc;
            res[i] = sum % 10;
            acc = sum / 10;
        }
        
        int start = 0;
        while(start < m + n - 1 && res[start] == 0) {
            start ++;
        }
        
        StringBuilder sb = new StringBuilder();
        while(start < res.length) {
            int digit = res[start];
            sb.append(String.valueOf(digit));
            start ++;
        }
        
        return sb.toString();
    }
}

/*
利用乘法计算的特点。
两数相乘所得长度不会超过两数长度相加，因此设结果总长为maxLength = num1.length() + num2.length();
从右往左进行计算，用一个长度为maxLength的数组存储每个数，由于一直在相乘，所以不断更新该位的值，并把所得的进位放入carry。
结果去除从左往右为0的数，直到找到不为0的进行append。
*/