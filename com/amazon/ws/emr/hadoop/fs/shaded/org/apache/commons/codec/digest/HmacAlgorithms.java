package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.digest;

public enum HmacAlgorithms
{
  HMAC_MD5("HmacMD5"),  HMAC_SHA_1("HmacSHA1"),  HMAC_SHA_256("HmacSHA256"),  HMAC_SHA_384("HmacSHA384"),  HMAC_SHA_512("HmacSHA512");
  
  private final String algorithm;
  
  private HmacAlgorithms(String algorithm)
  {
    this.algorithm = algorithm;
  }
  
  public String toString()
  {
    return algorithm;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.digest.HmacAlgorithms
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */