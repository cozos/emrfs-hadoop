package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;

public class CRC32ChecksumCalculatingInputStream
  extends SdkFilterInputStream
{
  private CRC32 crc32;
  
  public CRC32ChecksumCalculatingInputStream(InputStream in)
  {
    super(in);
    crc32 = new CRC32();
  }
  
  public long getCRC32Checksum()
  {
    return crc32.getValue();
  }
  
  public synchronized void reset()
    throws IOException
  {
    abortIfNeeded();
    crc32.reset();
    in.reset();
  }
  
  public int read()
    throws IOException
  {
    abortIfNeeded();
    int ch = in.read();
    if (ch != -1) {
      crc32.update(ch);
    }
    return ch;
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    abortIfNeeded();
    int result = in.read(b, off, len);
    if (result != -1) {
      crc32.update(b, off, result);
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CRC32ChecksumCalculatingInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */