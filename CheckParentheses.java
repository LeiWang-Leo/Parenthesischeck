// Lei Wang
// CIS 2353 // Winter 2018
// Prof. John P. Baugh

import java.util.*;



public class CheckParentheses {

	public static void main(String[] args) throws Exception {
		//input the parentheses;
		System.out.println("Please input the parentheses: ");
		Scanner input=new Scanner(System.in);
		String str1=input.nextLine();
		//Call the isValid method to valid the parentheses are well-formed or not;
		if(isValid(str1)==false)
		{
			System.out.println("The parentheses is not well-formed!");
		}
		else if (isValid(str1)==true){
		System.out.println("The parentheses is well-formed!");
		}
		input.close();
	}
//valid the parentheses are well-formed or not; 
	private static boolean isValid(String str) throws Exception {
		//define OPEN and CLOSE with open parentheses and close parentheses in string type;
		String OPEN="([{"; String CLOSE = "}])";
		//create st object of Stack in Character type;
		Stack<Character> st= new Stack<Character>();
		//go through every character of the string;
		for(int i=0;i<str.length();i++)
		{
			//if the character is a open parenthesis, compare it with OPEN string, 
			//if it is included, push the character into stack;
			if (OPEN.indexOf(str.charAt(i))>=0)
			{
				st.push(str.charAt(i));
			}
			//if the character is a close parenthesis, compare it with CLOSE string,
			//if it is included, execute the following statements;
			if (CLOSE.indexOf(str.charAt(i))>=0)
			{
				//if the size of stack is great than 0, 
				if(st.size()>0)
				{
					//if the open parenthesis and the close parenthesis are not matching,
					//return false;
					if (!(isParenthesesMatching(st.pop(),str.charAt(i))))
					return false;
				}
				//when the close parenthesis is met, if the stack is empty, 
				//the exception is going to be thrown;
				else
					throw new Exception("the close parenthese is prior to open parenthese!"); 
			}
			
		}
		// when the end of the input is reached, if the stack is empty, return true,
		//if the stack is not empty, return false;
		if (st.empty()) {
		return true;
		}else
		{
			return false;
		}
		
	}
//check whether the open parenthesis in the stack and 
//the close parenthesis in the string are matched or not;
//if they are matched, return true, otherwise return false;
	private static boolean isParenthesesMatching(char c1, char c2) {
		if(c1=='{'&&c2=='}') 
		{
			return true;
		}
		if(c1=='['&&c2==']') 
		{
			return true;
		}
		if(c1=='('&&c2==')') 
		{
			return true;
		}
		
		return false;
	}
}
