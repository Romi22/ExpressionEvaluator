package exceptions;

public class ParenthesisException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    
    public ParenthesisException(final String message)
     {
        super(message);
     }

    public String getMessage() 
    {
        final String msg = super.getMessage();
        return msg;
    }
}


