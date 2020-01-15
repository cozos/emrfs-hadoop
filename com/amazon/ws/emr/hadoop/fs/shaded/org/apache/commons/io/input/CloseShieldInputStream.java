package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input;

import java.io.InputStream;

public class CloseShieldInputStream
  extends ProxyInputStream
{
  public CloseShieldInputStream(InputStream in)
  {
    super(in);
  }
  
  public void close()
  {
    in = new ClosedInputStream();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input.CloseShieldInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */