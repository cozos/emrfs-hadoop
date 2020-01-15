package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

 enum EncodingSchemeEnum$1
{
  EncodingSchemeEnum$1()
  {
    super(paramString, paramInt, null);
  }
  
  public String encodeAsString(byte[] bytes)
  {
    return Base16.encodeAsString(bytes);
  }
  
  public byte[] decode(String encoded)
  {
    return Base16.decode(encoded);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.EncodingSchemeEnum.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */