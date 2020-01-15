package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetUtils
{
  public static Charset lookup(String name)
  {
    if (name == null) {
      return null;
    }
    try
    {
      return Charset.forName(name);
    }
    catch (UnsupportedCharsetException ex) {}
    return null;
  }
  
  public static Charset get(String name)
    throws UnsupportedEncodingException
  {
    if (name == null) {
      return null;
    }
    try
    {
      return Charset.forName(name);
    }
    catch (UnsupportedCharsetException ex)
    {
      throw new UnsupportedEncodingException(name);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharsetUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */