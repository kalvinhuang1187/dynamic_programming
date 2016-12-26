import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class first_program {
 
    static void printlist(int a, int b)
    {
        if (a > b)
            return;
         
        System.out.println("value: " + a);
        printlist (a*2, b);
        System.out.println("value: " + a);    
    } 
    static long fib(int i) {
        double phi = 1.618;// Golden Ratio
        return Math.round((Math.pow(phi, i) - Math.pow(-phi, -i)) / Math.sqrt(5));
    }
    
    
    public static int solution(int N) {
        // write your code in Java SE 8
    	int half;
    	if (N%2 == 0)
    		half = N/2;
    	else
    		half = N/2 + 1;
    	System.out.println("half" + half);
    	int start = 1;
    	int c = 1;
    	int i = 1;
    	while (i < half){
    		if (i<half) {
    			i *=2;
    			c++;
    		}
    	}
    	System.out.println("c " + c);
    	int diff = N - i;
    	
    	
    	System.out.println(diff);
    	c += diff;
    	System.out.println("final " + c);
    	return c;
    	/*
    	if (N%2 == 0)
    		half = N/2 ;
    	else
        
    		
        int[] arr = new int[half];
        
        System.out.println("half: " + half);
        arr[0] = 1;
        int count = 0;
        while (arr[count] < half){
        	count++;
        	System.out.println("count" + count);
        	
            arr[count] = arr[count-1] * 2;
        	System.out.println("arr[count]" + arr[count] + " half:  " + half);
            
        }    
        
        
        while (count <= N) {
        	count++;
            
            arr[count] = arr[count-1] + 1;
            System.out.println("secondhalf: " + arr[count]);
        }
        return arr.length;
        */
    }
    
    
    public static boolean allStringSetsIdentical(String[ ][ ] sets) {
    	Set<String> mySet = null;
    	Set<String> finalSet = new HashSet<String>();
    	
    	for (String[] str : sets) {
    		mySet = new HashSet<String>(Arrays.asList(str));
    		System.out.println("mySet" + mySet);
    			
    		StringBuilder sb = new StringBuilder();
    	    for(String s: mySet) {
    	        sb.append(s); 
    	    }
    	    String temp = sb.toString();
    	    System.out.println("combine: " + temp);
    		
    		boolean b = finalSet.add(temp);
    		if (!b)
    			return true;
    		
    		System.out.println("finalSet" + finalSet);
    	}
    	return false;
    }
    
    public static String wrap(String str,int len) {
    	str = str.trim();
    	if(str.length() < len)
    		return str;
    	
    	if(str.substring(0, len).contains("\n"))
    		return str.substring(0, str.indexOf("\n")).trim() + "\n" + wrap(str.substring(str.indexOf("\n") + 1), len);
    	
    	int space = str.lastIndexOf(" ", len);
    	return str.substring(0,space).trim() + "\n" + wrap(str.substring(space),len);
    }
    
    //shrink the random number generator as you delete the node with that number
    public static void generateRandomNumber1(int size) {

      ArrayList<Integer> list = new ArrayList<Integer>(size);
      for(int i = 1; i <= size; i++) {
        list.add(i);
      }

      Random rand = new Random();
      while(list.size() > 0) {
        int index = rand.nextInt(list.size());
        System.out.println("Selected: " + list.remove(index));
      }
    }
    
  //shuffle an array of numbers and take the first 10
    public static void generateRandomNumber2(int endRange) {

      ArrayList<Integer> randomNumber = new ArrayList<Integer>(endRange);

      for (int i = 0; i<= endRange; i++) {                
        randomNumber.add(i);
      }

      Collections.shuffle(randomNumber);

      for (int i = 0; i<= 10; i++) {                      
    	  System.out.println("Random Number " + i + ": " + randomNumber.get(i));
      }
    }
    
    public static void main(String[] args) 
    { 
    	
    	//generateRandomNumber1(50);
    	generateRandomNumber2(50);
    	
    	//IXL
    	//boolean b = allStringSetsIdentical(new String[][] {{"a","b"},{"a"},{"b"}});
    	//System.out.println("FINAL ANSWER: " + b);
    	
    	//String s = wrap("Triometric \n creates unique end", 20);
    	//System.out.println(s);
    	
        //printlist(240, 2000);
        //240, 480, 960, 1920, 1920, 960, 40, 240
    	/*
    	String s = "8";
    	int num = s.charAt(0) - '0';
    	System.out.println(num);
    	
    	//1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    	//1  2  3  4  5  6  7   8   9   10
    	System.out.println("FIB:");
    	long n = fib(9);
    	System.out.println("fib n:" + n);
    	*/
    	
    	
    	/**** toCharArry with is another way of chatAt ****/
    	/*
    	String str = new String("Hello World");
        char[] array = str.toCharArray();
        System.out.print("Content of Array: ");
        for(int i = 0; i < str.length(); i++) {
        	System.out.println(str.charAt(i));
        }
        for(char c: str){
            System.out.print(c);
        }
        */
        
        /**** Arrays.sort(arr) ****/
        /*
        int[] arr = {2, 6, 4, 8};
        for (int number : arr) {
          System.out.println("Number = " + number);
        }
        //sort an array
        Arrays.sort(arr);
        
        System.out.println("The sorted int array is:");
        for (int number : arr) {
          System.out.println("Number = " + number);
        }
    	*/
        
        /**** toString ****/
        /*
        Integer x = 5;

        System.out.println(x.toString());  
        System.out.println(Integer.toString(12)); 
    	*/
    } 
  
}