package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TeeInputStream
  extends ProxyInputStream
{
  private final OutputStream branch;
  private final boolean closeBranch;
  
  public TeeInputStream(InputStream input, OutputStream branch)
  {
    this(input, branch, false);
  }
  
  public TeeInputStream(InputStream input, OutputStream branch, boolean closeBranch)
  {
    super(input);
    this.branch = branch;
    this.closeBranch = closeBranch;
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
      if (closeBranch) {
        branch.close();
      }
    }
  }
  
  public int read()
    throws IOException
  {
    int ch = super.read();
    if (ch != -1) {
      branch.write(ch);
    }
    return ch;
  }
  
  public int read(byte[] bts, int st, int end)
    throws IOException
  {
    int n = super.read(bts, st, end);
    if (n != -1) {
      branch.write(bts, st, n);
    }
    return n;
  }
  
  public int read(byte[] bts)
    throws IOException
  {
    int n = super.read(bts);
    if (n != -1) {
      branch.write(bts, 0, n);
    }
    return n;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input.TeeInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */