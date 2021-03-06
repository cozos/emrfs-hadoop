package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class TeeOutputStream
  extends ProxyOutputStream
{
  protected OutputStream branch;
  
  public TeeOutputStream(OutputStream out, OutputStream branch)
  {
    super(out);
    this.branch = branch;
  }
  
  public synchronized void write(byte[] b)
    throws IOException
  {
    super.write(b);
    branch.write(b);
  }
  
  public synchronized void write(byte[] b, int off, int len)
    throws IOException
  {
    super.write(b, off, len);
    branch.write(b, off, len);
  }
  
  public synchronized void write(int b)
    throws IOException
  {
    super.write(b);
    branch.write(b);
  }
  
  public void flush()
    throws IOException
  {
    super.flush();
    branch.flush();
  }
  
  public void close()
    throws IOException
  {
    try
    {
      super.close();
    }
    finally
    {
      branch.close();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.output.TeeOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */