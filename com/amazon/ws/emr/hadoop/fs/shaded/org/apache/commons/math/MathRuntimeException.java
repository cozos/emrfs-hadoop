package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

import java.io.EOFException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ConcurrentModificationException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

public class MathRuntimeException
  extends RuntimeException
{
  private static final long serialVersionUID = -5128983364075381060L;
  private final String pattern;
  private final Object[] arguments;
  
  public MathRuntimeException(String pattern, Object... arguments)
  {
    this.pattern = pattern;
    this.arguments = (arguments == null ? new Object[0] : (Object[])arguments.clone());
  }
  
  public MathRuntimeException(Throwable rootCause)
  {
    super(rootCause);
    pattern = getMessage();
    arguments = new Object[0];
  }
  
  public MathRuntimeException(Throwable rootCause, String pattern, Object... arguments)
  {
    super(rootCause);
    this.pattern = pattern;
    this.arguments = (arguments == null ? new Object[0] : (Object[])arguments.clone());
  }
  
  private static String translate(String s, Locale locale)
  {
    try
    {
      ResourceBundle bundle = ResourceBundle.getBundle("com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MessagesResources", locale);
      if (bundle.getLocale().getLanguage().equals(locale.getLanguage())) {
        return bundle.getString(s);
      }
    }
    catch (MissingResourceException mre) {}
    return s;
  }
  
  private static String buildMessage(Locale locale, String pattern, Object... arguments)
  {
    return pattern == null ? "" : new MessageFormat(translate(pattern, locale), locale).format(arguments);
  }
  
  public String getPattern()
  {
    return pattern;
  }
  
  public Object[] getArguments()
  {
    return (Object[])arguments.clone();
  }
  
  public String getMessage(Locale locale)
  {
    return buildMessage(locale, pattern, arguments);
  }
  
  public String getMessage()
  {
    return getMessage(Locale.US);
  }
  
  public String getLocalizedMessage()
  {
    return getMessage(Locale.getDefault());
  }
  
  public void printStackTrace()
  {
    printStackTrace(System.err);
  }
  
  public void printStackTrace(PrintStream out)
  {
    synchronized (out)
    {
      PrintWriter pw = new PrintWriter(out, false);
      printStackTrace(pw);
      
      pw.flush();
    }
  }
  
  public static ArithmeticException createArithmeticException(String pattern, final Object... arguments)
  {
    new ArithmeticException()
    {
      private static final long serialVersionUID = 7705628723242533939L;
      
      public String getMessage()
      {
        return MathRuntimeException.buildMessage(Locale.US, val$pattern, arguments);
      }
      
      public String getLocalizedMessage()
      {
        return MathRuntimeException.buildMessage(Locale.getDefault(), val$pattern, arguments);
      }
    };
  }
  
  public static ArrayIndexOutOfBoundsException createArrayIndexOutOfBoundsException(String pattern, final Object... arguments)
  {
    new ArrayIndexOutOfBoundsException()
    {
      private static final long serialVersionUID = -3394748305449283486L;
      
      public String getMessage()
      {
        return MathRuntimeException.buildMessage(Locale.US, val$pattern, arguments);
      }
      
      public String getLocalizedMessage()
      {
        return MathRuntimeException.buildMessage(Locale.getDefault(), val$pattern, arguments);
      }
    };
  }
  
  public static EOFException createEOFException(String pattern, final Object... arguments)
  {
    new EOFException()
    {
      private static final long serialVersionUID = 279461544586092584L;
      
      public String getMessage()
      {
        return MathRuntimeException.buildMessage(Locale.US, val$pattern, arguments);
      }
      
      public String getLocalizedMessage()
      {
        return MathRuntimeException.buildMessage(Locale.getDefault(), val$pattern, arguments);
      }
    };
  }
  
  public static IOException createIOException(Throwable rootCause)
  {
    IOException ioe = new IOException(rootCause.getLocalizedMessage());
    ioe.initCause(rootCause);
    return ioe;
  }
  
  public static IllegalArgumentException createIllegalArgumentException(String pattern, final Object... arguments)
  {
    new IllegalArgumentException()
    {
      private static final long serialVersionUID = -6555453980658317913L;
      
      public String getMessage()
      {
        return MathRuntimeException.buildMessage(Locale.US, val$pattern, arguments);
      }
      
      public String getLocalizedMessage()
      {
        return MathRuntimeException.buildMessage(Locale.getDefault(), val$pattern, arguments);
      }
    };
  }
  
  public static IllegalArgumentException createIllegalArgumentException(Throwable rootCause)
  {
    IllegalArgumentException iae = new IllegalArgumentException(rootCause.getLocalizedMessage());
    iae.initCause(rootCause);
    return iae;
  }
  
  public static IllegalStateException createIllegalStateException(String pattern, final Object... arguments)
  {
    new IllegalStateException()
    {
      private static final long serialVersionUID = -95247648156277208L;
      
      public String getMessage()
      {
        return MathRuntimeException.buildMessage(Locale.US, val$pattern, arguments);
      }
      
      public String getLocalizedMessage()
      {
        return MathRuntimeException.buildMessage(Locale.getDefault(), val$pattern, arguments);
      }
    };
  }
  
  public static ConcurrentModificationException createConcurrentModificationException(String pattern, final Object... arguments)
  {
    new ConcurrentModificationException()
    {
      private static final long serialVersionUID = 6134247282754009421L;
      
      public String getMessage()
      {
        return MathRuntimeException.buildMessage(Locale.US, val$pattern, arguments);
      }
      
      public String getLocalizedMessage()
      {
        return MathRuntimeException.buildMessage(Locale.getDefault(), val$pattern, arguments);
      }
    };
  }
  
  public static NoSuchElementException createNoSuchElementException(String pattern, final Object... arguments)
  {
    new NoSuchElementException()
    {
      private static final long serialVersionUID = 7304273322489425799L;
      
      public String getMessage()
      {
        return MathRuntimeException.buildMessage(Locale.US, val$pattern, arguments);
      }
      
      public String getLocalizedMessage()
      {
        return MathRuntimeException.buildMessage(Locale.getDefault(), val$pattern, arguments);
      }
    };
  }
  
  public static NullPointerException createNullPointerException(String pattern, final Object... arguments)
  {
    new NullPointerException()
    {
      private static final long serialVersionUID = -3075660477939965216L;
      
      public String getMessage()
      {
        return MathRuntimeException.buildMessage(Locale.US, val$pattern, arguments);
      }
      
      public String getLocalizedMessage()
      {
        return MathRuntimeException.buildMessage(Locale.getDefault(), val$pattern, arguments);
      }
    };
  }
  
  public static ParseException createParseException(int offset, final String pattern, final Object... arguments)
  {
    new ParseException(null, offset)
    {
      private static final long serialVersionUID = -1103502177342465975L;
      
      public String getMessage()
      {
        return MathRuntimeException.buildMessage(Locale.US, pattern, arguments);
      }
      
      public String getLocalizedMessage()
      {
        return MathRuntimeException.buildMessage(Locale.getDefault(), pattern, arguments);
      }
    };
  }
  
  public static RuntimeException createInternalError(Throwable cause)
  {
    String pattern = "internal error, please fill a bug report at {0}";
    String argument = "https://issues.apache.org/jira/browse/MATH";
    
    new RuntimeException()
    {
      private static final long serialVersionUID = -201865440834027016L;
      
      public String getMessage()
      {
        return MathRuntimeException.buildMessage(Locale.US, "internal error, please fill a bug report at {0}", new Object[] { "https://issues.apache.org/jira/browse/MATH" });
      }
      
      public String getLocalizedMessage()
      {
        return MathRuntimeException.buildMessage(Locale.getDefault(), "internal error, please fill a bug report at {0}", new Object[] { "https://issues.apache.org/jira/browse/MATH" });
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */