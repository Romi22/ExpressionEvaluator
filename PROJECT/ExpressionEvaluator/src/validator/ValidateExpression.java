package validator;

import tokenize.Token;
import java.util.List;

public class ValidateExpression extends Validation
{
    public boolean validate(List<Token> t)
    {
        int s=t.size();
        String str=t.get(s-1).value;
        if(str.equals("-")||str.equals("+")||str.equals("*")||str.equals("/"))
            return false;
       return true;
    }
}
