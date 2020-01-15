package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@NotThreadSafe
public class LengthCheckInputStream
  extends SdkFilterInputStream
{
  public static final boolean INCLUDE_SKIPPED_BYTES = true;
  public static final boolean EXCLUDE_SKIPPED_BYTES = false;
  private final long expectedLength;
  private final boolean includeSkipped;
  private long dataLength;
  private long marked;
  private boolean resetSinceLastMarked;
  private int markCount;
  private int resetCount;
  
  public LengthCheckInputStream(InputStream in, long expectedLength, boolean includeSkipped)
  {
    super(in);
    if (expectedLength < 0L) {
      throw new IllegalArgumentException();
    }
    this.expectedLength = expectedLength;
    this.includeSkipped = includeSkipped;
  }
  
  public int read()
    throws IOException
  {
    int c = super.read();
    if (c >= 0) {
      dataLength += 1L;
    }
    checkLength(c == -1);
    return c;
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    int readLen = super.read(b, off, len);
    dataLength += (readLen >= 0 ? readLen : 0L);
    checkLength(readLen == -1);
    return readLen;
  }
  
  public void mark(int readlimit)
  {
    if (markSupported())
    {
      super.mark(readlimit);
      marked = dataLength;
      markCount += 1;
      resetSinceLastMarked = false;
    }
  }
  
  public void reset()
    throws IOException
  {
    if (markSupported())
    {
      super.reset();
      dataLength = marked;
      resetCount += 1;
      resetSinceLastMarked = true;
    }
    else
    {
      throw new IOException("mark/reset not supported");
    }
  }
  
  private void checkLength(boolean eof)
  {
    if (eof)
    {
      if (dataLength != expectedLength) {
        throw new SdkClientException("Data read has a different length than the expected: " + diagnosticInfo());
      }
    }
    else if (dataLength > expectedLength) {
      throw new SdkClientException("More data read than expected: " + diagnosticInfo());
    }
  }
  
  private String diagnosticInfo()
  {
    return 
    
      "dataLength=" + dataLength + "; expectedLength=" + expectedLength + "; includeSkipped=" + includeSkipped + "; in.getClass()=" + in.getClass() + "; markedSupported=" + markSupported() + "; marked=" + marked + "; resetSinceLastMarked=" + resetSinceLastMarked + "; markCount=" + markCount + "; resetCount=" + resetCount;
  }
  
  public long skip(long n)
    throws IOException
  {
    long skipped = super.skip(n);
    if ((includeSkipped) && (skipped > 0L))
    {
      dataLength += skipped;
      checkLength(false);
    }
    return skipped;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.LengthCheckInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */