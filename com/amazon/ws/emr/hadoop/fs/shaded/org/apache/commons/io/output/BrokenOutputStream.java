package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class BrokenOutputStream
  extends OutputStream
{
  private final IOException exception;
  
  public BrokenOutputStream(IOException exception)
  {
    this.exception = exception;
  }
  
  public BrokenOutputStream()
  {
    this(new IOException("Broken output stream"));
  }
  
  public void write(int b)
    throws IOException
  {
    throw exception;
  }
  
  public void flush()
    throws IOException
  {
    throw exception;
  }
  
  public void close()
    throws IOException
  {
    throw exception;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.output.BrokenOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */