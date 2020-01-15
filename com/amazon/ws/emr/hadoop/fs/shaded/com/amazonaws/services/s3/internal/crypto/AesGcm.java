package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

class AesGcm
  extends ContentCryptoScheme
{
  String getKeyGeneratorAlgorithm()
  {
    return "AES";
  }
  
  String getCipherAlgorithm()
  {
    return "AES/GCM/NoPadding";
  }
  
  int getKeyLengthInBits()
  {
    return 256;
  }
  
  int getBlockSizeInBytes()
  {
    return 16;
  }
  
  int getIVLengthInBytes()
  {
    return 12;
  }
  
  long getMaxPlaintextSize()
  {
    return 68719476704L;
  }
  
  int getTagLengthInBits()
  {
    return 128;
  }
  
  String getPreferredCipherProvider()
  {
    return "BC";
  }
  
  CipherLite createAuxillaryCipher(SecretKey cek, byte[] ivOrig, int cipherMode, Provider securityProvider, long startingBytePos)
    throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException
  {
    byte[] iv = AES_CTR.adjustIV(ivOrig, startingBytePos);
    return AES_CTR.createCipherLite(cek, iv, cipherMode, securityProvider, false);
  }
  
  protected CipherLite newCipherLite(Cipher cipher, SecretKey cek, int cipherMode)
  {
    return new GCMCipherLite(cipher, cek, cipherMode);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.AesGcm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */