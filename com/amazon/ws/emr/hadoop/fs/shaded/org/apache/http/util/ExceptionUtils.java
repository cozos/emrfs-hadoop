package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util;

import java.lang.reflect.Method;

@Deprecated
public final class ExceptionUtils
{
  private static final Method INIT_CAUSE_METHOD = ;
  
  private static Method getInitCauseMethod()
  {
    try
    {
      Class<?>[] paramsClasses = { Throwable.class };
      return Throwable.class.getMethod("initCause", paramsClasses);
    }
    catch (NoSuchMethodException e) {}
    return null;
  }
  
  public static void initCause(Throwable throwable, Throwable cause)
  {
    if (INIT_CAUSE_METHOD != null) {
      try
      {
        INIT_CAUSE_METHOD.invoke(throwable, new Object[] { cause });
      }
      catch (Exception e) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.ExceptionUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */