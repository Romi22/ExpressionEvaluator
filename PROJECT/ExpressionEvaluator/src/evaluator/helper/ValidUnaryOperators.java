package evaluator.helper;

import java.util.ArrayList;
import java.util.List;

public class ValidUnaryOperators extends Operator
 {
    List<String> func;

    public ValidUnaryOperators()
    {
        validOperators();
    }
    public void validOperators()
    {
        func=new ArrayList<String>();

        func.add("sin");
        func.add("cos");
        func.add("tan");
        func.add("exp");
        func.add("ln");
        func.add("log");
    }
    public List<String> getOperators()
    {
        return func;
    }



}

