package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CountingInputStream
  extends SdkFilterInputStream
{
  private long byteCount = 0L;
  
  public CountingInputStream(InputStream in)
  {
    super(in);
  }
  
  public long getByteCount()
  {
    return byteCount;
  }
  
  public int read()
    throws IOException
  {
    int tmp = super.read();
    byteCount += (tmp >= 0 ? 1L : 0L);
    return tmp;
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    int tmp = super.read(b, off, len);
    byteCount += (tmp >= 0 ? tmp : 0L);
    return tmp;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CountingInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */