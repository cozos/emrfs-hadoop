package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.lang.reflect.Method;

@VisibleForTesting
final class Closer$SuppressingSuppressor
  implements Closer.Suppressor
{
  static final SuppressingSuppressor INSTANCE = new SuppressingSuppressor();
  
  static boolean isAvailable()
  {
    return addSuppressed != null;
  }
  
  static final Method addSuppressed = getAddSuppressed();
  
  private static Method getAddSuppressed()
  {
    try
    {
      return Throwable.class.getMethod("addSuppressed", new Class[] { Throwable.class });
    }
    catch (Throwable e) {}
    return null;
  }
  
  public void suppress(Closeable closeable, Throwable thrown, Throwable suppressed)
  {
    if (thrown == suppressed) {
      return;
    }
    try
    {
      addSuppressed.invoke(thrown, new Object[] { suppressed });
    }
    catch (Throwable e)
    {
      Closer.LoggingSuppressor.INSTANCE.suppress(closeable, thrown, suppressed);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.Closer.SuppressingSuppressor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */