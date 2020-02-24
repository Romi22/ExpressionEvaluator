package evaluator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import tokenize.Token;
import evaluator.helper.FunctionExpression;
import operations.Addition;
import operations.Division;
import operations.Multiplication;
import operations.Subtraction;

public class Evaluation {

    Queue<Token> queue = new LinkedList<Token>();

    String Result;

    public void evaluate(Queue<Token> q) {

        queue = q;

        Stack<Token> st = new Stack<Token>();

        double result;

        for (Token i : queue) 
        {
            // If operand, simply push into stack
            if (i.type.equals("operand")) {
                st.push(new Token(i.pos, i.type, i.value));
            }

            else // operator
            {
                if (i.type.equals("function")) {
                    FunctionExpression func = new FunctionExpression();
                    result = func.eval(i, st);
                    String str = String.valueOf(result);
                    st.push(new Token(st.size() - 1, "operand", str));
                }
                if (i.type.equals("operator")) {
                    if (i.value.equals("+")) {
                        Addition add = new Addition(st);
                        add.evaluate(st);
                        result = add.getResult();
                        String str = String.valueOf(result);
                        st.push(new Token(st.size() - 1, "operand", str));
                    } else if (i.value.equals("-")) {
                        Subtraction sub = new Subtraction(st);
                        sub.evaluate(st);
                        result = sub.getResult();
                        String str = String.valueOf(result);
                        st.push(new Token(st.size() - 1, "operand", str));
                    } else if (i.value.equals("*")) {
                        Multiplication mul = new Multiplication(st);
                        mul.evaluate(st);
                        result = mul.getResult();
                        String str = String.valueOf(result);
                        st.push(new Token(st.size() - 1, "operand", str));
                    } else if (i.value.equals("/")) {
                        Division div = new Division(st);
                        div.evaluate(st);
                        result = div.getResult();
                        String str = String.valueOf(result);
                        st.push(new Token(st.size() - 1, "operand", str));
                    } else {
                        System.out.println("Not a valid Operator");
                    }

                }
            }
        }

        Result = st.pop().value;

    }

    public double getFinalResult() 
    {
        return Double.parseDouble(Result);
    }

}
