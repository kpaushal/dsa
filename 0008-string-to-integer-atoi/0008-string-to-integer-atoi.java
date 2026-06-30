public class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int index = 0;
        // Step 1: Skip whitespace
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        
        if (index >= s.length()) return 0;
        
        // Step 2: Handle sign
        int sign = 1;
        if (s.charAt(index) == '+') {
            index++;
        } else if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        
        // Step 3: Build number with overflow check
        long result = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            
            // Overflow check before update
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            index++;
        }
        
        return (int) (result * sign);
    }
}
