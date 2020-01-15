package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

public abstract interface EncodingScheme
{
  public abstract String encodeAsString(byte[] paramArrayOfByte);
  
  public abstract byte[] decode(String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.EncodingScheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */