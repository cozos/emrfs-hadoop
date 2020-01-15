package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
public class RepeatableFileInputStream
  extends SdkInputStream
{
  private static final Log log = LogFactory.getLog(RepeatableFileInputStream.class);
  private final File file;
  private FileInputStream fis = null;
  private long bytesReadPastMarkPoint = 0L;
  private long markPoint = 0L;
  
  public RepeatableFileInputStream(File file)
    throws FileNotFoundException
  {
    if (file == null) {
      throw new IllegalArgumentException("File cannot be null");
    }
    fis = new FileInputStream(file);
    this.file = file;
  }
  
  public File getFile()
  {
    return file;
  }
  
  public void reset()
    throws IOException
  {
    fis.close();
    abortIfNeeded();
    fis = new FileInputStream(file);
    
    long skipped = 0L;
    long toSkip = markPoint;
    while (toSkip > 0L)
    {
      skipped = fis.skip(toSkip);
      toSkip -= skipped;
    }
    if (log.isDebugEnabled()) {
      log.debug("Reset to mark point " + markPoint + " after returning " + bytesReadPastMarkPoint + " bytes");
    }
    bytesReadPastMarkPoint = 0L;
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public void mark(int readlimit)
  {
    abortIfNeeded();
    markPoint += bytesReadPastMarkPoint;
    bytesReadPastMarkPoint = 0L;
    if (log.isDebugEnabled()) {
      log.debug("Input stream marked at " + markPoint + " bytes");
    }
  }
  
  public int available()
    throws IOException
  {
    abortIfNeeded();
    return fis.available();
  }
  
  public void close()
    throws IOException
  {
    fis.close();
    abortIfNeeded();
  }
  
  public int read()
    throws IOException
  {
    abortIfNeeded();
    int byteRead = fis.read();
    if (byteRead != -1)
    {
      bytesReadPastMarkPoint += 1L;
      return byteRead;
    }
    return -1;
  }
  
  public long skip(long n)
    throws IOException
  {
    abortIfNeeded();
    long skipped = fis.skip(n);
    bytesReadPastMarkPoint += skipped;
    return skipped;
  }
  
  public int read(byte[] arg0, int arg1, int arg2)
    throws IOException
  {
    abortIfNeeded();
    int count = fis.read(arg0, arg1, arg2);
    bytesReadPastMarkPoint += count;
    return count;
  }
  
  public InputStream getWrappedInputStream()
  {
    return fis;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.RepeatableFileInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */