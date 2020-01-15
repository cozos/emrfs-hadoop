package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.io.IOException;

public abstract interface SessionOutputBuffer
{
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void write(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract void write(int paramInt)
    throws IOException;
  
  public abstract void writeLine(String paramString)
    throws IOException;
  
  public abstract void writeLine(CharArrayBuffer paramCharArrayBuffer)
    throws IOException;
  
  public abstract void flush()
    throws IOException;
  
  public abstract HttpTransportMetrics getMetrics();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */