package com.amazon.ws.emr.hadoop.fs.s3.lite;

import com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3Configuration;
import com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3EncryptionConfiguration;
import com.amazon.ws.emr.hadoop.fs.s3.lite.executor.S3CallOverrider;
import java.util.List;

public abstract interface AmazonS3LiteClientFactory
{
  public abstract AmazonS3Lite newClient(S3Configuration paramS3Configuration1, S3Configuration paramS3Configuration2, String paramString, List<S3CallOverrider> paramList);
  
  public abstract AmazonS3Lite newClient(S3Configuration paramS3Configuration, String paramString, List<S3CallOverrider> paramList);
  
  public abstract AmazonS3Lite newClient(S3Configuration paramS3Configuration, String paramString);
  
  public abstract AmazonS3EncryptionLite newEncryptionClient(S3EncryptionConfiguration paramS3EncryptionConfiguration, String paramString, List<S3CallOverrider> paramList);
  
  public abstract AmazonS3EncryptionLite newEncryptionClient(S3EncryptionConfiguration paramS3EncryptionConfiguration1, S3EncryptionConfiguration paramS3EncryptionConfiguration2, String paramString, List<S3CallOverrider> paramList);
  
  public abstract AmazonS3EncryptionLite newEncryptionClient(S3EncryptionConfiguration paramS3EncryptionConfiguration, String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3LiteClientFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */