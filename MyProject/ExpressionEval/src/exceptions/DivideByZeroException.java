package exceptions;

public class DivideByZeroException extends ArithmeticException
{
    private static final long serialVersionUID = 1L;

    public DivideByZeroException(final String message)
     {
        super(message);
     }

    public String getMessage()
     {
        final String msg = super.getMessage();
        return msg;
     }
}
