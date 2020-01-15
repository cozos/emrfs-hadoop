package com.amazon.ws.emr.hadoop.fs.s3.lite.factory;

import com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3EncryptionConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3EncryptionClient;

public abstract interface S3EncryptionClientFactory
  extends S3Factory<AmazonS3EncryptionClient, S3EncryptionConfiguration>
{}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.factory.S3EncryptionClientFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */