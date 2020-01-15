package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import java.lang.reflect.InvocationTargetException;

class Exceptions
{
  public static RuntimeException throwCleanly(InvocationTargetException exception)
  {
    Throwable cause = exception;
    if (cause.getCause() != null) {
      cause = cause.getCause();
    }
    if ((cause instanceof RuntimeException)) {
      throw ((RuntimeException)cause);
    }
    if ((cause instanceof Error)) {
      throw ((Error)cause);
    }
    throw new UnhandledCheckedUserException(cause);
  }
  
  static class UnhandledCheckedUserException
    extends RuntimeException
  {
    public UnhandledCheckedUserException(Throwable cause)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Exceptions
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */