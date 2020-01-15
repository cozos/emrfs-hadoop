package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class DemuxInputStream
  extends InputStream
{
  private final InheritableThreadLocal<InputStream> m_streams = new InheritableThreadLocal();
  
  public InputStream bindStream(InputStream input)
  {
    InputStream oldValue = (InputStream)m_streams.get();
    m_streams.set(input);
    return oldValue;
  }
  
  public void close()
    throws IOException
  {
    InputStream input = (InputStream)m_streams.get();
    if (null != input) {
      input.close();
    }
  }
  
  public int read()
    throws IOException
  {
    InputStream input = (InputStream)m_streams.get();
    if (null != input) {
      return input.read();
    }
    return -1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input.DemuxInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */