package exceptions;

public class PostfixException extends Exception
{

  private static final long serialVersionUID = 1L;

    public PostfixException(final String message)
     {
        super(message);
     }

    public String getMessage()
     {
        final String msg = super.getMessage();
        return msg;
     }
   
}


