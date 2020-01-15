package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

public enum EncodingSchemeEnum
  implements EncodingScheme
{
  BASE16,  BASE32,  BASE64;
  
  private EncodingSchemeEnum() {}
  
  public abstract String encodeAsString(byte[] paramArrayOfByte);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.EncodingSchemeEnum
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */