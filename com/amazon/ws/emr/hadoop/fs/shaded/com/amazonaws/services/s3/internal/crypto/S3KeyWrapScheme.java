package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import java.security.Key;

class S3KeyWrapScheme
{
  static final S3KeyWrapScheme NONE = new S3KeyWrapScheme()
  {
    String getKeyWrapAlgorithm(Key key)
    {
      return null;
    }
    
    public String toString()
    {
      return "NONE";
    }
  };
  public static final String AESWrap = "AESWrap";
  public static final String RSA_ECB_OAEPWithSHA256AndMGF1Padding = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
  
  String getKeyWrapAlgorithm(Key kek)
  {
    String algorithm = kek.getAlgorithm();
    if ("AES".equals(algorithm)) {
      return "AESWrap";
    }
    if (("RSA".equals(algorithm)) && 
      (CryptoRuntime.isRsaKeyWrapAvailable())) {
      return "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    }
    return null;
  }
  
  public String toString()
  {
    return "S3KeyWrapScheme";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.S3KeyWrapScheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */