package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

abstract class ContentCryptoScheme
{
  static final long MAX_GCM_BLOCKS = 4294967294L;
  static final long MAX_GCM_BYTES = 68719476704L;
  static final long MAX_CBC_BYTES = 4503599627370496L;
  static final long MAX_CTR_BYTES = -1L;
  static final ContentCryptoScheme AES_CBC = new AesCbc();
  static final ContentCryptoScheme AES_GCM = new AesGcm();
  static final ContentCryptoScheme AES_CTR = new AesCtr();
  
  abstract String getKeyGeneratorAlgorithm();
  
  abstract String getCipherAlgorithm();
  
  String getPreferredCipherProvider()
  {
    return null;
  }
  
  abstract int getKeyLengthInBits();
  
  abstract int getBlockSizeInBytes();
  
  abstract int getIVLengthInBytes();
  
  int getTagLengthInBits()
  {
    return 0;
  }
  
  byte[] adjustIV(byte[] iv, long startingBytePos)
  {
    return iv;
  }
  
  public String toString()
  {
    return 
    
      "cipherAlgo=" + getCipherAlgorithm() + ", blockSizeInBytes=" + getBlockSizeInBytes() + ", ivLengthInBytes=" + getIVLengthInBytes() + ", keyGenAlgo=" + getKeyGeneratorAlgorithm() + ", keyLengthInBits=" + getKeyLengthInBits() + ", preferredProvider=" + getPreferredCipherProvider() + ", tagLengthInBits=" + getTagLengthInBits();
  }
  
  static byte[] incrementBlocks(byte[] counter, long blockDelta)
  {
    if (blockDelta == 0L) {
      return counter;
    }
    if ((counter == null) || (counter.length != 16)) {
      throw new IllegalArgumentException();
    }
    if (blockDelta > 4294967294L) {
      throw new IllegalStateException();
    }
    ByteBuffer bb = ByteBuffer.allocate(8);
    for (int i = 12; i <= 15; i++) {
      bb.put(i - 8, counter[i]);
    }
    long val = bb.getLong() + blockDelta;
    if (val > 4294967294L) {
      throw new IllegalStateException();
    }
    bb.rewind();
    
    byte[] result = bb.putLong(val).array();
    for (int i = 12; i <= 15; i++) {
      counter[i] = result[(i - 8)];
    }
    return counter;
  }
  
  static ContentCryptoScheme fromCEKAlgo(String cekAlgo)
  {
    return fromCEKAlgo(cekAlgo, false);
  }
  
  static ContentCryptoScheme fromCEKAlgo(String cekAlgo, boolean isRangeGet)
  {
    if (AES_GCM.getCipherAlgorithm().equals(cekAlgo)) {
      return isRangeGet ? AES_CTR : AES_GCM;
    }
    if ((cekAlgo == null) || (AES_CBC.getCipherAlgorithm().equals(cekAlgo))) {
      return AES_CBC;
    }
    throw new UnsupportedOperationException("Unsupported content encryption scheme: " + cekAlgo);
  }
  
  CipherLite createCipherLite(SecretKey cek, byte[] iv, int cipherMode, Provider provider, boolean alwaysUseProvider)
  {
    try
    {
      Cipher cipher = createCipher(provider, alwaysUseProvider);
      cipher.init(cipherMode, cek, new IvParameterSpec(iv));
      return newCipherLite(cipher, cek, cipherMode);
    }
    catch (Exception e)
    {
      throw ((e instanceof RuntimeException) ? (RuntimeException)e : new SdkClientException("Unable to build cipher: " + e.getMessage() + "\nMake sure you have the JCE unlimited strength policy files installed and configured for your JVM", e));
    }
  }
  
  private Cipher createCipher(Provider provider, boolean alwaysUseProvider)
    throws GeneralSecurityException
  {
    String algorithm = getCipherAlgorithm();
    String preferredProvider = getPreferredCipherProvider();
    if (alwaysUseProvider) {
      return Cipher.getInstance(algorithm, provider);
    }
    if (preferredProvider != null) {
      return Cipher.getInstance(algorithm, preferredProvider);
    }
    if (provider != null) {
      return Cipher.getInstance(algorithm, provider);
    }
    return Cipher.getInstance(algorithm);
  }
  
  protected CipherLite newCipherLite(Cipher cipher, SecretKey cek, int cipherMode)
  {
    return new CipherLite(cipher, this, cek, cipherMode);
  }
  
  CipherLite createAuxillaryCipher(SecretKey cek, byte[] iv, int cipherMode, Provider securityProvider, long startingBytePos)
    throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException
  {
    return null;
  }
  
  CipherLite createCipherLite(SecretKey cek, byte[] iv, int cipherMode)
    throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException
  {
    return createCipherLite(cek, iv, cipherMode, null, false);
  }
  
  abstract long getMaxPlaintextSize();
  
  final String getKeySpec()
  {
    return getKeyGeneratorAlgorithm() + "_" + getKeyLengthInBits();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */