package validator;

import tokenize.Token;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalancedParenthesis extends Validation
{
    //private static Tokenizer token;


   private static List<Token> tList=new ArrayList<Token>();


     Stack<Token> stack=new Stack<Token>();



      public  boolean validate(List<Token> t)
      {
          //token =new Tokenizer();
          tList=t;

          for(Token i:tList) {


              if(i.value.equals("(")||i.value.equals("{")||i.value.equals("["))
                  stack.push(new Token(i.pos,i.type,i.value));

              else if((!stack.isEmpty() && i.value.equals(")") && stack.peek().value.equals("("))
                      ||(!stack.isEmpty() && i.value.equals("]") && stack.peek().value.equals("["))
                      ||( !stack.isEmpty() &&i.value.equals("}") && stack.peek().value.equals("{")))
              {
                  stack.pop();
              }
          }


              if(stack.isEmpty())
                  return true;
              else
                  return false;

          }



      }






