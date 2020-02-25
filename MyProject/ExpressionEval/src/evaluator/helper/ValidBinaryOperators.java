package evaluator.helper;

import java.util.ArrayList;
import java.util.List;

public class ValidBinaryOperators extends Operator
{
        List<String> binaryOp;
       
        public void validOperators()
        {
             binaryOp=new ArrayList<String>();
             binaryOp.add("+");
             binaryOp.add("-");
             binaryOp.add("*");
             binaryOp.add("/");
        }
        public List<String> getOperators()
        {
             return binaryOp;
        }
}
