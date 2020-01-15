package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;

final class GwtWorkarounds$3
  extends InputStream
{
  GwtWorkarounds$3(GwtWorkarounds.ByteInput paramByteInput) {}
  
  public int read()
    throws IOException
  {
    return val$input.read();
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    Preconditions.checkNotNull(b);
    Preconditions.checkPositionIndexes(off, off + len, b.length);
    if (len == 0) {
      return 0;
    }
    int firstByte = read();
    if (firstByte == -1) {
      return -1;
    }
    b[off] = ((byte)firstByte);
    for (int dst = 1; dst < len; dst++)
    {
      int readByte = read();
      if (readByte == -1) {
        return dst;
      }
      b[(off + dst)] = ((byte)readByte);
    }
    return len;
  }
  
  public void close()
    throws IOException
  {
    val$input.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.GwtWorkarounds.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */