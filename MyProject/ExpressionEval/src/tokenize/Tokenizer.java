package tokenize;

import java.util.ArrayList;
import java.util.List;
import evaluator.helper.ValidBinaryOperators;
import exceptions.TokenizeException;

public class Tokenizer 
{

    List<Token> tokens = new ArrayList<Token>();
    
    List<String> blist=new ArrayList<String>();

    ValidBinaryOperators bOp=new ValidBinaryOperators();

    String res1;
    String res2;
   
    public void tokenize(final String exp) {
        try {
            bOp.validOperators();

            blist = bOp.getOperators();

            for (int i = 0; i < exp.length(); i++) {
                int j = i;
                if (blist.contains(Character.toString(exp.charAt(i)))) {


                    if (i == exp.length() - 1)
                        tokens.add(new Token(j, "operator", Character.toString(exp.charAt(i))));



                    if ((Character.toString(exp.charAt(i))).equals("-") && i != 0) {
                        if (((Character.toString(exp.charAt(i - 1))).equals("+")
                                || (Character.toString(exp.charAt(i - 1))).equals("*") ||
                                (Character.toString(exp.charAt(i - 1))).equals("/") || (Character.toString(exp.charAt(i - 1))).equals("(")) && (Character.isDigit(exp.charAt(i + 1)))) {
                            tokens.add(new Token(j, "operand", "" + exp.charAt(i) + exp.charAt(i + 1)));
                            i++;

                        }

                        else
                        tokens.add(new Token(j, "operator", Character.toString(exp.charAt(i))));

                    } else if ((Character.toString(exp.charAt(i))).equals("-") && i == 0) {
                        if (Character.isDigit(exp.charAt(i + 1))) {
                            tokens.add(new Token(j, "operand", "" + exp.charAt(i) + exp.charAt(i + 1)));
                            i++;
                            System.out.println("hello12");
                        }

                    } else {

                        tokens.add(new Token(j, "operator", Character.toString(exp.charAt(i))));
                    }

                } else if (exp.charAt(i) == ' ')
                    continue;
                else if (exp.charAt(i) == ',') {
                    tokens.add(new Token(j, "separator", Character.toString(exp.charAt(i))));
                } else if (exp.charAt(i) >= '0' && exp.charAt(i) <= '9') {
                    res1 = "";
                    while (i < exp.length() && (Character.isDigit(exp.charAt(i)))) {

                        res1 += exp.charAt(i);
                        ++i;
                    }

                    if (i < exp.length() && exp.charAt(i) == '.') {
                        res1 += exp.charAt(i);
                        i++;
                    }

                    while (i < exp.length() && (Character.isDigit(exp.charAt(i)))) {

                        res1 += exp.charAt(i);
                        ++i;
                    }

                    tokens.add(new Token(j, "operand", res1));
                    i--;

                } else if (exp.charAt(i) == '(') {

                    tokens.add(new Token(j, "parenthesis", Character.toString(exp.charAt(i))));

                } else if (exp.charAt(i) == ')') {
                    tokens.add(new Token(j, "parenthesis", Character.toString(exp.charAt(i))));

                } else if (Character.isLetter(exp.charAt(i))) {

                    res2 = "";

                    while (i < exp.length() && Character.isLetter(exp.charAt(i))) {
                        res2 += exp.charAt(i);

                        i++;
                    }

                    tokens.add(new Token(j, "function", res2));
                    i--;
                } else {
                    throw new TokenizeException("Unsupported Tokens found:", Character.toString(exp.charAt(i)));
                }

                //j++;
            }


        }
        catch(Exception e)
        {
            System.out.println("Invalid Expression Found");
        }
    }
                
                
                    public  List<Token> getTokens()
                    {
                        return tokens;
                    }
         
    }
   