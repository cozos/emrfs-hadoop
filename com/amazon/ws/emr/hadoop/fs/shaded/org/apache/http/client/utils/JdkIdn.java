package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class JdkIdn
  implements Idn
{
  private final Method toUnicode;
  
  public JdkIdn()
    throws ClassNotFoundException
  {
    Class<?> clazz = Class.forName("java.net.IDN");
    try
    {
      toUnicode = clazz.getMethod("toUnicode", new Class[] { String.class });
    }
    catch (SecurityException e)
    {
      throw new IllegalStateException(e.getMessage(), e);
    }
    catch (NoSuchMethodException e)
    {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }
  
  public String toUnicode(String punycode)
  {
    try
    {
      return (String)toUnicode.invoke(null, new Object[] { punycode });
    }
    catch (IllegalAccessException e)
    {
      throw new IllegalStateException(e.getMessage(), e);
    }
    catch (InvocationTargetException e)
    {
      Throwable t = e.getCause();
      throw new RuntimeException(t.getMessage(), t);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.JdkIdn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */