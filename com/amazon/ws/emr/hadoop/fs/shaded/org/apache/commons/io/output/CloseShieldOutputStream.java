package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.output;

import java.io.OutputStream;

public class CloseShieldOutputStream
  extends ProxyOutputStream
{
  public CloseShieldOutputStream(OutputStream out)
  {
    super(out);
  }
  
  public void close()
  {
    out = new ClosedOutputStream();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.output.CloseShieldOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */