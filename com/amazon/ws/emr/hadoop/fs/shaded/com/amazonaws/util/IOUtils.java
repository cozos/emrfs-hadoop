package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.Releasable;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public enum IOUtils
{
  private static final int BUFFER_SIZE = 4096;
  private static final Log defaultLog = LogFactory.getLog(IOUtils.class);
  
  private IOUtils() {}
  
  public static byte[] toByteArray(InputStream is)
    throws IOException
  {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    try
    {
      byte[] b = new byte['က'];
      int n = 0;
      while ((n = is.read(b)) != -1) {
        output.write(b, 0, n);
      }
      return output.toByteArray();
    }
    finally
    {
      output.close();
    }
  }
  
  public static String toString(InputStream is)
    throws IOException
  {
    return new String(toByteArray(is), StringUtils.UTF8);
  }
  
  public static void closeQuietly(Closeable is, Log log)
  {
    if (is != null) {
      try
      {
        is.close();
      }
      catch (IOException ex)
      {
        Log logger = log == null ? defaultLog : log;
        if (logger.isDebugEnabled()) {
          logger.debug("Ignore failure in closing the Closeable", ex);
        }
      }
    }
  }
  
  public static void release(Closeable is, Log log)
  {
    closeQuietly(is, log);
    if ((is instanceof Releasable))
    {
      Releasable r = (Releasable)is;
      r.release();
    }
  }
  
  public static long copy(InputStream in, OutputStream out)
    throws IOException
  {
    return copy(in, out, Long.MAX_VALUE);
  }
  
  public static long copy(InputStream in, OutputStream out, long readLimit)
    throws IOException
  {
    byte[] buf = new byte['က'];
    long count = 0L;
    int n = 0;
    while ((n = in.read(buf)) > -1)
    {
      out.write(buf, 0, n);
      count += n;
      if (count >= readLimit) {
        throw new IOException("Read limit exceeded: " + readLimit);
      }
    }
    return count;
  }
  
  public static void drainInputStream(InputStream in)
  {
    try
    {
      while (in.read() != -1) {}
    }
    catch (IOException localIOException) {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */