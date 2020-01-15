package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

final class MultipartUploadCbcContext
  extends MultipartUploadCryptoContext
{
  private byte[] nextIV;
  
  MultipartUploadCbcContext(String bucketName, String key, ContentCryptoMaterial cekMaterial)
  {
    super(bucketName, key, cekMaterial);
  }
  
  public void setNextInitializationVector(byte[] nextIV)
  {
    this.nextIV = nextIV;
  }
  
  public byte[] getNextInitializationVector()
  {
    return nextIV;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.MultipartUploadCbcContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */