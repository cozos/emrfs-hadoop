package com.amazon.ws.emr.hadoop.fs.s3.lite.factory;

import com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3EncryptionConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3EncryptionClient;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

@Immutable
@ThreadSafe
final class DefaultS3EncryptionClientFactory
  implements S3EncryptionClientFactory
{
  public AmazonS3EncryptionClient newS3(S3EncryptionConfiguration s3EncryptionConfiguration)
  {
    if (s3EncryptionConfiguration.hasClientConfiguration()) {
      return new AmazonS3EncryptionClient(s3EncryptionConfiguration
        .getAwsCredentialsProvider(), s3EncryptionConfiguration
        .getEncryptionMaterialsProvider(), s3EncryptionConfiguration
        .getClientConfiguration(), s3EncryptionConfiguration
        .getCryptoConfiguration());
    }
    return new AmazonS3EncryptionClient(s3EncryptionConfiguration
      .getAwsCredentialsProvider(), s3EncryptionConfiguration
      .getEncryptionMaterialsProvider(), s3EncryptionConfiguration
      .getCryptoConfiguration());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.factory.DefaultS3EncryptionClientFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */