package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

 enum EncodingSchemeEnum$3
{
  EncodingSchemeEnum$3()
  {
    super(paramString, paramInt, null);
  }
  
  public String encodeAsString(byte[] bytes)
  {
    return Base64.encodeAsString(bytes);
  }
  
  public byte[] decode(String encoded)
  {
    return Base64.decode(encoded);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.EncodingSchemeEnum.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */