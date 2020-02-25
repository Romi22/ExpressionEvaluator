package validator;

import exceptions.ExpressionException;
import tokenize.Token;
import java.util.List;

public class ValidateExpression extends Validation
{
    public boolean validate(List<Token> t)
    {
        int s=t.size();
        String str=t.get(s-1).value;
        if(str.equals("-")||str.equals("+")||str.equals("*")||str.equals("/"))
        {
            return false;
            
        }
        int count=0;
        for(Token i:t)
        {
            int ind= t.indexOf(i);

            if(i.value.equals("("))
                count += 1;
            if(i.value.equals(")"))
                count -= 1;

            if(i.type.equals("operator")){
                Token nextToken = t.get(ind+1);
                if(nextToken.type.equals("operator")){
                    throw new ExpressionException("Invalid Expression Found");
                }

            }
        }


        if(count!=0) {
            return false;
        }

       return true;
    }
}
