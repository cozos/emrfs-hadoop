package com.amazon.ws.emr.hadoop.fs.s3.lite.factory;

import com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3Configuration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Client;

public abstract interface S3ClientFactory
  extends S3Factory<AmazonS3Client, S3Configuration>
{}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.factory.S3ClientFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */