package validator;

import java.util.ArrayList;
import java.util.List;
import evaluator.helper.ValidUnaryOperators;
import tokenize.Token;

public class ValidateFunction extends Validation 
{

    List<String> tList = new ArrayList<String>();

    public boolean validate(List<Token> t)
    {
        ValidUnaryOperators unaryOp = new ValidUnaryOperators();
        tList = unaryOp.getOperators();

        for (Token i : t)
        {
            if (i.type.equals("function") && !tList.contains(i.value))
            {
                 return false;
            }
        }
        return true;
    }
}
