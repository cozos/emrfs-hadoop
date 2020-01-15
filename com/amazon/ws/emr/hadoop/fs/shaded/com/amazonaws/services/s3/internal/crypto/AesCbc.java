package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

class AesCbc
  extends ContentCryptoScheme
{
  String getKeyGeneratorAlgorithm()
  {
    return "AES";
  }
  
  String getCipherAlgorithm()
  {
    return "AES/CBC/PKCS5Padding";
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
    return 16;
  }
  
  long getMaxPlaintextSize()
  {
    return 4503599627370496L;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.AesCbc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */