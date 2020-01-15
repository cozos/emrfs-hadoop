package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class DemuxOutputStream
  extends OutputStream
{
  private final InheritableThreadLocal<OutputStream> m_streams = new InheritableThreadLocal();
  
  public OutputStream bindStream(OutputStream output)
  {
    OutputStream stream = (OutputStream)m_streams.get();
    m_streams.set(output);
    return stream;
  }
  
  public void close()
    throws IOException
  {
    OutputStream output = (OutputStream)m_streams.get();
    if (null != output) {
      output.close();
    }
  }
  
  public void flush()
    throws IOException
  {
    OutputStream output = (OutputStream)m_streams.get();
    if (null != output) {
      output.flush();
    }
  }
  
  public void write(int ch)
    throws IOException
  {
    OutputStream output = (OutputStream)m_streams.get();
    if (null != output) {
      output.write(ch);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.output.DemuxOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */