package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public class StringInputStream
  extends ByteArrayInputStream
{
  private final String string;
  
  public StringInputStream(String s)
    throws UnsupportedEncodingException
  {
    super(s.getBytes(StringUtils.UTF8));
    string = s;
  }
  
  public String getString()
  {
    return string;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */