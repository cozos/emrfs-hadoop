package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MathException
  extends Exception
{
  private static final long serialVersionUID = -9004610152740737812L;
  private final String pattern;
  private final Object[] arguments;
  
  public MathException()
  {
    pattern = null;
    arguments = new Object[0];
  }
  
  public MathException(String pattern, Object... arguments)
  {
    this.pattern = pattern;
    this.arguments = (arguments == null ? new Object[0] : (Object[])arguments.clone());
  }
  
  public MathException(Throwable rootCause)
  {
    super(rootCause);
    pattern = getMessage();
    arguments = new Object[0];
  }
  
  public MathException(Throwable rootCause, String pattern, Object... arguments)
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
    return pattern == null ? "" : new MessageFormat(translate(pattern, locale), locale).format(arguments);
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */