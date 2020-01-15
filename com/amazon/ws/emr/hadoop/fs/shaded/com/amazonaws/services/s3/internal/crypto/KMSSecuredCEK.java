package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import java.util.Map;

final class KMSSecuredCEK
  extends SecuredCEK
{
  static final String KEY_PROTECTION_MECHANISM = "kms";
  
  KMSSecuredCEK(byte[] encryptedKeyBlob, Map<String, String> matdesc)
  {
    super(encryptedKeyBlob, "kms", matdesc);
  }
  
  public static boolean isKMSKeyWrapped(String keyWrapAlgo)
  {
    return "kms".equals(keyWrapAlgo);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.KMSSecuredCEK
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */