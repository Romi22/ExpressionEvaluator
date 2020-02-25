package operations;

import java.util.Stack;
import tokenize.Token;
import exceptions.DivideByZeroException;

public class Division implements ArithmeticOperations
{
 
    Stack<Token> stack=new Stack<Token>();
    double result;
    double a,b;
    
    public Division(final Stack<Token> stack)
    {
        this.stack = stack;
    }
    public void evaluate(final Stack<Token> stack)
    {
           a=Double.parseDouble(stack.pop().value);
           b=Double.parseDouble(stack.pop().value);

           if(a==0)
                throw new DivideByZeroException("Divide by zero error");
           result=b/a;
    }
    public double getResult()
    {
        return result;
    }
}