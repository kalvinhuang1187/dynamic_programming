/*
Given a string S, find the longest palindromic substring.
*/

public class dp_longest_palindrome {
	// Time complexity: O( n^2 )
	// Space Complexity: O( n^2 )
	// cool step by step visualization: http://www.ideserve.co.in/learn/longest-palindromic-substring
			    
    public static String LPS(String s) {
    	// get length of input string
        int n = s.length();
        
        int palindromeBeginsAt = 0;  
        
        boolean palindrome[][] = new boolean[n][n];  
          
        // All substrings of length 1 are palindromes
        int max_len = 1;
        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;
        }
          
        // Check for substring of length 2    
        for (int i = 0; i < n-1; i++) {
        	if (s.charAt(i) == s.charAt(i+1)) {
        		palindrome[i][i+1] = true;
        		palindromeBeginsAt = i;
        		max_len = 2;
        	}
        }
          
        // Check for lengths greater than 2. pal_len is length of substring
        for (int pal_len = 3; pal_len <= n; pal_len++) {
        	// Fix the starting index i
        	for (int i = 0; i < n-pal_len+1; i++) {
        		// Get the ending index of substring from starting index i and length pal_len
        		int j = i+pal_len-1;
        		
            // checking for palindrome from i index to j index
            // palindrome[i+1][j-1] is checking between starting and ending char is a palpindrome
            // ex: (1,5) => "anana", palindrome[i+1][j-1] is checking if "nan" is already T
        		if (s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]) {
        			palindrome[i][j] = true; 
        			palindromeBeginsAt = i;
        			max_len = pal_len;
        		}
        	}
        }
        return s.substring(palindromeBeginsAt, max_len + palindromeBeginsAt);
    }

    public static void main(String args[]) {
    	System.out.println(LPS("banana" ));
        
        /*
         * example: "banana"
         * grid:    0   1   2   3   4   5
         *      0   T   F   F   F   F   F
         *      1   F   T   F   T   F   T
         *      2   F   F   T   F   T   F
         *      3   F   F   F   T   F   T
         *      4   F   F   F   F   T   F
         *      5   F   F   F   F   F   T
         * 
         * how to read the table:
         * vertical axis(y) is char starting location
         * horizontal axis(x) is looking at palindrome up to that char position
         * ex (3,5): starting at char 3 (a) going up to char 5 (a), is "ana" a palindrome, T
         * we are really looking above the diagonal axis. It is impossible for anythign below that to be true
         */
    }
}
