
public class dp_min_edit_btwn_two_str {
	// Time Complexity: O(len1 x len2)
	// Space Complexity: O(len1 x len2)
	// http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/

	public static int min(int x,int y,int z)
    {
        if (x < y && x <z) return x;
        if (y < x && y < z) return y;
        else return z;
    }
	
	static int editDistDP(String str1, String str2)
    {
		int len1 = str1.length();
		int len2 = str2.length();
        // Create a table to store results of subproblems
        int dp[][] = new int[len1+1][len2+1];
      
        // Fill d[][] in top down manner
        for (int i=0; i<=len1; i++)
        {
            for (int j=0; j<=len2; j++)
            {
                // If first string is empty, only option is to insert all characters of second string
                if (i==0) {
                	System.out.println("in i==0");
                    dp[i][j] = j;  // Min. operations = j
                }
                // If second string is empty, only option is to remove all characters of second string
                else if (j==0) {
                	System.out.println("in j==0");
                    dp[i][j] = i; // Min. operations = i
                }
                // If last characters are same, ignore last char and recur for remaining string
                else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                	System.out.println("in else if, comparing: " + str1.charAt(i-1) + " and " + str2.charAt(j-1));
                    dp[i][j] = dp[i-1][j-1];
                }
                // If last character are different, consider all possibilities and find minimum
                else {
                	System.out.println("in else, comparing: " + str1.charAt(i-1) + " and " + str2.charAt(j-1));
                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert
                                       dp[i-1][j],  // Remove
                                       dp[i-1][j-1]); // Replace
                }
                System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
                
            }
        }
  
        return dp[len1][len2];
    }
	
	public static void main(String args[])
    {
        String str1 = "abc";
        String str2 = "zbc";
        System.out.println( editDistDP( str1 , str2 ));
        
        /*
         * example: str1= "abc", str2 = "zbc"
         * grid: 
         * 					
         * 				a	b	c
         * 			0	1	2	3
         * 		z	1	1	2	3
         * 		b	2	2	1	2
         * 		c	3	3	2	1
         * 
         * how to read the table:
         * 0th row is if str2 is empty and we have to insert all chars
         * 0th col is if str1 is empty and we have to delete all chars
         * (z, b) => comparing "z" to "ab", so 1 replace and 1 insertion => 2
         * (b, c) => comparing "zb" to "abc", so 1 replace and 1 insertion => 2
         * (c, c) => comparing "zbc" to "abc", so just 1 replace => 1
         * 
         * 
         * example: str1 = "kitten", str2 = "sittig"
         * grid:
         * 				k	i	t	t	e	n
         * 			0	1   2   3   4   5	6
         * 		s	1 	1	2	3	4	5	6
         * 		i	2	2	1	2	3	4	5
         * 		t	3	3	2	1	2	3	4
         * 		t	4	4	3	2	1	2	3
         * 		i	5	5	4	3	2	2	3
         * 		g	6	6	5	4	3	3	3
         * 
         */
    }

}
