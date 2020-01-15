package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.UnsupportedEncodingException;

public class Internal
{
  public static String stringDefaultValue(String bytes)
  {
    try
    {
      return new String(bytes.getBytes("ISO-8859-1"), "UTF-8");
    }
    catch (UnsupportedEncodingException e)
    {
      throw new IllegalStateException("Java VM does not support a standard character set.", e);
    }
  }
  
  public static ByteString bytesDefaultValue(String bytes)
  {
    try
    {
      return ByteString.copyFrom(bytes.getBytes("ISO-8859-1"));
    }
    catch (UnsupportedEncodingException e)
    {
      throw new IllegalStateException("Java VM does not support a standard character set.", e);
    }
  }
  
  public static boolean isValidUtf8(ByteString byteString)
  {
    return byteString.isValidUtf8();
  }
  
  public static abstract interface EnumLiteMap<T extends Internal.EnumLite>
  {
    public abstract T findValueByNumber(int paramInt);
  }
  
  public static abstract interface EnumLite
  {
    public abstract int getNumber();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Internal
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */