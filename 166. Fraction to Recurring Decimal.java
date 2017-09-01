class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)  return "0";
        int flag = -1;
        if(numerator > 0 && denominator > 0 || numerator < 0 && denominator < 0) {
            flag = 1;
        }
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        long firstPart = num / den;
        long remain = num % den;
        
        String str1 = (flag == 1 ? "" : "-") + (firstPart == 0 ? "0" : String.valueOf(firstPart));
        if(remain == 0) {
            return str1;
        }
        
        str1 = str1 + ".";
        
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        
        int index = 0;
        while(remain != 0 && !map.containsKey(remain)) {
            map.put(remain, index);
            long digit = remain * 10;
            sb.append(String.valueOf(digit / den));
            remain = digit % den;
            index ++;
        }

        if(remain == 0) {
            return str1 + sb.toString();
        }
        
        String str = sb.toString();
        int left = map.get(remain);
        String str2 = str1 + str.substring(0, left) + "(" + str.substring(left) + ")";
        return str2;
    }
}

/*
自己的简陋做法
*/

public String fractionToDecimal(int numerator, int denominator) {
    StringBuilder result = new StringBuilder();
    String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
    long num = Math.abs((long) numerator);
    long den = Math.abs((long) denominator);
    result.append(sign);
    result.append(num / den);
    long remainder = num % den;
    if (remainder == 0)
        return result.toString();
    result.append(".");
    HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
    while (!hashMap.containsKey(remainder)) {
        hashMap.put(remainder, result.length());
        result.append(10 * remainder / den);
        remainder = 10 * remainder % den;
    }
    int index = hashMap.get(remainder);
    result.insert(index, "(");
    result.append(")");
    return result.toString().replace("(0)", "");
}

/*
比较精致的做法和分析。
其实按照除法的方法计算就行，但是有几点需要注意
1. 符号的确定，利用异或的方法，判断符号是"-"还是""，并append入sb

2. 数据类型的转化，确定符号之后，将numerator和denominator转化为long类型，再取绝对值

3. map中存储余数和当前sb的长度

3. 整数部分获得的余数，在小数部分计算时，再加入map，所以第一个余数的位置一般为 整数部分长度 + 1

4. 当余数不为0的时候循环，当遇到重复的余数时，说明小数部分有了循环，在循环开始的位置加上"("，并append上")"

5. stringbuilder的插入使用insert(index, string)
*/