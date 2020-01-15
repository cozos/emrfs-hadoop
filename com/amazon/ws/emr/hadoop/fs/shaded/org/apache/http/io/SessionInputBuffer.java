package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.io.IOException;

public abstract interface SessionInputBuffer
{
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract int read(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract int read()
    throws IOException;
  
  public abstract int readLine(CharArrayBuffer paramCharArrayBuffer)
    throws IOException;
  
  public abstract String readLine()
    throws IOException;
  
  @Deprecated
  public abstract boolean isDataAvailable(int paramInt)
    throws IOException;
  
  public abstract HttpTransportMetrics getMetrics();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionInputBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */