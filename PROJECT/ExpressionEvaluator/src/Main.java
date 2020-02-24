import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import evaluator.Evaluation;
import parser.Infixtopostfix;
import tokenize.Token;
import tokenize.Tokenizer;
import validator.BalancedParenthesis;
import validator.ValidateExpression;
import validator.ValidateFunction;
import exceptions.DivideByZeroException;
import exceptions.ExpressionException;
import exceptions.FunctionException;
import exceptions.ParenthesisException;
import exceptions.PostfixException;
import exceptions.TokenizeException;

public class Main {

    public static void init() throws IOException {

        List<Token> tokenList = new ArrayList<Token>();

        Queue<Token> qtoken = new LinkedList<Token>();
        String ch = "y";
        Double result;

        while (ch.equals("y")) {

            try {

                System.out.println("Enter an Expression: ");

                // final String exp = "(6+-4)+sine(40)";
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String exp = br.readLine();

                final Tokenizer tokenizer = new Tokenizer();

                tokenizer.tokenize(exp);

                tokenList = tokenizer.getTokens();

                System.out.println("Token List: ");
                for (final Token i : tokenList) {
                    System.out.println(i.pos + " " + i.type + " " + i.value);
                }

                BalancedParenthesis bp = new BalancedParenthesis();
                if (!bp.validate(tokenList))
                    throw new ParenthesisException("Unbalanced Parenthesis Found");

                ValidateFunction vf = new ValidateFunction();
                if (!vf.validate(tokenList))
                    throw new FunctionException("Unsupported Trignometric Function Found");

                ValidateExpression ve = new ValidateExpression();
                if (!ve.validate(tokenList))
                    throw new ExpressionException("Invalid Expression Found");

                final Infixtopostfix ip = new Infixtopostfix();

                ip.infixToPostfix(tokenList);

                qtoken = ip.getQueue();

                System.out.println("PostFix Notation ");

                for (final Token i : qtoken) {
                    System.out.println(i.pos + " " + i.type + " " + i.value);
                }

                System.out.println("Result: ");
                final Evaluation e = new Evaluation();
                e.evaluate(qtoken);

                result = e.getFinalResult();
                System.out.println(result);

                System.out.println("Enter y to continue:");
                ch = br.readLine();

            } catch (final TokenizeException e) {
                System.out.println(e.getMessage());
            }

            catch (final PostfixException p) {
                System.out.println(p.getMessage());
            }

            catch (final ParenthesisException pe) {
                System.out.println(pe.getMessage());
            }

            catch (final ExpressionException ee) {
                System.out.println(ee.getMessage());
            }

            catch (final FunctionException fe) {
                System.out.println(fe.getMessage());
            } catch (DivideByZeroException d) {
                System.out.println(d.getMessage());
            }

        }

    }

    public static void main(final String[] args) throws PostfixException, IOException {

        init();

    }

}
