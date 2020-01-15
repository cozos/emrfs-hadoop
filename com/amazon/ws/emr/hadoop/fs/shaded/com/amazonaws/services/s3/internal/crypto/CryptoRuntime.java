package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;

public class CryptoRuntime
{
  static final String BOUNCY_CASTLE_PROVIDER = "BC";
  private static final String BC_PROVIDER_FQCN = "org.bouncycastle.jce.provider.BouncyCastleProvider";
  
  public static synchronized boolean isBouncyCastleAvailable()
  {
    return Security.getProvider("BC") != null;
  }
  
  public static synchronized void enableBouncyCastle()
  {
    if (isBouncyCastleAvailable()) {
      return;
    }
    try
    {
      Class<Provider> c = Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider");
      Provider provider = (Provider)c.newInstance();
      Security.addProvider(provider);
    }
    catch (Exception e)
    {
      LogFactory.getLog(CryptoRuntime.class).debug("Bouncy Castle not available", e);
    }
  }
  
  static void recheck()
  {
    recheckAesGcmAvailablility();
    recheckRsaKeyWrapAvailablility();
  }
  
  public static boolean isAesGcmAvailable()
  {
    return AesGcm.isAvailable;
  }
  
  public static void recheckAesGcmAvailablility()
  {
    AesGcm.recheck();
  }
  
  static boolean isRsaKeyWrapAvailable()
  {
    return RsaEcbOaepWithSHA256AndMGF1Padding.isAvailable;
  }
  
  private static void recheckRsaKeyWrapAvailablility()
  {
    RsaEcbOaepWithSHA256AndMGF1Padding.recheck();
  }
  
  private static final class AesGcm
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
  
  private static final class RsaEcbOaepWithSHA256AndMGF1Padding
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.CryptoRuntime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */