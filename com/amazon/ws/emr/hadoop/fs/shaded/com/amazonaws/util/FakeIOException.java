package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import java.io.IOException;

public class FakeIOException
  extends IOException
{
  private static final long serialVersionUID = 1L;
  
  public FakeIOException(String message)
  {
    super(message);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.FakeIOException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */