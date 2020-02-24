package evaluator.helper;

import tokenize.Token;
import exceptions.FunctionException;
import java.util.List;
import java.util.Stack;
import java.lang.Math;
public class FunctionExpression 
{

    List<String> func;

    Stack<Token> stack=new Stack<Token>();

    public double eval(Token t, Stack<Token> st)
    {

       switch(t.value)
       {
           case "sin":
                 return Math.sin(Double.parseDouble(st.pop().value));
           case "cos":
                 return Math.cos(Double.parseDouble(st.pop().value));
           case "tan":
                 return Math.tan(Double.parseDouble(st.pop().value));
            case "log":
                 System.out.println("value:"+st.peek().value);
                 return Math.log10(Double.parseDouble(st.pop().value));
           default:
              throw new FunctionException("Function undefined!!");     
       }
    }
    public  List<String> getFunctionsList()
    {
        return func;
    }
}