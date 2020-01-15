package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class Escapers
{
  public static Escaper nullEscaper()
  {
    return NULL_ESCAPER;
  }
  
  private static final Escaper NULL_ESCAPER = new CharEscaper()
  {
    public String escape(String string)
    {
      return (String)Preconditions.checkNotNull(string);
    }
    
    protected char[] escape(char c)
    {
      return null;
    }
  };
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  /* Error */
  static UnicodeEscaper asUnicodeEscaper(Escaper escaper)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 39	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: instanceof 41
    //   9: ifeq +8 -> 17
    //   12: aload_0
    //   13: checkcast 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/escape/UnicodeEscaper
    //   16: areturn
    //   17: aload_0
    //   18: instanceof 43
    //   21: ifeq +11 -> 32
    //   24: aload_0
    //   25: checkcast 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/escape/CharEscaper
    //   28: invokestatic 47	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/escape/Escapers:wrap	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/escape/CharEscaper;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/escape/UnicodeEscaper;
    //   31: areturn
    //   32: new 49	java/lang/IllegalArgumentException
    //   35: dup
    //   36: ldc 51
    //   38: aload_0
    //   39: invokevirtual 55	java/lang/Object:getClass	()Ljava/lang/Class;
    //   42: invokevirtual 61	java/lang/Class:getName	()Ljava/lang/String;
    //   45: invokestatic 67	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   48: dup
    //   49: invokevirtual 71	java/lang/String:length	()I
    //   52: ifeq +9 -> 61
    //   55: invokevirtual 75	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   58: goto +12 -> 70
    //   61: pop
    //   62: new 63	java/lang/String
    //   65: dup_x1
    //   66: swap
    //   67: invokespecial 80	java/lang/String:<init>	(Ljava/lang/String;)V
    //   70: invokespecial 81	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   73: athrow
    // Line number table:
    //   Java source line #183	-> byte code offset #0
    //   Java source line #184	-> byte code offset #5
    //   Java source line #185	-> byte code offset #12
    //   Java source line #186	-> byte code offset #17
    //   Java source line #187	-> byte code offset #24
    //   Java source line #191	-> byte code offset #32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	escaper	Escaper
  }
  
  @Beta
  public static final class Builder
  {
    private final Map<Character, String> replacementMap = new HashMap();
    private char safeMin = '\000';
    private char safeMax = 65535;
    private String unsafeReplacement = null;
    
    public Builder setSafeRange(char safeMin, char safeMax)
    {
      this.safeMin = safeMin;
      this.safeMax = safeMax;
      return this;
    }
    
    public Builder setUnsafeReplacement(@Nullable String unsafeReplacement)
    {
      this.unsafeReplacement = unsafeReplacement;
      return this;
    }
    
    public Builder addEscape(char c, String replacement)
    {
      Preconditions.checkNotNull(replacement);
      
      replacementMap.put(Character.valueOf(c), replacement);
      return this;
    }
    
    public Escaper build()
    {
      new ArrayBasedCharEscaper(replacementMap, safeMin, safeMax)
      {
        private final char[] replacementChars = unsafeReplacement != null ? unsafeReplacement.toCharArray() : null;
        
        protected char[] escapeUnsafe(char c)
        {
          return replacementChars;
        }
      };
    }
  }
  
  public static String computeReplacement(CharEscaper escaper, char c)
  {
    return stringOrNull(escaper.escape(c));
  }
  
  public static String computeReplacement(UnicodeEscaper escaper, int cp)
  {
    return stringOrNull(escaper.escape(cp));
  }
  
  private static String stringOrNull(char[] in)
  {
    return in == null ? null : new String(in);
  }
  
  private static UnicodeEscaper wrap(CharEscaper escaper)
  {
    new UnicodeEscaper()
    {
      protected char[] escape(int cp)
      {
        if (cp < 65536) {
          return val$escaper.escape((char)cp);
        }
        char[] surrogateChars = new char[2];
        Character.toChars(cp, surrogateChars, 0);
        char[] hiChars = val$escaper.escape(surrogateChars[0]);
        char[] loChars = val$escaper.escape(surrogateChars[1]);
        if ((hiChars == null) && (loChars == null)) {
          return null;
        }
        int hiCount = hiChars != null ? hiChars.length : 1;
        int loCount = loChars != null ? loChars.length : 1;
        char[] output = new char[hiCount + loCount];
        if (hiChars != null) {
          for (int n = 0; n < hiChars.length; n++) {
            output[n] = hiChars[n];
          }
        } else {
          output[0] = surrogateChars[0];
        }
        if (loChars != null) {
          for (int n = 0; n < loChars.length; n++) {
            output[(hiCount + n)] = loChars[n];
          }
        } else {
          output[hiCount] = surrogateChars[1];
        }
        return output;
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.Escapers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */