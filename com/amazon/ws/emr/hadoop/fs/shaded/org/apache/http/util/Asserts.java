package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util;

public class Asserts
{
  public static void check(boolean expression, String message)
  {
    if (!expression) {
      throw new IllegalStateException(message);
    }
  }
  
  public static void check(boolean expression, String message, Object... args)
  {
    if (!expression) {
      throw new IllegalStateException(String.format(message, args));
    }
  }
  
  public static void check(boolean expression, String message, Object arg)
  {
    if (!expression) {
      throw new IllegalStateException(String.format(message, new Object[] { arg }));
    }
  }
  
  public static void notNull(Object object, String name)
  {
    if (object == null) {
      throw new IllegalStateException(name + " is null");
    }
  }
  
  public static void notEmpty(CharSequence s, String name)
  {
    if (TextUtils.isEmpty(s)) {
      throw new IllegalStateException(name + " is empty");
    }
  }
  
  public static void notBlank(CharSequence s, String name)
  {
    if (TextUtils.isBlank(s)) {
      throw new IllegalStateException(name + " is blank");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Asserts
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */