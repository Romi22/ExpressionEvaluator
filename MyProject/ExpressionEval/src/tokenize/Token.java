package tokenize;

public class Token
{
     public final int pos;
     public final String value;
     public final String type;


     public Token(int pos,String type,String value)
     {
          super();

          this.pos=pos;
          this.value=value;
          this.type=type;
     }
}