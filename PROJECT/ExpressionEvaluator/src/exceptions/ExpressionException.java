package exceptions;

public class ExpressionException extends RuntimeException
{

    private static final long serialVersionUID = 1L;
  
    public ExpressionException(final String message)
     {
        super(message);
     }

    public String getMessage()
     {
        final String msg = super.getMessage();
        return msg;
      }
}


