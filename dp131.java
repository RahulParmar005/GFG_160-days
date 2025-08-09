// You are given a boolean expression s containing
//     'T' ---> true
//     'F' ---> false 
// and following operators between symbols
//    &   ---> boolean AND
//     |   ---> boolean OR
//    ^   ---> boolean XOR
// Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

// Note: The answer is guaranteed to fit within a 32-bit integer.


// User function Template for Java
class Solution {
    static int countWays(String s) {
        // code here
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        
        for(int i = 0; i < n; i += 2) {
            dp[i][i][1] = (s.charAt(i) == 'T') ? 1 : 0;
            dp[i][i][0] = (s.charAt(i) == 'F') ? 1 : 0;
        }
        
        for(int len = 2; len < n; len += 2) {
            for(int i = 0; i < n - len; i += 2) {
                int j = i + len;
                dp[i][j][0] = dp[i][j][1] = 0;
                
                for(int k = i + 1; k < j; k += 2) {
                    char op = s.charAt(k);
                    
                    int leftTrue = dp[i][k - 1][1], leftFalse = dp[i][k - 1][0];
                    int rightTrue = dp[k + 1][j][1], rightFalse = dp[k + 1][j][0];
                    
                    if(op == '&') {
                        dp[i][j][1] += leftTrue * rightTrue;
                        dp[i][j][0] += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                    } else if(op == '|') {
                        dp[i][j][1] += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                        dp[i][j][0] += leftFalse * rightFalse;
                    } else if(op == '^') {
                        dp[i][j][1] += leftTrue * rightFalse + leftFalse * rightTrue;
                        dp[i][j][0] += leftTrue * rightTrue + leftFalse * rightFalse;
                    }
                    
                }
            }
        }
        
        return dp[0][n - 1][1];
    }
    
}