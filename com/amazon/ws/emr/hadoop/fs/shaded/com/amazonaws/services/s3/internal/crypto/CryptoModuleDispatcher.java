package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMS;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3Direct;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoMode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutInstructionFileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class CryptoModuleDispatcher
  extends S3CryptoModule<MultipartUploadContext>
{
  private final CryptoMode defaultCryptoMode;
  private final S3CryptoModuleEO eo;
  private final S3CryptoModuleAE ae;
  
  public CryptoModuleDispatcher(AWSKMS kms, S3Direct s3, AWSCredentialsProvider credentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfig)
  {
    cryptoConfig = cryptoConfig.clone();
    CryptoMode cryptoMode = cryptoConfig.getCryptoMode();
    if (cryptoMode == null)
    {
      cryptoMode = CryptoMode.EncryptionOnly;
      cryptoConfig.setCryptoMode(cryptoMode);
    }
    cryptoConfig = cryptoConfig.readOnly();
    defaultCryptoMode = cryptoConfig.getCryptoMode();
    switch (defaultCryptoMode)
    {
    case StrictAuthenticatedEncryption: 
      ae = new S3CryptoModuleAEStrict(kms, s3, credentialsProvider, encryptionMaterialsProvider, cryptoConfig);
      
      eo = null;
      break;
    case AuthenticatedEncryption: 
      ae = new S3CryptoModuleAE(kms, s3, credentialsProvider, encryptionMaterialsProvider, cryptoConfig);
      
      eo = null;
      break;
    case EncryptionOnly: 
      eo = new S3CryptoModuleEO(kms, s3, credentialsProvider, encryptionMaterialsProvider, cryptoConfig);
      
      CryptoConfiguration aeConfig = cryptoConfig.clone();
      try
      {
        aeConfig.setCryptoMode(CryptoMode.AuthenticatedEncryption);
      }
      catch (UnsupportedOperationException localUnsupportedOperationException) {}
      ae = new S3CryptoModuleAE(kms, s3, credentialsProvider, encryptionMaterialsProvider, aeConfig.readOnly());
      break;
    default: 
      throw new IllegalStateException();
    }
  }
  
  public PutObjectResult putObjectSecurely(PutObjectRequest putObjectRequest)
  {
    return defaultCryptoMode == CryptoMode.EncryptionOnly ? eo
      .putObjectSecurely(putObjectRequest) : ae
      .putObjectSecurely(putObjectRequest);
  }
  
  public S3Object getObjectSecurely(GetObjectRequest req)
  {
    return ae.getObjectSecurely(req);
  }
  
  public ObjectMetadata getObjectSecurely(GetObjectRequest req, File destinationFile)
  {
    return ae.getObjectSecurely(req, destinationFile);
  }
  
  public CompleteMultipartUploadResult completeMultipartUploadSecurely(CompleteMultipartUploadRequest req)
    throws SdkClientException, AmazonServiceException
  {
    return defaultCryptoMode == CryptoMode.EncryptionOnly ? eo
      .completeMultipartUploadSecurely(req) : ae
      .completeMultipartUploadSecurely(req);
  }
  
  public void abortMultipartUploadSecurely(AbortMultipartUploadRequest req)
  {
    if (defaultCryptoMode == CryptoMode.EncryptionOnly) {
      eo.abortMultipartUploadSecurely(req);
    } else {
      ae.abortMultipartUploadSecurely(req);
    }
  }
  
  public InitiateMultipartUploadResult initiateMultipartUploadSecurely(InitiateMultipartUploadRequest req)
    throws SdkClientException, AmazonServiceException
  {
    return defaultCryptoMode == CryptoMode.EncryptionOnly ? eo
      .initiateMultipartUploadSecurely(req) : ae
      .initiateMultipartUploadSecurely(req);
  }
  
  public UploadPartResult uploadPartSecurely(UploadPartRequest req)
    throws SdkClientException, AmazonServiceException
  {
    return defaultCryptoMode == CryptoMode.EncryptionOnly ? eo
      .uploadPartSecurely(req) : ae
      .uploadPartSecurely(req);
  }
  
  public CopyPartResult copyPartSecurely(CopyPartRequest req)
  {
    return defaultCryptoMode == CryptoMode.EncryptionOnly ? eo
      .copyPartSecurely(req) : ae
      .copyPartSecurely(req);
  }
  
  public PutObjectResult putInstructionFileSecurely(PutInstructionFileRequest req)
  {
    return defaultCryptoMode == CryptoMode.EncryptionOnly ? eo
      .putInstructionFileSecurely(req) : ae
      .putInstructionFileSecurely(req);
  }
  
  public void putLocalObjectSecurely(UploadObjectRequest req, String uploadId, OutputStream os)
    throws IOException
  {
    if (defaultCryptoMode == CryptoMode.EncryptionOnly) {
      eo.putLocalObjectSecurely(req, uploadId, os);
    } else {
      ae.putLocalObjectSecurely(req, uploadId, os);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.CryptoModuleDispatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */