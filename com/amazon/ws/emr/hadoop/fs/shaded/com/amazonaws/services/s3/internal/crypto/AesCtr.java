package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

class AesCtr
  extends ContentCryptoScheme
{
  String getKeyGeneratorAlgorithm()
  {
    return AES_GCM.getKeyGeneratorAlgorithm();
  }
  
  String getCipherAlgorithm()
  {
    return "AES/CTR/NoPadding";
  }
  
  int getKeyLengthInBits()
  {
    return AES_GCM.getKeyLengthInBits();
  }
  
  int getBlockSizeInBytes()
  {
    return AES_GCM.getBlockSizeInBytes();
  }
  
  int getIVLengthInBytes()
  {
    return 16;
  }
  
  long getMaxPlaintextSize()
  {
    return -1L;
  }
  
  byte[] adjustIV(byte[] iv, long byteOffset)
  {
    if (iv.length != 12) {
      throw new UnsupportedOperationException();
    }
    int blockSize = getBlockSizeInBytes();
    long blockOffset = byteOffset / blockSize;
    if (blockOffset * blockSize != byteOffset) {
      throw new IllegalArgumentException("Expecting byteOffset to be multiple of 16, but got blockOffset=" + blockOffset + ", blockSize=" + blockSize + ", byteOffset=" + byteOffset);
    }
    byte[] J0 = computeJ0(iv);
    return incrementBlocks(J0, blockOffset);
  }
  
  private byte[] computeJ0(byte[] nonce)
  {
    int blockSize = getBlockSizeInBytes();
    byte[] J0 = new byte[blockSize];
    System.arraycopy(nonce, 0, J0, 0, nonce.length);
    J0[(blockSize - 1)] = 1;
    return incrementBlocks(J0, 1L);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.AesCtr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */