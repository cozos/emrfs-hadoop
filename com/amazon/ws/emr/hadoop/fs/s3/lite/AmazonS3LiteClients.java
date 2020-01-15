package com.amazon.ws.emr.hadoop.fs.s3.lite;

import com.amazon.ws.emr.hadoop.fs.s3.lite.bucket.BucketRegionStores;
import com.amazon.ws.emr.hadoop.fs.s3.lite.executor.SimpleS3Executor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

public final class AmazonS3LiteClients
{
  private static final AmazonS3LiteClientFactory defaultFactory = new DefaultAmazonS3LiteClientFactory(
    BucketRegionStores.inMemoryStore());
  
  private AmazonS3LiteClients()
  {
    throw new AssertionError();
  }
  
  @VisibleForTesting
  public static AmazonS3Lite newClient(AmazonS3 client)
  {
    Preconditions.checkNotNull(client, "Client is required");
    return new AmazonS3LiteClient(new SimpleS3Executor(client));
  }
  
  public static AmazonS3LiteClientFactory defaultFactory()
  {
    return defaultFactory;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3LiteClients
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */