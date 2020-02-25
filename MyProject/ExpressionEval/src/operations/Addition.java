package operations;

import tokenize.Token;
import java.util.Stack;

public class Addition implements ArithmeticOperations
{
    Stack<Token> stack=new Stack<Token>();
    double result;
    double a,b;
    
    public Addition(final Stack<Token> stack)
     {
        this.stack = stack;
     }
    public void evaluate(final Stack<Token> stack)
    {
           a=Double.parseDouble(stack.pop().value);
           b=Double.parseDouble(stack.pop().value);

           result=a+b;
    }
    public double getResult()
    {
        return result;
    }
}