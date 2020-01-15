package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

@NotThreadSafe
public class ResettableInputStream
  extends ReleasableInputStream
{
  private static final Log log = LogFactory.getLog(ResettableInputStream.class);
  private final File file;
  private FileInputStream fis;
  private FileChannel fileChannel;
  private long markPos;
  
  public ResettableInputStream(File file)
    throws IOException
  {
    this(new FileInputStream(file), file);
  }
  
  public ResettableInputStream(FileInputStream fis)
    throws IOException
  {
    this(fis, null);
  }
  
  private ResettableInputStream(FileInputStream fis, File file)
    throws IOException
  {
    super(fis);
    this.file = file;
    this.fis = fis;
    fileChannel = fis.getChannel();
    markPos = fileChannel.position();
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public void mark(int _)
  {
    abortIfNeeded();
    try
    {
      markPos = fileChannel.position();
    }
    catch (IOException e)
    {
      throw new SdkClientException("Failed to mark the file position", e);
    }
    if (log.isTraceEnabled()) {
      log.trace("File input stream marked at position " + markPos);
    }
  }
  
  public void reset()
    throws IOException
  {
    abortIfNeeded();
    fileChannel.position(markPos);
    if (log.isTraceEnabled()) {
      log.trace("Reset to position " + markPos);
    }
  }
  
  public int available()
    throws IOException
  {
    abortIfNeeded();
    return fis.available();
  }
  
  public int read()
    throws IOException
  {
    abortIfNeeded();
    return fis.read();
  }
  
  public long skip(long n)
    throws IOException
  {
    abortIfNeeded();
    return fis.skip(n);
  }
  
  public int read(byte[] arg0, int arg1, int arg2)
    throws IOException
  {
    abortIfNeeded();
    return fis.read(arg0, arg1, arg2);
  }
  
  public File getFile()
  {
    return file;
  }
  
  public static ResettableInputStream newResettableInputStream(File file)
  {
    return newResettableInputStream(file, null);
  }
  
  public static ResettableInputStream newResettableInputStream(File file, String errmsg)
  {
    try
    {
      return new ResettableInputStream(file);
    }
    catch (IOException e)
    {
      throw (errmsg == null ? new SdkClientException(e) : new SdkClientException(errmsg, e));
    }
  }
  
  public static ResettableInputStream newResettableInputStream(FileInputStream fis)
  {
    return newResettableInputStream(fis, null);
  }
  
  public static ResettableInputStream newResettableInputStream(FileInputStream fis, String errmsg)
  {
    try
    {
      return new ResettableInputStream(fis);
    }
    catch (IOException e)
    {
      throw new SdkClientException(errmsg, e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ResettableInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */