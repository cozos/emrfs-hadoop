package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import javax.crypto.Cipher;

final class CryptoRuntime$AesGcm
{
  static volatile boolean isAvailable = ;
  
  static boolean recheck()
  {
    return isAvailable = check();
  }
  
  private static boolean check()
  {
    try
    {
      Cipher.getInstance(ContentCryptoScheme.AES_GCM
        .getCipherAlgorithm(), "BC");
      
      return true;
    }
    catch (Exception e) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.CryptoRuntime.AesGcm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */