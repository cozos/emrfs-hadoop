package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMS;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3Direct;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoMode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import java.io.File;

class S3CryptoModuleEO
  extends S3CryptoModuleBase<MultipartUploadCbcContext>
{
  S3CryptoModuleEO(AWSKMS kms, S3Direct s3, AWSCredentialsProvider credentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfig)
  {
    super(kms, s3, credentialsProvider, encryptionMaterialsProvider, cryptoConfig);
    if (cryptoConfig.getCryptoMode() != CryptoMode.EncryptionOnly) {
      throw new IllegalArgumentException();
    }
  }
  
  S3CryptoModuleEO(S3Direct s3, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfig)
  {
    this(null, s3, new DefaultAWSCredentialsProviderChain(), encryptionMaterialsProvider, cryptoConfig);
  }
  
  S3CryptoModuleEO(AWSKMS kms, S3Direct s3, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfig)
  {
    this(kms, s3, new DefaultAWSCredentialsProviderChain(), encryptionMaterialsProvider, cryptoConfig);
  }
  
  public S3Object getObjectSecurely(GetObjectRequest getObjectRequest)
  {
    throw new IllegalStateException();
  }
  
  public ObjectMetadata getObjectSecurely(GetObjectRequest getObjectRequest, File destinationFile)
  {
    throw new IllegalStateException();
  }
  
  final MultipartUploadCbcContext newUploadContext(InitiateMultipartUploadRequest req, ContentCryptoMaterial cekMaterial)
  {
    MultipartUploadCbcContext encryptedUploadContext = new MultipartUploadCbcContext(req.getBucketName(), req.getKey(), cekMaterial);
    byte[] iv = cekMaterial.getCipherLite().getIV();
    encryptedUploadContext.setNextInitializationVector(iv);
    return encryptedUploadContext;
  }
  
  final void updateUploadContext(MultipartUploadCbcContext uploadContext, SdkFilterInputStream is)
  {
    ByteRangeCapturingInputStream bis = (ByteRangeCapturingInputStream)is;
    uploadContext.setNextInitializationVector(bis.getBlock());
  }
  
  final ByteRangeCapturingInputStream wrapForMultipart(CipherLiteInputStream is, long partSize)
  {
    int blockSize = contentCryptoScheme.getBlockSizeInBytes();
    return new ByteRangeCapturingInputStream(is, partSize - blockSize, partSize);
  }
  
  final long computeLastPartSize(UploadPartRequest request)
  {
    long plaintextLength;
    if (request.getFile() != null)
    {
      long plaintextLength;
      if (request.getPartSize() > 0L) {
        plaintextLength = request.getPartSize();
      } else {
        plaintextLength = request.getFile().length();
      }
    }
    else
    {
      long plaintextLength;
      if (request.getInputStream() != null) {
        plaintextLength = request.getPartSize();
      } else {
        return -1L;
      }
    }
    long plaintextLength;
    long cipherBlockSize = contentCryptoScheme.getBlockSizeInBytes();
    long offset = cipherBlockSize - plaintextLength % cipherBlockSize;
    return plaintextLength + offset;
  }
  
  final CipherLite cipherLiteForNextPart(MultipartUploadCbcContext uploadContext)
  {
    CipherLite cipherLite = uploadContext.getCipherLite();
    byte[] nextIV = uploadContext.getNextInitializationVector();
    return cipherLite.createUsingIV(nextIV);
  }
  
  protected final long ciphertextLength(long plaintextLength)
  {
    long cipherBlockSize = contentCryptoScheme.getBlockSizeInBytes();
    long offset = cipherBlockSize - plaintextLength % cipherBlockSize;
    return plaintextLength + offset;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.S3CryptoModuleEO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */