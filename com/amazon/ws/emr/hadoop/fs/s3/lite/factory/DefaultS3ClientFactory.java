package com.amazon.ws.emr.hadoop.fs.s3.lite.factory;

import com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3Configuration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Client;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

@Immutable
@ThreadSafe
final class DefaultS3ClientFactory
  implements S3ClientFactory
{
  public AmazonS3Client newS3(S3Configuration s3Configuration)
  {
    if (s3Configuration.hasClientConfiguration()) {
      return new AmazonS3Client(s3Configuration
        .getAwsCredentialsProvider(), s3Configuration
        .getClientConfiguration());
    }
    return new AmazonS3Client(s3Configuration
      .getAwsCredentialsProvider());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.factory.DefaultS3ClientFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */