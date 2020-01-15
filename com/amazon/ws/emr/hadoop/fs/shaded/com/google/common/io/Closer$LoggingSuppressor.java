package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.util.logging.Level;
import java.util.logging.Logger;

@VisibleForTesting
final class Closer$LoggingSuppressor
  implements Closer.Suppressor
{
  static final LoggingSuppressor INSTANCE = new LoggingSuppressor();
  
  public void suppress(Closeable closeable, Throwable thrown, Throwable suppressed)
  {
    String str = String.valueOf(String.valueOf(closeable));Closeables.logger.log(Level.WARNING, 42 + str.length() + "Suppressing exception thrown when closing " + str, suppressed);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.Closer.LoggingSuppressor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */