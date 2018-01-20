
/*
 CIS 209: INTRO TO JAVA
 CHAPTER 6 PROJECT 
 CREDIT CARD VALIDATION PROGRAM
 */

import java.util.Scanner;

/*VALIDATION CLASS*/
public class Validation {

	/*MAIN METHOD*/
	public static void main(String []args)
	{
		/*DECLARE INPUT SCANNER*/
	    Scanner input = new Scanner(System.in); 
		/*PROMPTS USER TO ENTER CREDIT CARD NUMBER*/
	    System.out.print("Enter a credit card number with the length of an integer: ");
	    /*CREATES NUMBER VARIABLE*/
	    long number = input.nextLong();
	    /*PRINTS OUT VALID OR NOT VALID*/
	    System.out.println(number + " is " + (isValid(number) ? "valid" : "invalid" ));
	     	
	}
	
	 /*IS VALID METHOD: NUMBER PARAMETER*/
	 public static boolean isValid(long number)
     {
		 /*CHECKS TO SEE IF NUMBERS ARE VALID WITHIN LIMITS*/
    	 boolean valid = 
    			 (getSize(number) >= 13 && getSize(number) <= 16) && 
    			 (prefixMatched(number, 4) || prefixMatched(number, 5) || 
    			  prefixMatched(number, 37) || prefixMatched(number, 6)) && 
    			 ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0); 
    			 /*RETURN VALID*/
    			 return valid; 
     }
	 /*SUM OF DOUBLE EVEN METHOD: NUMBER PARAMETER*/
	 public static int sumOfDoubleEvenPlace(long number)
	 {   /*SUM INTEGER SET TO 0*/
		 int sum = 0; 
		 /*STRING NUMB*/
		 String numb = number + "";
		 /*FOR LOOP: GET SIZE*/
		 for (int i = getSize(number) - 2; i >= 0; i -= 2)
		 {
			 /*SUM: GET DIGIT PARSED NUMB VARIABLE*/
			 sum += getDigit(Integer.parseInt(numb.charAt(i) + "") * 2);
		 }
		 /*RETURNS SUM*/
		 return sum; 
	 } 
		 
	   /*GET DIGIT METHOD: NUMBER PARAMETER*/ 
	   public static int getDigit(int number)
	   {
		   /*IF NUMBER STATEMENT*/
		   if (number <= 9)
		   {
			   /*RETURNS NUMBER*/
			   return number;
		   }
		   else 
		   {
			   /*RETURNS NUMBER FORMULA*/
			   return number / 10 + number % 10; 
		   }
		   
	   }
	   
	   
	   
	   /*SUM OF ODD PLACE METHOD: NUMBER PARAMETER*/
	 public static int sumOfOddPlace(long number)
	 {
		 /*SUM SET TO 0*/
		 int sum = 0; 
		 /*STRING NUMB*/
		 String numb = number + ""; 
		 /*FOR LOOP: GET SIZE*/
		 for (int i = getSize(number) - 1; i >= 0; i -= 2)
		 {
			 /*SUM INTEGER STATEMENT*/
			 sum += Integer.parseInt(numb.charAt(i) + "");
		 }
		 /*RETURNS SUM*/
		 return sum;  
	 }
	 
	
	 /*BOOLEAN PREFIX MATCHED METHOD: NUMBER, D PARAMETERS*/
	public static boolean prefixMatched(long number, int d)
	{
		/*GET PREFIX RETURNED WITH GET SIZE D*/
		return getPrefix(number, getSize(d)) == d; 
		
	}	
		/*GET SIZE METHOD: D PARAMETER*/
		public static int getSize(long d)
		{
			/*STRING NUMB D*/
			String numb = d + "";
			/*RETURN NUMB LENGTH*/
			return numb.length(); 
		}
		
	 /*LONG GET PREFIX METHOD: NUMBER, K PARAMETERS*/
	 public static long getPrefix(long number, int k)
	 {
		/*GET SIZE NUMBER STATEMENT*/
		 if (getSize(number) > k)
		 {
			/*STRING NUMB STATEMENT*/
			String numb = number + "";
			/*RETURNS PARSED LONG SUBSTRING*/
			return Long.parseLong(numb.substring(0, k));
		 }
		    /*RETURNS NUMBER VARIABLE*/
		    return number; 
	 } 
}
