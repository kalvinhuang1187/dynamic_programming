import java.util.ArrayList;
//https://www.quora.com/What-are-the-top-10-most-popular-dynamic-programming-problems-among-interviewers

public class dp_longest_common_substring {
	// Time complexity: O( n^2 )
	// Space Complexity: O( n^2 )
	// cool step by step visualization: http://www.ideserve.co.in/learn/longest-common-substring

	public static ArrayList<String> commonSubstring(String S1, String S2) {
	 	Integer match[][] = new Integer[S1.length()][S2.length()];
	    
	    int len1 = S1.length(); 
	    int len2 = S2.length();
	    int max = Integer.MIN_VALUE;  
	    ArrayList<String> result = null;  
		        
        for (int i=0; i<len1; i++) {
        	
            for (int j=0; j<len2; j++) {
            	
                if (S1.charAt(i) == S2.charAt(j)) {
                	
                	// 1 char common substring
                    if ( i == 0 || j==0) {
                    	match[i][j] = 1;
                    }
                    // found common substring and increase count by 1
                    else {
                    	match[i][j] = match[i-1][j-1] + 1;
                    }
                    
                    //If you find a longer common substring re-initialize the max count and update the result list
                    if (match[i][j] > max) {
                        max =  match[i][j];
                        result = new ArrayList<String>();
                        result.add(S1.substring(i-max+1, i+1));  //substring starts at i-max+1 and ends at i
                    }
                    // else if you find a common substring with the same max length, store it in the list.
                    else if (match[i][j] == max) {
                        result.add(S1.substring(i-max+1, i+1));
                    }
                }
                // chars dont match
                else
                	match[i][j] = 0;
            }
        }
        return result;
    }
		    
		    
    public static void main(String args[])
    {
        ArrayList<String> result = commonSubstring("CLCL" , "LCLC" );
        for(String str: result)
        {
            System.out.println(str);
        }
        
        /*
         * example: str1= "CLCL", str2 = "LCLC"
         * grid: 
         * 					
         * 			C	L	C	L
         * 		L	0	1	0	1
         * 		C	1	0	2	0
         * 		L	0	2	0	3
         * 		C	1	0	3	0
         * 
         * how to read the table:
         * table is a literal character by character comparison
         * (0, 3): charAt(0) == charAt(3), aka L == C, false
         * (1, 3): charAt(1) == charAt(3), aka C == C, true
         * 		dynamic programming by taking top left corner and adding 1. So (0,1) + 1 = 2
         * 		and add substring to list
         * (3, 2): chartAt(3) == charAt(2), aka C == C, true
         * 		dynamic programming by taking top left corner and adding 1. So (2,1) + 1 = 3
         * 		and add substring to list
         * 
         */
    }
}
