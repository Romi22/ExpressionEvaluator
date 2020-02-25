package operations;

import tokenize.Token;

import java.util.Stack;

interface ArithmeticOperations
{
       void evaluate(Stack<Token> stack);

       double getResult();
}