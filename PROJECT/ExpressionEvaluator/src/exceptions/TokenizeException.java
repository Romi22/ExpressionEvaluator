package exceptions;

public class TokenizeException extends RuntimeException
{

    private static final long serialVersionUID = 1L;
    String str;
    
    public TokenizeException(final String message, final String str)
     {
        super(message);
        this.str = str;
     }

    public String getMessage()
     {
        final String msg = super.getMessage();
        final String err = msg + str;
        return err;
     }
}


