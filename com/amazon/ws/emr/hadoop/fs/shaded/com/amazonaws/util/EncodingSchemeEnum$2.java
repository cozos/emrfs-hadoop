package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

 enum EncodingSchemeEnum$2
{
  EncodingSchemeEnum$2()
  {
    super(paramString, paramInt, null);
  }
  
  public String encodeAsString(byte[] bytes)
  {
    return Base32.encodeAsString(bytes);
  }
  
  public byte[] decode(String encoded)
  {
    return Base32.decode(encoded);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.EncodingSchemeEnum.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */