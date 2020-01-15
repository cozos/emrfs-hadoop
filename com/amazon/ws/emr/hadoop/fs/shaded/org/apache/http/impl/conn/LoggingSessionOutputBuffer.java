package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Consts;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpTransportMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.io.IOException;
import java.nio.charset.Charset;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class LoggingSessionOutputBuffer
  implements SessionOutputBuffer
{
  private final SessionOutputBuffer out;
  private final Wire wire;
  private final String charset;
  
  public LoggingSessionOutputBuffer(SessionOutputBuffer out, Wire wire, String charset)
  {
    this.out = out;
    this.wire = wire;
    this.charset = (charset != null ? charset : Consts.ASCII.name());
  }
  
  public LoggingSessionOutputBuffer(SessionOutputBuffer out, Wire wire)
  {
    this(out, wire, null);
  }
  
  public void write(byte[] b, int off, int len)
    throws IOException
  {
    out.write(b, off, len);
    if (wire.enabled()) {
      wire.output(b, off, len);
    }
  }
  
  public void write(int b)
    throws IOException
  {
    out.write(b);
    if (wire.enabled()) {
      wire.output(b);
    }
  }
  
  public void write(byte[] b)
    throws IOException
  {
    out.write(b);
    if (wire.enabled()) {
      wire.output(b);
    }
  }
  
  public void flush()
    throws IOException
  {
    out.flush();
  }
  
  public void writeLine(CharArrayBuffer buffer)
    throws IOException
  {
    out.writeLine(buffer);
    if (wire.enabled())
    {
      String s = new String(buffer.buffer(), 0, buffer.length());
      String tmp = s + "\r\n";
      wire.output(tmp.getBytes(charset));
    }
  }
  
  public void writeLine(String s)
    throws IOException
  {
    out.writeLine(s);
    if (wire.enabled())
    {
      String tmp = s + "\r\n";
      wire.output(tmp.getBytes(charset));
    }
  }
  
  public HttpTransportMetrics getMetrics()
  {
    return out.getMetrics();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.LoggingSessionOutputBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */