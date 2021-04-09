package final350_package;

/*Author: Vanessa Abrahams
 * Date: March 30, 2021
 * Project: Project 1 - Prefix to Postfix Conversions
 * Description: This class converts expressions from prefix to postfix and viceversa. 
 */

import java.util.*;

public class Converter {
	// for Prefix to Postfix
    public String parsePrefixToPostfix(String exp) throws SyntaxError {
    	if (exp.length() == 0) {
    		throw new SyntaxError("No expression has been entered.");
    	}
        //parser accepts user input into exp
    	Scanner parser = new Scanner(exp);
        int element;
        String operator;
        String entity;
        String postfixExpression = "";        
        String firstOperand, secondOperand;
        int result = 0;
        
        //tokenize prefix string and set up 2 stacks
        Stack<String> operandStack = new Stack<String>();
        Stack<String> reverseOperatorStack = new Stack<String>();
        //while statement to push onto the reversal stack if there are more tokens
        while (parser.hasNext()) {
            entity = parser.next();
            // unless there is a space
            if (!entity.equals(" "))
                reverseOperatorStack.push(entity);
        }
        try {        
        	// while statement to pop to reversal stack if it is not empty
        	while (!reverseOperatorStack.isEmpty()) {
                //peek to retrieve the token at the top of the stack
        		entity = reverseOperatorStack.peek();
        		//pop to take the token off the stack
	            reverseOperatorStack.pop();
	                 
	            // if it is an operand
	            if (Character.isDigit(entity.charAt(0))) {
	            	//push token onto the operand stack
	            	operandStack.push(entity);
	            }
	            // if it is an operator
	            else if (entity.equals("/") || entity.equals("*") 
	            		|| entity.equals("+") || entity.equals("-")) {
	            	//retrieve, then pop first operand off the stack
	            	firstOperand = operandStack.peek();
	                operandStack.pop();
	                //retrieve, then pop second operand off the stack
	                secondOperand = operandStack.peek();
	                operandStack.pop();
	                // formats miniExpression String with the 2 operands followed by the operator    
	                String miniExpression = firstOperand + " " +  secondOperand + " " + entity;
	                //push the string onto the operand stack
	                operandStack.push(miniExpression);
	            }
        	}
  	      //throws error if there is an incorrect entry improperly formatted  	
        } catch (Exception e) {
            throw new SyntaxError("You have entered an improper expression. Check your input.");
        }
        //retrieve, then pop the postfix expression off the stack
        postfixExpression = operandStack.peek();
        operandStack.pop();
        //return postfix - holding the converted expression
        return postfixExpression; 
    }    
    // for Postfix to Prefix
    public String parsePostfixToPrefix(String exp) throws SyntaxError {
    	// throws error message if there is no expression entered
    	if (exp.length() == 0) {
    		throw new SyntaxError("No expression has been entered.");
    	}
        Scanner parser = new Scanner(exp);
        String entity;
        //tokenize the string containing the postfix expression
        Stack<String> operandStack = new Stack<String>();
        String firstOperand, secondOperand;
        // try-catch to validate data has been entered
        try {
	        	//while there are more tokens
        		while (parser.hasNext()) {
	            entity = parser.next();
	            // if it is a space, skip it
	            if (entity.equals(" "));
	            // if it is a operand, push it onto the operand stack
	            if (Character.isDigit(entity.charAt(0)))
	                operandStack.push(entity);
	            // if it is an operator
	            else if (entity.equals("/") || entity.equals("*") 
	                        || entity.equals("+") || entity.equals("-")) {
	            	//retrieve, then pop operand 1 off the operand stack
	            	secondOperand = operandStack.peek();
	                operandStack.pop();
	                //retrieve, then pop operand 2 off the operand stack
	                firstOperand = operandStack.peek();
	                operandStack.pop();
	                // formats miniExpression String with the operator followed by 2 operands
	                String miniExpression = entity + " " + firstOperand + " " +  secondOperand;
	                //push the miniExpression string onto the operand stack
	                operandStack.push(miniExpression);
	            }
	        }
	      //throws error if there is an incorrect entry improperly formatted  	
        } catch (Exception e) {
        	throw new SyntaxError("You have entered an improper expression. Check your input.");
        }
        //retrieve, then pop the prefix expression off the operand stack
        String prefix = operandStack.peek();
        operandStack.pop();
        //return prefix - holding the converted expression
        return prefix;
    }
}


















