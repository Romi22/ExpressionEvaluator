package validator;

import tokenize.Token;

import java.util.List;

public abstract class Validation
{
    public abstract boolean validate(List<Token> t);
}
