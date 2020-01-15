package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMS;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;

@Immutable
@SdkInternalApi
public final class AmazonS3EncryptionClientParamsWrapper
  extends AmazonS3EncryptionClientParams
{
  private final EncryptionMaterialsProvider encryptionMaterials;
  private final CryptoConfiguration cryptoConfiguration;
  private final AWSKMS kms;
  private final AwsSyncClientParams getClientParams;
  private final S3ClientOptions getS3ClientOptions;
  
  AmazonS3EncryptionClientParamsWrapper(AwsSyncClientParams getClientParams, S3ClientOptions getS3ClientOptions, EncryptionMaterialsProvider encryptionMaterials, CryptoConfiguration cryptoConfiguration, AWSKMS kms)
  {
    this.encryptionMaterials = encryptionMaterials;
    this.cryptoConfiguration = cryptoConfiguration;
    this.kms = kms;
    this.getClientParams = getClientParams;
    this.getS3ClientOptions = getS3ClientOptions;
  }
  
  EncryptionMaterialsProvider getEncryptionMaterials()
  {
    return encryptionMaterials;
  }
  
  CryptoConfiguration getCryptoConfiguration()
  {
    return cryptoConfiguration;
  }
  
  AWSKMS getKmsClient()
  {
    return kms;
  }
  
  public AwsSyncClientParams getClientParams()
  {
    return getClientParams;
  }
  
  public S3ClientOptions getS3ClientOptions()
  {
    return getS3ClientOptions;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3EncryptionClientParamsWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */