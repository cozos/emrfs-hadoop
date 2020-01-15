package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.GuardedBy;

class MultipartUploadCryptoContext
  extends MultipartUploadContext
{
  private final ContentCryptoMaterial cekMaterial;
  @GuardedBy("this")
  private int partNumber;
  private volatile boolean partUploadInProgress;
  
  MultipartUploadCryptoContext(String bucketName, String key, ContentCryptoMaterial cekMaterial)
  {
    super(bucketName, key);
    this.cekMaterial = cekMaterial;
  }
  
  CipherLite getCipherLite()
  {
    return cekMaterial.getCipherLite();
  }
  
  ContentCryptoMaterial getContentCryptoMaterial()
  {
    return cekMaterial;
  }
  
  void beginPartUpload(int nextPartNumber)
    throws SdkClientException
  {
    if (nextPartNumber < 1) {
      throw new IllegalArgumentException("part number must be at least 1");
    }
    if (partUploadInProgress) {
      throw new SdkClientException("Parts are required to be uploaded in series");
    }
    synchronized (this)
    {
      if (nextPartNumber - partNumber <= 1)
      {
        partNumber = nextPartNumber;
        partUploadInProgress = true;
      }
      else
      {
        throw new SdkClientException("Parts are required to be uploaded in series (partNumber=" + partNumber + ", nextPartNumber=" + nextPartNumber + ")");
      }
    }
  }
  
  void endPartUpload()
  {
    partUploadInProgress = false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.MultipartUploadCryptoContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */