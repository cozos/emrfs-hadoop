package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class SecuredCEK
{
  private final byte[] encrypted;
  private final String keyWrapAlgorithm;
  private final Map<String, String> matdesc;
  
  SecuredCEK(byte[] encryptedKey, String keyWrapAlgorithm, Map<String, String> matdesc)
  {
    encrypted = encryptedKey;
    this.keyWrapAlgorithm = keyWrapAlgorithm;
    this.matdesc = Collections.unmodifiableMap(new TreeMap(matdesc));
  }
  
  byte[] getEncrypted()
  {
    return encrypted;
  }
  
  String getKeyWrapAlgorithm()
  {
    return keyWrapAlgorithm;
  }
  
  Map<String, String> getMaterialDescription()
  {
    return matdesc;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.SecuredCEK
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */