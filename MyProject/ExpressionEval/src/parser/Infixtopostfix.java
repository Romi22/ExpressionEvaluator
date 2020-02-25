package parser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import tokenize.Token;
import exceptions.PostfixException;

public class Infixtopostfix
 {
    Queue<Token> queue = new LinkedList<Token>();

    Stack<Token> stack = new Stack<Token>();

    List<Token> tList = new ArrayList<Token>();

    int Prec(String val)
    {
        switch (val) {
            case "+":
            case "-":
                return 1;

            case "*":
            case "/":
                return 2;

            case "^":
                return 3;
        }
        return -1;
    }

    public void infixToPostfix(final List<Token> tList) throws PostfixException
     {
         this.tList = tList;

        for (Token i : tList) 
        {

            if (i.type.equals("operand"))
                queue.add(new Token(i.pos, i.type, i.value));

            else if (i.type.equals("function"))
                stack.push(new Token(i.pos, i.type, i.value));

            else if (i.type.equals("parenthesis") && i.value.equals("("))
                stack.push(new Token(i.pos, i.type, i.value));

            else if (i.type.equals("parenthesis") && i.value.equals(")"))
             {
                 if(stack.isEmpty())
                 {
                   System.out.println("");
                 }

                 else 
                {
                    while (!stack.peek().value.equals("("))
                     {
                        queue.add(stack.pop());

                        if (stack.isEmpty())
                            break;
                     }
                    if (!stack.isEmpty() && stack.peek().type.equals("parenthesis") && stack.peek().value.equals("(")) 
                    {
                        stack.pop();
                    }
                } 
            }
            else if(i.type.equals("separator") && i.value.equals(","))
                continue;

            else // an operator is encountered
            {
                while (!stack.isEmpty() && stack.peek().type.equals("function") || (!stack.isEmpty()
                        && stack.peek().type.equals("operator") && Prec(i.value) <= Prec(stack.peek().value)))

                {
                    if (stack.peek().type.equals("parenthesis") && stack.peek().value.equals("("))
                        throw new PostfixException("Invalid Expression");

                    queue.add(stack.pop());
                }

                stack.push(new Token(i.pos, i.type, i.value));
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) 
        {
            if (stack.peek().type.equals("parenthesis") && stack.peek().value.equals(")"))
                throw new PostfixException("Invalid Expression");
            queue.add(stack.pop());
        }
    }

    public Queue<Token> getQueue()
    {
        return queue;
    }

}