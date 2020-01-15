package com.amazon.ws.emr.hadoop.fs.util.io;

import com.amazon.ws.emr.hadoop.fs.util.ExceptionCollector;
import java.io.Closeable;
import java.io.IOException;

public final class MoreCloseables
{
  private static final DoNothingClosable DO_NOTHING_CLOSABLE = new DoNothingClosable(null);
  
  private MoreCloseables()
  {
    throw new AssertionError();
  }
  
  public static <T> Closeable asCloseable(T object)
  {
    if ((object instanceof Closeable)) {
      return (Closeable)object;
    }
    return DO_NOTHING_CLOSABLE;
  }
  
  public static void closeAll(Closeable... closeables)
    throws IOException
  {
    if (closeables != null)
    {
      ExceptionCollector exceptionCollector = new ExceptionCollector();
      for (Closeable closeable : closeables) {
        closeIfNotNull(closeable, exceptionCollector);
      }
      exceptionCollector.rethrowIfNotEmpty(IOException.class);
    }
  }
  
  private static void closeIfNotNull(Closeable closeable, ExceptionCollector exceptionCollector)
  {
    if (closeable != null) {
      try
      {
        closeable.close();
      }
      catch (IOException|RuntimeException e)
      {
        exceptionCollector.add(e);
      }
    }
  }
  
  private static final class DoNothingClosable
    implements Closeable
  {
    public void close() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.io.MoreCloseables
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */