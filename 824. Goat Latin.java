class Solution {
    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');
        String[] strs = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < strs.length; i++) {
            String str = strs[i];
            if (vowel.contains(str.charAt(0))) {
                sb.append(str).append("ma");
            } else {
                sb.append(str.substring(1, str.length())).append(str.charAt(0)).append("ma");
            }
            int count = i + 1;
            while (count-- > 0) {
                sb.append("a");
            }
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}