package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import javax.crypto.Cipher;

final class CryptoRuntime$RsaEcbOaepWithSHA256AndMGF1Padding
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
      Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", "BC");
      
      return true;
    }
    catch (Exception e) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.CryptoRuntime.RsaEcbOaepWithSHA256AndMGF1Padding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */