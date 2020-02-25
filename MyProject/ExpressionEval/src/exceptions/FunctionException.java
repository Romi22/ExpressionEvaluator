package exceptions;

public class FunctionException extends RuntimeException
 {

    private static final long serialVersionUID = 1L;

    public FunctionException(final String message)
     {
        super(message);
     }

    public String getMessage()
     {
        final String msg = super.getMessage();

        return msg;
     }
}
