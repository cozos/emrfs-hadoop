package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMS;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3Direct;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoMode;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;

class S3CryptoModuleAEStrict
  extends S3CryptoModuleAE
{
  S3CryptoModuleAEStrict(AWSKMS kms, S3Direct s3, AWSCredentialsProvider credentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfig)
  {
    super(kms, s3, credentialsProvider, encryptionMaterialsProvider, cryptoConfig);
    if (cryptoConfig.getCryptoMode() != CryptoMode.StrictAuthenticatedEncryption) {
      throw new IllegalArgumentException();
    }
  }
  
  protected final boolean isStrict()
  {
    return true;
  }
  
  protected void securityCheck(ContentCryptoMaterial cekMaterial, S3ObjectWrapper retrieved)
  {
    if (!ContentCryptoScheme.AES_GCM.equals(cekMaterial.getContentCryptoScheme())) {
      throw new SecurityException("S3 object [bucket: " + retrieved.getBucketName() + ", key: " + retrieved.getKey() + "] not encrypted using authenticated encryption");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.S3CryptoModuleAEStrict
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */