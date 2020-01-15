package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AbortedException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

public enum Throwables
{
  private Throwables() {}
  
  public static Throwable getRootCause(Throwable orig)
  {
    if (orig == null) {
      return orig;
    }
    Throwable t = orig;
    for (int i = 0; i < 1000; i++)
    {
      Throwable cause = t.getCause();
      if (cause == null) {
        return t;
      }
      t = cause;
    }
    LogFactory.getLog(Throwables.class).debug("Possible circular reference detected on " + orig
      .getClass() + ": [" + orig + "]");
    
    return orig;
  }
  
  public static RuntimeException failure(Throwable t)
  {
    if ((t instanceof RuntimeException)) {
      return (RuntimeException)t;
    }
    if ((t instanceof Error)) {
      throw ((Error)t);
    }
    return (t instanceof InterruptedException) ? new AbortedException(t) : new AmazonClientException(t);
  }
  
  public static RuntimeException failure(Throwable t, String errmsg)
  {
    if ((t instanceof RuntimeException)) {
      return (RuntimeException)t;
    }
    if ((t instanceof Error)) {
      throw ((Error)t);
    }
    return (t instanceof InterruptedException) ? new AbortedException(errmsg, t) : new AmazonClientException(errmsg, t);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Throwables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */