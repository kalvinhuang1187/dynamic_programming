/*
Given binary square matrix [n*n]. Find maximum integer value in a path
from top left to bottom right. We compute integer value using bits of
traversed path. We start at index [0,0] and end at index [n-1][n-1].
from index [i, j], we can move [i, j+1] or [i+1, j].
---
Examples:

Input : mat[][] = {{1, 1, 0, 1},
                   {0, 1, 1, 0},
                   {1, 0, 0, 1},
                   {1, 0, 1, 1}}
Output : 111
Explanation :
Path :   (0,0) -> (0,1) -> (1,1) -> (1,2) ->
         (2,2) -> (3,2) ->(4,4)
Decimal value : 1*(2^0) + 1*(2^1) + 1*(2^2) + 1*(2^3) +
                0*(2^4) + 1*(2^5) + 1*(2^6) = 111

*/

public class dp_max_dec_value_binary_matrix {
    // Time Complexity: O(n^2)
    // Space Complexity: O(n^2)
    // original code in c++: http://www.geeksforgeeks.org/maximum-decimal-value-path-in-a-binary-matrix/

    public static int max(int a, int b) {
        if (a >= b) return a;
        else return b;
    }

    public static int maximumDecimalValue(int mat[][], int n) {
    	
        int dp[][] = new int[n][n];

        // Check starting position
        if(mat[0][0] == 1)
            dp[0][0] = 1;	// 1*(2^0)

        // Compute binary path of first row of matrix and store DP result in dp[0][i] (first row)
        for (int y = 1; y < n; y++) {
            // previous result + 1*(2^i) 
            if (mat[0][y] == 1)
                dp[0][y] = (int) (dp[0][y-1] + Math.pow(2, y));
            // previous result + 0*(2^i)
            else
               dp[0][y] = dp[0][y-1];
        }
    	
        // Compute binary path of first col of matrix and store DP result in dp[i][0] (first col)
        for (int x = 1; x < n; x++) {
            // previous result + 1*(2^i)
            if (mat[x][0] == 1)
                dp[x][0] = (int) (dp[x-1][0] + Math.pow(2, x));
            // previous result + 0*(2^i)
            else
                dp[x][0] = dp[x-1][0];
        }

        // Traverse rest of matrix and compute max decimal value
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 1)
                    dp[i][j] = (int) (max(dp[i][j-1], dp[i-1][j]) + Math.pow(2, i+j));
                else
                    dp[i][j] = (int) (max(dp[i][j-1], dp[i-1][j]));
            }
        }

        return dp[n-1][n-1];
    }

    public static void main(String args[]) {
        int mat[][] = { { 1, 1, 0, 1},
                        { 0, 1, 1, 0},
                        { 1, 0, 0, 1},
                        { 1, 0, 1, 1},
                        };

        System.out.print(maximumDecimalValue(mat, 4));
    }
}
