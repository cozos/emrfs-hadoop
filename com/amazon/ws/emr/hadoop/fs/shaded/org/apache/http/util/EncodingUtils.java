package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Consts;
import java.io.UnsupportedEncodingException;

public final class EncodingUtils
{
  public static String getString(byte[] data, int offset, int length, String charset)
  {
    Args.notNull(data, "Input");
    Args.notEmpty(charset, "Charset");
    try
    {
      return new String(data, offset, length, charset);
    }
    catch (UnsupportedEncodingException e) {}
    return new String(data, offset, length);
  }
  
  public static String getString(byte[] data, String charset)
  {
    Args.notNull(data, "Input");
    return getString(data, 0, data.length, charset);
  }
  
  public static byte[] getBytes(String data, String charset)
  {
    Args.notNull(data, "Input");
    Args.notEmpty(charset, "Charset");
    try
    {
      return data.getBytes(charset);
    }
    catch (UnsupportedEncodingException e) {}
    return data.getBytes();
  }
  
  public static byte[] getAsciiBytes(String data)
  {
    Args.notNull(data, "Input");
    return data.getBytes(Consts.ASCII);
  }
  
  public static String getAsciiString(byte[] data, int offset, int length)
  {
    Args.notNull(data, "Input");
    return new String(data, offset, length, Consts.ASCII);
  }
  
  public static String getAsciiString(byte[] data)
  {
    Args.notNull(data, "Input");
    return getAsciiString(data, 0, data.length);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.EncodingUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */